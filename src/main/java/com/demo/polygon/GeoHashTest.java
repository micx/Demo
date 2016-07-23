/**
 * GeoHashTest.java
 * Created on  22/3/2016 3:42 PM
 * modify on                user            modify content
 * 22/3/2016 3:42 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.polygon;

import ch.hsr.geohash.BoundingBox;
import ch.hsr.geohash.GeoHash;
import ch.hsr.geohash.WGS84Point;
import ch.hsr.geohash.util.VincentyGeodesy;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.io.*;

/**
 * Created by micx  on 2016/03/22 3:42 PM.
 */
public class GeoHashTest {
    public static void main(String[] args) {
//        geoHashTest();
        parseAddress();
//        readFileByLines(FILE_NAME);

    }

    private static void geoHashTest() {

//        31.2026265301,121.4352493737
//        31.2179868691,121.4158382808
        double lat = 31.2026265301;
        double lng = 121.4352493737;
        double lat1 = 31.2179868691;
        double lng1 = 121.4158382808;

        double dis = calDistance(lat, lng, lat1, lng1);

        System.out.println(dis);
        System.out.println(encode(lat, lng, 10, 0));
        System.out.println(encode(lat1, lng1, 10, 0));
        System.out.println(encode(lat, lng, 10, 1));
        System.out.println(encode(lat1, lng1, 10, 1));
        testPrecision(40, lat, lng);
        testPrecision(39, lat, lng);
        testPrecision(38, lat, lng);
        testPrecision(37, lat, lng);
        testPrecision(36, lat, lng);
        testPrecision(35, lat, lng);
        testPrecision(31, lat, lng);
        testPrecision(30, lat, lng);
        testPrecision(29, lat, lng);



        GeoHash gh = GeoHash.withBitPrecision(lat, lng, 29);

        show( gh, gh.getWesternNeighbour().getNorthernNeighbour(), 1);
        show( gh, gh.getNorthernNeighbour(), 2);
        show( gh, gh.getEasternNeighbour().getNorthernNeighbour(), 3);
        show( gh, gh.getWesternNeighbour(), 4);
        show( gh, gh, 5);
        show( gh, gh.getEasternNeighbour(), 6);
        show( gh, gh.getWesternNeighbour().getSouthernNeighbour(), 7);
        show( gh, gh.getSouthernNeighbour(), 8);
        show( gh, gh.getEasternNeighbour().getSouthernNeighbour(), 9);
    }

    private static String address = "0,东方路1217号,陆家嘴金融服务广场,29.1438848479,113.1209796937\n" +
            "0,峨山路91弄,陆家嘴软件园－9号楼,31.2150473885,121.5319964224\n" +
            "0,峨山路91弄,陆家嘴软件园－2号楼,31.2150473885,121.5319964224\n" +
            "0,峨山路91弄,陆家嘴软件园－5号楼,31.2150473885,121.5319964224\n" +
            "0,峨山路91弄,陆家嘴软件园－4号楼,31.2150473885,121.5319964224\n" +
            "0,峨山路91弄,陆家嘴软件园－10号楼,31.2150473885,121.5319964224\n" +
            "0,杨高南路410,由由世纪广场,31.2183163885,121.5351394223\n" +
            "0,杨高南路759号,陆家嘴世纪金融广场,31.1897234748,121.5245020724\n" +
            "0,福山路388号,宏嘉大厦,22.6889474488,113.8377603565\n" +
            "0,世纪大道1500号,东方大厦,31.6126309539,117.8901218209\n" +
            "0,福山路500号,城建国际中心,22.6889474488,113.8377603565\n" +
            "0,东方路989号,中达广场,29.1438848479,113.1209796937\n" +
            "0,东方路971号,钱江大厦,29.1438848479,113.1209796937\n" +
            "0,江苏路398号,舜元企业发展大厦,31.2187450558,121.4308044656\n" +
            "0,愚园路1240号,绿地商务中心,31.2199475258,121.4258732372\n" +
            "0,江苏路369号,兆丰世贸大厦,31.2189150558,121.4315524656";
//            "20240,上海市长宁区安化路492号D2食堂,德必易园,31.2151966275,121.4203274825\n" +
//            "14930,上海市浦东新区祖冲之路899号2号楼,上海普景信息科技有限公司,31.2044499771,121.5943780401\n" +
//            "10014,上海市徐汇区宜山路900号A1001室,上海威志信息技术有限公司,31.1721109219,121.4015998508\n" +
//            "10014,上海市徐汇区宜山路900号A401室,上海威志信息技术有限公司,31.1721109219,121.4015998508\n" +
//            "18522,上海长宁区天山路641号2号楼201A,上海石川科技有限公司,31.2127338534,121.3949945596\n" +
//            "10001,上海市长宁区安化路492号D2食堂,大众点评网测试企业,30.866547,97.298993";
//    private static String address = "" +
//            "上海市长宁区安化路492号,大众点评,31.2152248176,121.4203483641\n" +
//            "上海市长宁区长宁路1081号,中山公园地铁站,31.2180638692,121.4157672809\n" +
//            "上海市长宁区安化路363号,定西路安化路,31.2147818176,121.4227463641\n" +
//            "上海市长宁区凯旋路813号,延安西路地铁站,31.2094948691,121.4171142809\n" +
//            "上海市长宁区凯旋路1555号,虹桥路地铁站,31.1961625738,121.4213995831\n" +
//            "上海市长宁区淮海中路1913号,上海交通大学地铁站,31.2023645301,121.4354653737\n" +
//            "上海市徐汇区肇嘉浜路940,徐家汇公园,31.1971750611,121.4431312869\n" +
//            "上海市长宁区愚园路883号,江苏路地铁站,31.2195166933,121.4326906328\n" +
//            "上海市长宁区万航渡路1483号,华东政法大学,31.2242840677,121.4198127888\n" +
//            "上海市普陀区宁夏路678号,金沙江路地铁站,31.2312724269,121.4131588221\n" +
//            "上海市长宁区武夷路777,长宁体操中心,31.2129608691,121.4135572809\n" +
//            "上海市长宁区安化路560号,凯欣豪园,31.2162968691,121.4184442808\n" +
//            "上海市长宁区定西路1536,华宁国际广场,31.2172598176,121.4222433641\n" +
//            "上海市长宁区长宁路969号,兆丰广场,31.2177078176,121.4192433641\n" +
//            "上海市长宁区长宁路1299号,中山公寓,31.2164978692,121.4128212808\n" +
//            "天通苑西一区57号楼,天通苑,40.000968,116.473533\n" +
//            "望京东路六号,美团网,40.0068110381,116.4894441450\n" +
//            "望京东路1号,摩托罗拉大厦,40.0068616307,116.4837843900\n" +
//            "北京市朝阳区溪阳东路,EMC实验室,40.0057626307,116.4839703900\n" +
//            "北京市朝阳区阜通东大街,望京SOHO,39.9966160255,116.4813453070\n" +
//            "武夷路100号,巴黎春天,31.213189,121.428961";

    private static final String FILE_NAME = "/Users/micx/file/useraddress/useraddress";
    private static final String SQL_PREFIX = "INSERT INTO `TA_BIZ_Address` ( " +
            "`entr_id`, `address`, `poi`, `lat`, `lng`, `geohash`, `addtime`, `updatetime`, `isdeleted`) " +
            "VALUES ";
    private static final String SQL = "( %s, '%s', '%s', %s, %s, '%s', now(), now(), 0);\n";
    private static void parseAddress() {
        String[] lineArr = address.split("\n");
        for (String line:lineArr) {
            String[] detail = line.split(",");
            String addr = detail[1];
            if (StringUtils.isBlank(addr)) {
                return ;
            }
            String poi = detail[2];
            double lat = NumberUtils.toDouble(detail[3]);
            double lng = NumberUtils.toDouble(detail[4]);
            int entrId = NumberUtils.toInt(detail[0]);
            GeoHash geoHash = GeoHash.withBitPrecision(lat, lng, 29);
            System.out.println(String.format(SQL_PREFIX + SQL,entrId, addr, poi, lat, lng, geoHash.toBinaryString()));
        }
    }
    private static String parseAddress(String line) {
        String[] detail = line.split("\t");
        if (detail.length != 3){
            return null;
        }
        String addr = detail[0];
        if (StringUtils.isBlank(addr)){
            return null;
        }
//        String poi = detail[1];
        double lat = NumberUtils.toDouble(detail[1]);
        double lng = NumberUtils.toDouble(detail[2]);
        GeoHash geoHash = GeoHash.withBitPrecision(lat, lng, 29);
        return String.format(SQL_PREFIX+SQL,addr,"",lat,lng,geoHash.toBinaryString());
    }

    public static void appendMethodB(String fileName, String content) {
        try {
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName+".sql", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                String sql = parseAddress(tempString);
                if (sql != null) {
                    writer.write(sql);
                }
                line++;
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    writer.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static void show(GeoHash sorc, GeoHash dest, int num) {
        double dis = calDistance(sorc, dest);
        String sorcCode = sorc.toBinaryString();
        String destCode = dest.toBinaryString();
        System.out.println(String.format("num:%s\tsorc:%s\tdest:%s\tdis:%s",num, sorcCode, destCode, dis));
    }

    private static double calDistance(GeoHash sorc, GeoHash dest) {
        WGS84Point point1 = sorc.getBoundingBoxCenterPoint();
        WGS84Point point2 = dest.getBoundingBoxCenterPoint();

        return VincentyGeodesy.distanceInMeters(point1, point2);
    }

    private static double calDistance(double lat, double lng, double lat1, double lng1) {
        WGS84Point point1 = new WGS84Point(lat, lng);
        WGS84Point point2 = new WGS84Point(lat1, lng1);

        return VincentyGeodesy.distanceInMeters(point1, point2);
    }

    private static void testPrecision(int numberOfChar, double lat, double lng) {
        String base32 = encode(lat, lng, numberOfChar, 0);
        String binary = encode(lat, lng, numberOfChar, 1);

        GeoHash gh = GeoHash.withBitPrecision(lat, lng, numberOfChar);

        BoundingBox box = gh.getBoundingBox();

        WGS84Point point1 = new WGS84Point(box.getMinLat(), box.getMinLon());
        WGS84Point point2 = new WGS84Point(box.getMinLat(), box.getMaxLon());
        WGS84Point point3 = new WGS84Point(box.getMaxLat(), box.getMinLon());

//        WGS84Point point1 = new WGS84Point(lat, lng);
//        WGS84Point point2 = new WGS84Point(lat1, lng1);

        double w = VincentyGeodesy.distanceInMeters(point1, point2);
        double h = VincentyGeodesy.distanceInMeters(point1, point3);


        System.out.println(String.format("num:%s\tbinary:%s\tlen:%s\tbase32:%s\tw:%s\th:%s", numberOfChar, binary, binary.length(), base32, w, h));
    }

    private static String encode(double lat, double lng, int numberOfChar, int type) {
        GeoHash gh = GeoHash.withCharacterPrecision(lat, lng, numberOfChar);
        switch (type){
            case 0:
                return gh.toBase32();
            case 1:
                return gh.toBinaryString();
        }
        return gh.toBase32();
    }


}
