/**
 * PoiAreaService.java
 * Created on  12/1/2016 10:51 AM
 * modify on                user            modify content
 * 12/1/2016 10:51 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.poi;

import ch.hsr.geohash.BoundingBox;
import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import ch.hsr.geohash.util.VincentyGeodesy;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by micx  on 2016/01/12 10:51 AM.
 */
public class PoiAreaService {

    private static final double MILLION_DOUBLE = 1000000*1.0;
//    private static final Logger logger = LoggerFactory.getLogger(PoiAreaService.class);

    public double calculatePoiArea(String line) {
        //544	8349083.67	1	[{"x":39974490,"y":116300359},{"x":39974416,"y":116298929},{"x":39974268,"y":116296799},{"x":39974136,"y":116292626},{"x":39974038,"y":116289874},{"x":39973840,"y":116289261},{"x":39973807,"y":116288605},{"x":39973709,"y":116286950},{"x":39974334,"y":116284236},{"x":39973224,"y":116282004},{"x":39972179,"y":116279859},{"x":39971168,"y":116277498},{"x":39969828,"y":116275996},{"x":39968952,"y":116275433},{"x":39968076,"y":116274956},{"x":39966773,"y":116274864},{"x":39965470,"y":116275031},{"x":39958085,"y":116275782},{"x":39955330,"y":116276136},{"x":39952575,"y":116275803},{"x":39946900,"y":116275052},{"x":39946809,"y":116278743},{"x":39946653,"y":116282434},{"x":39946596,"y":116285438},{"x":39946828,"y":116287583},{"x":39947455,"y":116290072},{"x":39947868,"y":116291896},{"x":39948019,"y":116293806},{"x":39947270,"y":116296478},{"x":39946456,"y":116298806},{"x":39944589,"y":116304310},{"x":39943359,"y":116308070},{"x":39943445,"y":116309942},{"x":39956473,"y":116308934},{"x":39963151,"y":116307786},{"x":39969795,"y":116306681},{"x":39970880,"y":116305157},{"x":39971768,"y":116303634},{"x":39972886,"y":116301853},{"x":39974399,"y":116300930}]
        String[] chunks = StringUtils.split(line);
        if(ArrayUtils.getLength(chunks) < 4) {
            return 0;
        }
        long poiId = NumberUtils.toLong(chunks[0]);
        double area = NumberUtils.toDouble(chunks[1]);
        int type = NumberUtils.toInt(chunks[2]);
        String polygonPoints =  chunks[5];
        return calculatePoiArea(poiId, polygonPoints);
    }

    public double calculatePoiArea(long poiId, String polygonPoints) {
        JSONArray array = JSONObject.parseArray(polygonPoints);

        int[] xpoints = new int[array.size()];
        int[] ypoints = new int[array.size()];
        double minLat = Integer.MAX_VALUE;
        double minLng = Integer.MAX_VALUE;
        double maxLat = 0;
        double maxLng = 0;
        for(int i = 0; i<xpoints.length; ++i) {
            JSONObject point = array.getJSONObject(i);
            xpoints[i] = point.getIntValue("x");
            ypoints[i] = point.getIntValue("y");
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
        GeoHash sw = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 45);
        final double fixCover = getAreaCover(sw);
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
            }
            xgh = xgh.getEasternNeighbour();
        }
        return totalCover;
    }

    public double calculatePoiArea(PoiAreaObject poiInfo) {
        int minLat = Integer.MAX_VALUE;
        int minLng = Integer.MAX_VALUE;
        int maxLat = 0;
        int maxLng = 0;
        for(Polygon polygon : poiInfo.polypons) {
            int minx = NumberUtils.min(polygon.xpoints);
            int miny = NumberUtils.min(polygon.ypoints);
            int maxx = NumberUtils.max(polygon.xpoints);
            int maxy = NumberUtils.max(polygon.ypoints);
            minLat = Math.min(minLat, minx);
            minLng = Math.min(minLng, miny);
            maxLat = Math.max(maxLat, maxx);
            maxLng = Math.max(maxLng, maxy);
        }
        final GeoHash sw = GeoHash.withBitPrecision(minLat/ MILLION_DOUBLE, minLng/ MILLION_DOUBLE, 45);
        final double fixCover = getAreaCover(sw);
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
                if(poiInfo.contains(lat, lng)) {
                    poiInfo.cover += fixCover;
                }
                ygh = ygh.getNorthernNeighbour();
            }
            xgh = xgh.getEasternNeighbour();
        }
        //logger.info("POI:{}, {}, {}, {}", poiInfo.poiId, (int)poiInfo.cover, poiInfo.expectAreas.size(), (int)poiInfo.totalCover());
        return poiInfo.cover;
    }

    public static double[] getWidthAndHeigh(GeoHash gh) {
        BoundingBox box = gh.getBoundingBox();//VincentyGeodesy
        WGS84Point point1 = new WGS84Point(box.getMinLat(), box.getMinLon());
        WGS84Point point2 = new WGS84Point(box.getMinLat(), box.getMaxLon());
        WGS84Point point3 = new WGS84Point(box.getMaxLat(), box.getMinLon());

        double w = VincentyGeodesy.distanceInMeters(point1, point2);
        double h = VincentyGeodesy.distanceInMeters(point1, point3);
        return new double[]{w, h};
    }

    public static double getAreaCover(GeoHash gh) {
        double[] wh = getWidthAndHeigh(gh);
        return wh[0] * wh[1];
    }

    public Map<Integer, PoiAreaObject> readAllPois(File file) {
        BufferedReader reader = null;
        Map<Integer, PoiAreaObject> map = new HashMap<Integer, PoiAreaObject>(300000);
        try {
            reader = new BufferedReader(new FileReader(file));
            for(String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] chunks = StringUtils.split(line);
                if(ArrayUtils.getLength(chunks) < 6) {
                    continue;
                }
                int poiId = NumberUtils.toInt(chunks[0]);
                if(poiId <= 0) {
                    continue;
                }
                PoiAreaObject pa = map.get(poiId);
                if(pa == null) {
                    pa = new PoiAreaObject();
                    pa.poiId = poiId;
                    map.put(pa.poiId, pa);
                }
                double lat = NumberUtils.toDouble(chunks[1])/MILLION_DOUBLE;
                double lng = NumberUtils.toDouble(chunks[2])/MILLION_DOUBLE;

                pa.point = new WGS84Point(lat, lng);

                pa.expectAreas.add(NumberUtils.toDouble(chunks[3]));
                JSONArray array = JSONObject.parseArray(chunks[5]);
                int[] xpoints = new int[array.size()];
                int[] ypoints = new int[array.size()];

                for(int i = 0; i<xpoints.length; ++i) {
                    JSONObject point = array.getJSONObject(i);
                    xpoints[i] = point.getIntValue("x");
                    ypoints[i] = point.getIntValue("y");
                }
                final Polygon polygon = new Polygon(xpoints, ypoints, ypoints.length);
                pa.polypons.add(polygon);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                }catch (Exception ex){}
            }
        }
        return map;
    }

//    public double calculateMaxDeliveryDistance(PoiAreaObject poiInfo) {
//        double max = 0;
//        int maxAtLat = 0;
//        int maxAtLng = 0;
//        for(Polygon polygon : poiInfo.polypons ) {
//            for(int i = 0; i<polygon.xpoints.length; ++i) {
//                double distance = GeoUtil.GetDistance(poiInfo.point.getLatitude(), poiInfo.point.getLongitude(), polygon.xpoints[i] / MILLION_DOUBLE, polygon.ypoints[i] / MILLION_DOUBLE);
//                if(max < distance) {
//                    max = distance;
//                    maxAtLat = polygon.xpoints[i];
//                    maxAtLng = polygon.ypoints[i];
//                }
//            }
//        }
//        poiInfo.maxDistance = (int)max;
//        return max;
//    }


    public static void main(String[] args) throws Exception {
        final PoiAreaService service = new PoiAreaService();
        double cover = service.calculatePoiArea("643071\t31122232\t104389677\t8981822.36\t1\t[{\"x\":31108978,\"y\":104412844},{\"x\":31107876,\"y\":104403917},{\"x\":31117135,\"y\":104369155},{\"x\":31133299,\"y\":104380486},{\"x\":31135209,\"y\":104388897},{\"x\":31129038,\"y\":104413874}]");
        System.out.println(cover);
//        PrintStream out = new PrintStream(new File("/tmp/poi_cover.txt"));
//        Map<Integer, PoiAreaObject> pois = service.readAllPois(new File("/tmp/poiareapoint.txt"));
//        int index = 0;
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        List<Future<PoiAreaObject>> futures = new ArrayList<Future<PoiAreaObject>>(pois.size());
//
//        for(Map.Entry<Integer, PoiAreaObject> en : pois.entrySet()) {
//            final PoiAreaObject pa = en.getValue();
//            Future<PoiAreaObject> future = pool.submit(new Callable<PoiAreaObject>() {
//                public PoiAreaObject call() {
//                    service.calculatePoiArea(pa);
////                    service.calculateMaxDeliveryDistance(pa);
//                    return pa;
//                }
//            });
//            futures.add(future);
//
//        }
//        for(Future<PoiAreaObject> future : futures) {
//            final PoiAreaObject pa = future.get();
//            out.println(String.format("%6d: %8d   %2d  %10d  %10d   %6d", ++index, pa.poiId, pa.expectAreas.size(), (int)pa.cover, (int)pa.totalCover(), pa.maxDistance));
//        }
    }

    public static class PoiAreaObject {
        public int poiId = 0;
        public ArrayList<Double> expectAreas = new ArrayList<Double>();
        public ArrayList<Polygon> polypons = new ArrayList<Polygon>();
        public double cover;

        public WGS84Point point = null;
        public int maxDistance;

        public boolean contains(int x, int y) {
            for(Polygon polygon : polypons) {
                if(polygon.contains(x, y)) {
                    return true;
                }
            }
            return false;
        }

        public double totalCover() {
            double ret = 0;
            for(Double d : expectAreas) {
                ret += d;
            }
            return ret;
        }
    }

}
