/**
 * DailyReport.java  
 * Created on  16/9/14 下午3:58
 * modify on                user            modify content
 * 16/9/14 下午3:58        chenxi.chen
 *
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.canzhuo.htmlparse;

import org.htmlparser.util.ParserException;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxi.chen  on 2014/09/16 下午3:58.
 */
public class DailyReport {
    private Map<Integer, String> storeMap = new HashMap<Integer, String>();

    private void handleStoreID() throws IOException {
        FileReader reader = new FileReader("/Users/micx/Projects/canzhuo/store_id_name");
        BufferedReader br = new BufferedReader(reader);

        int cnt = 0;
        String str ;
        while((str = br.readLine()) != null) {
            ++cnt;
            String[] arr = str.split("\\|");
            int id = Integer.parseInt(arr[0]);
            String name = arr[1].split("（")[0];
            storeMap.put(id,arr[1]);
        }
        System.out.println(cnt);
        reader.close();
    }
    private void getDailyData() throws IOException {
        File dir = new File("/Users/micx/Projects/canzhuo/days/filterData");
        File[] files = dir.listFiles();

        FileWriter fw = new FileWriter("/Users/micx/Projects/canzhuo/dailyReport");

        fw.write("日期\t订单数量\t订单金额\t菜品费\t折后菜品费\t制餐费\t餐盒费\t应付餐厅\t实付餐厅\t收派送费\n");
        for(int i=0;i<files.length;i++){
            FileReader reader = new FileReader("/Users/micx/Projects/canzhuo/days/filterData/"+files[i].getName());
            BufferedReader br = new BufferedReader(reader);

            String name = storeMap.get(Integer.parseInt(files[i].getName().split("_")[0]));
            String str ;
            String txt = "";
            while((str = br.readLine()) != null) {
                txt = name+"\t"+str;
                for(int j=0;j<11;++j){
                    txt=txt+"\t" + br.readLine();
                }
                txt=txt+"\n";
                fw.write(txt);
            }
            reader.close();
        }
        fw.close();
    }


    public static void main(String[] args) throws IOException, SAXException, ParserException {
        DailyReport dailyReport = new DailyReport();
        dailyReport.handleStoreID();
        dailyReport.getDailyData();
    }
}

