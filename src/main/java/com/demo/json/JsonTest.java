package com.demo.json;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenxi.chen on 2014/08/25/下午5:23.
 */
public class JsonTest {
    private static String pattern = "INSERT INTO `TA_OrderLog` ( `orderid`, `thirdpartyid`, `userkey`, `shopid`, `cityid`, `onlinepayment`, `shopkey`, `mobile`, `shopname`, `fetchtype`, `payfee`, `ordertime`, `reachtime`, `reserve`, `interval`, `reviewed`, `reviewdelay`, `willing`, `lateststatus`, `fromstatus`, `clientip`, `UUID`, `channel`, `payorderid`, `paystatus`, `frompaystatus`, `commissionrate`, `addtime`, `isfree`, `boxfee`, `deliveryfee`, `orderaddress`, `viewid`, `originalprice`)\n" +
            "VALUES\n" +
            "\t( {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12}, {13}, {14}, {15}, {16}, {17}, {18}, {19}, {20}, {21}, {22}, {23}, {24}, {25}, {26}, {27}, {28}, {29}, {30}, {31}, {32}, {33});\n";
    public static void main(String args[])throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File file = new File("/Users/micx/Desktop/json");//Text文件
        BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
        String s = null;
        List<JSONObject> list = new ArrayList<JSONObject>();
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            JSONObject jsonObject =  new JSONObject(s);
            list.add(jsonObject);
//            System.out.println(s);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(JSONObject ob: list){

            JSONObject jb = (JSONObject) ob.get("orderBo");

            //`orderid`,
            int orderid = jb.getInt("orderid");
            //`thirdpartyid`,
            int thirdpartyid = jb.getInt("thirdpartyid");
            // `userkey`,
            int userkey = jb.getInt("userkey");
            // `shopid`,
            int shopid = jb.getInt("shopId");

            // `onlinepayment`,
            int onlinepayment = 0;//
            // `shopkey`,
            int shopkey = jb.getInt("shopkey");
            // `mobile`,
            String mobile = "\'"+jb.getInt("phone")+"\'";
            // `shopname`,
            String shopname = "\'"+jb.getString("shopname")+"\'";
            // `fetchtype`,
            int fetchtype = jb.getInt("fetchtype");
            // `payfee`,
            double payfee = jb.getDouble("payfee");
            // `ordertime`,


            Date ot = new Date();
            ot.setTime(jb.getLong("ordertime"));
            String ordertime = "\'"+sdf.format(ot)+"\'";

            ot.setTime(jb.getLong("reachtime"));
            // `reachtime`,
            String reachtime = "\'"+sdf.format(ot)+"\'";
            // `reserve`,
            int reserve = jb.getInt("reserve");
            // `interval`,
            int interval = jb.getInt("interval");
            // `reviewed`,
            int reviewed = jb.getInt("reviewed");
            // `reviewdelay`,
            int reviewdelay = jb.getInt("reviewdelay");
            // `willing`,
            int willing = jb.getInt("willing");
            // `lateststatus`,
            int lateststatus = jb.getInt("lateststatus");
            // `fromstatus`,
            int fromstatus = ob.getInt("fromOrderStatus");
            // `clientip`,
            String clientip = "\'"+jb.getString("clientIp")+"\'";
            // `UUID`,
            String UUID = "\'"+jb.getString("uuid")+"\'";
            // `channel`,
            int channel = jb.getInt("channel");
            // `payorderid`,
            int payorderid = jb.getInt("payorderid");
            // `paystatus`,
            int paystatus = 0;
            // `frompaystatus`,
            int frompaystatus = ob.getInt("fromPayStatus");
            // `commissionrate`,
            double commissionrate = 0;//

            // `isfree`,
            int isfree =0;// jb.getInt("isfree");
            // `boxfee`,
            double boxfee = 0;//jb.getDouble("boxfee");
            // `viewid`,
            int viewid = 0;//jb.getInt("viewid");
            // `originalprice`
            double originalprice = 0;//jb.getDouble("originalprice");


            int cityid = 0; //
            double deliveryfee = 0;
            String orderaddress = "\'"+""+"\'";
            // `addtime`,
            String addtime = "now()";


            switch (orderid){
                case 619744:

                    addtime = "\'"+"2014-07-30 18:24:26"+"\'";
                    cityid = 2; //
                    deliveryfee = 0;
                    orderaddress = "\'"+"东直门外大街南二里庄19号百富怡大酒店1606"+"\'";
                    break;
                case 630633:
                    addtime = "\'"+"2014-07-31 19:43:10"+"\'";
                    cityid = 1; //
                    deliveryfee = 0;
                    orderaddress = "\'"+"祈连山南路2727弄17号1002室"+"\'";
                    break;
                case 630647:
                    addtime = "\'"+"2014-07-31 19:44:05"+"\'";
                    cityid = 7; //
                    deliveryfee = 0;
                    orderaddress = "\'"+"桃园路5号友邻公寓B栋2905"+"\'";
                    break;
                case 941810:
                    addtime = "\'"+"2014-08-25 10:00:43"+"\'";
                    cityid = 1; //
                    deliveryfee = 7;
                    orderaddress = "\'"+"中山南二路988弄21号锦江之星2211房间"+"\'";
                    break;
                case 941768:
                    addtime = "\'"+"2014-08-25 09:49:51"+"\'";
                    cityid = 4; //
                    deliveryfee = 0;
                    orderaddress = "\'"+"八旗二马路32号907"+"\'";
                    break;
                case 941813:
                    addtime = "\'"+"2014-08-25 10:01:25"+"\'";
                    cityid = 1; //
                    deliveryfee = 0;
                    orderaddress = "\'"+"桃源路85号永银大厦3楼3090"+"\'";
                    break;
            }

            Object[] params = new Object[]{orderid+"", thirdpartyid+"", userkey+"", shopid+"", cityid+"", onlinepayment+"", shopkey+"", mobile+"", shopname+"", fetchtype+"", payfee+"", ordertime+"", reachtime+"", reserve+"", interval+"", reviewed+"", reviewdelay+"", willing+"", lateststatus+"", fromstatus+"", clientip+"", UUID+"", channel+"", payorderid+"", paystatus+"", frompaystatus+"", commissionrate+"", addtime+"", isfree+"", boxfee+"", deliveryfee+"", orderaddress+"", viewid+"", originalprice+""};
            String msg = MessageFormat.format(pattern, params);
            if(lateststatus == -100 || lateststatus == 0 || lateststatus == 999){

            }else {
//                System.out.println(msg);
//                System.out.println(ob);
//                System.out.print(orderid+",");
                System.out.print(shopid+",");
//
            }
        }
        br.close();;
    }
}




