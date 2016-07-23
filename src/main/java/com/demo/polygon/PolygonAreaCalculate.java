/**
 * PolygonAreaCalculate.java
 * Created on  12/1/2016 7:55 PM
 * modify on                user            modify content
 * 12/1/2016 7:55 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.polygon;

import ch.hsr.geohash.BoundingBox;
import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import ch.hsr.geohash.util.VincentyGeodesy;
import clover.org.apache.commons.lang.math.NumberUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.util.CollectionUtils;

import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by micx  on 2016/01/12 7:55 PM.
 */
public class PolygonAreaCalculate {
    private static final int POOL_SIZE = 30;
    private static final int PAGE_SIZE = 50;
    private static ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    private static final String RPATH = "/Users/micx/file/polygon/sh.shop";
    private static BlockingQueue<ShopResult> queue = new LinkedBlockingDeque<ShopResult>();
    private static AtomicInteger cnt = new AtomicInteger();
    public static void main(String[] args) {
        try {
//            char c = 'a';
//            for (int i = 0; i < 20; i++) {
                readFile(RPATH);
//                c++;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String path) throws IOException {
        File file=new File(path);
        if(!file.exists()||file.isDirectory()) {
            throw new FileNotFoundException();
        }
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        temp=br.readLine();
        java.util.List<ShopInfo> list = Lists.newArrayList();
        long t = System.currentTimeMillis();
        while(temp!=null){
            temp=br.readLine();
            ShopInfo shop = parse(temp);
            list.add(shop);
        }
        int pageCnt = (int) Math.ceil(1.0 * list.size()/PAGE_SIZE);
        CountDownLatch latch = new CountDownLatch(pageCnt);
        System.out.println(pageCnt);
        for (int i = 0; i < pageCnt; i++) {
            int start = 0 + i* PAGE_SIZE;
            int end = Math.min(start +  PAGE_SIZE, list.size());
            java.util.List<ShopInfo> shopInfos = list.subList(start, end);
            CalcTask task = new CalcTask(shopInfos, latch);
            executor.submit(task);
        }
        try {
            latch.await();
            System.out.println("success process all task, total records:"+queue.size());
            Map<Integer, ShopResult> map = Maps.newHashMap();
            while (queue.isEmpty() == false){
                ShopResult result = queue.poll();
                ShopResult shopResult = map.get(result.getShopId());
                if (shopResult == null) {
                    if (CollectionUtils.isEmpty(result.getMtAreas())){
                        result.setMtAreas(new ArrayList<java.util.List<Integer>>());
                    }
                    if (CollectionUtils.isEmpty(result.getElemeAreas())){
                        result.setElemeAreas(new ArrayList<List<Integer>>());
                    }
                    map.put(result.getShopId(), result);
                }else{
                    if (CollectionUtils.isEmpty(shopResult.getMtAreas())){
                        shopResult.setMtAreas(new ArrayList<List<Integer>>());
                    }
                    if (CollectionUtils.isEmpty(shopResult.getElemeAreas())){
                        shopResult.setElemeAreas(new ArrayList<List<Integer>>());
                    }
                    if (CollectionUtils.isEmpty(result.getMtAreas()) == false) {
                        shopResult.getMtAreas().addAll(result.getMtAreas());
                    }
                    if (CollectionUtils.isEmpty(result.getElemeAreas()) == false) {
                        shopResult.getElemeAreas().addAll(result.getElemeAreas());
                    }
                    map.put(result.getShopId(), shopResult);
                }
            }

            FileWriter writer = new FileWriter(path+".result", false);
            for (ShopResult result: map.values()){
                writer.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s",result.getShopId(),
                        result.getCity(),result.getName(), result.getAddress(), result.getMtArea(), result.getElemeArea(),
                        result.getDeliveryType()
                        )+"\n");
            }
            writer.close();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.clear();
        System.out.println(String.format("total cost: %s ms", System.currentTimeMillis() - t));
    }
    private static ShopInfo parse(String temp) {
        if (temp == null){
            return null;
        }
        String[] strs = temp.split("\t");
        ShopInfo shop = new ShopInfo();
        shop.setShopId(NumberUtils.toInt(strs[0]));
        shop.setCityId(NumberUtils.toInt(strs[1]));
        shop.setName(strs[2]);
        shop.setAddress(strs[3]);
        shop.setThirdpartyId(NumberUtils.toInt(strs[4]));
        shop.setThirdpartyShopId(NumberUtils.toInt(strs[5]));
        shop.setGeoJson(strs[6]);
        shop.setDeliveryType(NumberUtils.toInt(strs[7]));
        return shop;
    }




//    ===========================Task Class==========================
static class CalcTask implements Runnable{
    private java.util.List<ShopInfo> shopList;
    private CountDownLatch latch;
    private static final double MILLION_DOUBLE = 1000000*1.0;

    public CalcTask(java.util.List<ShopInfo> shopList, CountDownLatch latch) {
        this.shopList = shopList;
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println("start"+Thread.currentThread().getId());
            processTask();
            System.out.println("end"+Thread.currentThread().getId());
        } catch (Exception e) {
            System.out.println("process failed");
        }

        latch.countDown();
        System.out.println(latch.getCount()+"\t thread:"+Thread.currentThread().getId());
    }

    private void processTask() {
        for (ShopInfo shopInfo : shopList) {
            try {
                long t = System.currentTimeMillis();
                String geoJson = shopInfo.getGeoJson();
                java.util.List<Integer> xList = Lists.newArrayList();
                java.util.List<Integer> yList = Lists.newArrayList();
                JSONObject jsonObject = JSONObject.parseObject(geoJson);
                JSONArray features = (JSONArray) jsonObject.get("features");
                java.util.List<Integer> totalArea = Lists.newArrayList();
                for (int i = 0; i < features.size(); i++) {
                    JSONObject o = (JSONObject) features.get(i);
                    JSONObject geometry = (JSONObject) o.get("geometry");
                    JSONArray coordinates = (JSONArray) geometry.get("coordinates");
                    for (int j = 0; j < coordinates.size(); j++) {
                        JSONArray o1 = (JSONArray) coordinates.get(j);
                        for (int k = 0; k < o1.size(); k++) {
                            JSONArray o2 = (JSONArray) o1.get(k);
                            BigDecimal x = (BigDecimal) o2.get(1);
                            xList.add((int) (x.doubleValue() * MILLION_DOUBLE));
                            BigDecimal y = (BigDecimal) o2.get(0);
                            yList.add((int) (y.doubleValue() * MILLION_DOUBLE));
                        }
                        int[] xpoints = new int[xList.size()];
                        int[] ypoints = new int[xList.size()];
                        for (int k = 0; k < xList.size(); k++) {
                            xpoints[k] = xList.get(k);
                            ypoints[k] = yList.get(k);
                        }
                        xList.clear();
                        yList.clear();
                        int area = (int) calculatePoiArea(0, xpoints, ypoints);
                        totalArea.add(area);
                    }
                }
                ShopResult result = getShopResult(shopInfo, totalArea);
                queue.add(result);
                int count = cnt.incrementAndGet();
                if (count%100 == 0){
                    System.out.println(count+"\t"+new Date());
                }
//                System.out.println(String.format("cost: %s, thread: %s, totalCnt: %s, shopResult: %s",
//                        System.currentTimeMillis() - t, Thread.currentThread().getId(), cnt.incrementAndGet(), result));
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    private ShopResult getShopResult(ShopInfo shopInfo, java.util.List<Integer> totalArea) {
        java.util.List list = Lists.newArrayList();
        list.add(totalArea);
        ShopResult result = new ShopResult();
        result.setShopId(shopInfo.getShopId());
        result.setAddress(shopInfo.getAddress());
        result.setCity(parseCity(shopInfo.getCityId()));
        result.setDeliveryType(shopInfo.getDeliveryType());
        result.setName(shopInfo.getName());
        if (shopInfo.getThirdpartyId() == 6) {
            result.setElemeAreas(list);
        }else{
            result.setMtAreas(list);
        }
        return result;
    }

    private String parseCity(int cityId) {
        switch (cityId){
            case 1:
                return "上海";
            case 2:
                return "北京";
            case 3:
                return "杭州";
            case 4:
                return "广州";
            case 7:
                return "深圳";
        }
        return  String.valueOf(cityId);
    }

    public double calculatePoiArea(long poiId, int[] xpoints, int[] ypoints) {

        if (xpoints.length == 0 || ypoints.length == 0)
            return 0;
        double minLat = Integer.MAX_VALUE;
        double minLng = Integer.MAX_VALUE;
        double maxLat = 0;
        double maxLng = 0;
        for(int i = 0; i<xpoints.length; ++i) {
            if(minLat > xpoints[i]) {
                minLat = xpoints[i];
            }
            if(maxLat < xpoints[i]) {
                maxLat = xpoints[i];
            }
            if(minLng > ypoints[i]) {
                minLng = ypoints[i];
            }
            if(maxLng < ypoints[i]) {
                maxLng = ypoints[i];
            }
        }
        double totalCover = 0;
        Polygon polygon = new Polygon(xpoints, ypoints, ypoints.length);

        GeoHash sw = null;
        GeoHash sw1 = null;
        GeoHash sw2= null;
        GeoHash sw3= null;
        GeoHash sw4= null;
        final double fixCover;
        final double fixCover1;
        final double fixCover2;
        final double fixCover3;
        final double fixCover4;
        try {
            long y = 1000000000;
            long deltaLat = (long) (maxLat - minLat);
            long deltaLng = (long) (maxLng - minLng);
            long x = deltaLat * deltaLng;
            int z = (int) Math.log(1.0*x/y);
            if (z > 20){
                System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzz="+z);
            }
            int scale = Math.min(43 - z, 45);
            scale = Math.max(scale, 25);
            sw = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, scale);
//            sw1 = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 42);
//            sw2 = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 41);
//            sw3 = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 40);
//            sw4 = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 39);
            fixCover = getAreaCover(sw);
//            fixCover1 = getAreaCover(sw1);
//            fixCover2 = getAreaCover(sw2);
//            fixCover3 = getAreaCover(sw3);
//            fixCover4 = getAreaCover(sw4);
        } catch (Exception e) {
            System.out.println(String.format("minlat:%s,\tminlng:%s",minLat, minLng));
            return 0;
        }
        long pCnt = 0;
        for(GeoHash xgh = sw;;) {
            WGS84Point xpoint = xgh.getPoint();
            int xlng = (int)(xpoint.getLongitude() * MILLION_DOUBLE);
            if(xlng > maxLng){
                break;
            }
            for(GeoHash ygh = xgh; ; ) {
                WGS84Point xypoint = ygh.getPoint();
                if((int)(xypoint.getLatitude() * MILLION_DOUBLE) > maxLat) {
                    break;
                }

                WGS84Point point = ygh.getBoundingBoxCenterPoint();
                int lat = (int)(point.getLatitude() * MILLION_DOUBLE);
                int lng = (int)(point.getLongitude() * MILLION_DOUBLE);
                if(polygon.contains(lat, lng)) {
                    totalCover += fixCover;
                }
                ygh = ygh.getNorthernNeighbour();
                pCnt++;
                if (pCnt > 1000000) {
                    System.out.println(fixCover + "|" + pCnt);
                    return -totalCover;
                }
            }
            xgh = xgh.getEasternNeighbour();
            if (pCnt > 1000000) {
                System.out.println(fixCover + "|" + pCnt);
                return -totalCover;
            }
        }

        return totalCover;
    }

    public double[] getWidthAndHeigh(GeoHash gh) {
        BoundingBox box = gh.getBoundingBox();//VincentyGeodesy
        WGS84Point point1 = new WGS84Point(box.getMinLat(), box.getMinLon());
        WGS84Point point2 = new WGS84Point(box.getMinLat(), box.getMaxLon());
        WGS84Point point3 = new WGS84Point(box.getMaxLat(), box.getMinLon());

        double w = VincentyGeodesy.distanceInMeters(point1, point2);
        double h = VincentyGeodesy.distanceInMeters(point1, point3);
        return new double[]{w, h};
    }

    public double getAreaCover(GeoHash gh) {
        double[] wh = getWidthAndHeigh(gh);
        return wh[0] * wh[1];
    }


}




}
