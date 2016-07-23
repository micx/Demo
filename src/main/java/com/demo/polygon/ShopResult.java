/**
 * ShopResult.java
 * Created on  13/1/2016 10:02 AM
 * modify on                user            modify content
 * 13/1/2016 10:02 AM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.polygon;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by micx  on 2016/01/13 10:02 AM.
 */
public class ShopResult {
    private int shopId;
    private String city;
    private String name;
    private String address;
    private List<List<Integer>> mtAreas;
    private int mtArea;
    private int elemeArea;
    private List<List<Integer>> elemeAreas;
    private int deliveryType;

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<List<Integer>> getMtAreas() {
        return mtAreas;
    }

    public void setMtAreas(List<List<Integer>> mtAreas) {
        this.mtAreas = mtAreas;
    }

    public List<List<Integer>> getElemeAreas() {
        return elemeAreas;
    }

    public void setElemeAreas(List<List<Integer>> elemeAreas) {
        this.elemeAreas = elemeAreas;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getMtArea() {
        return getMaxVal(mtAreas);
    }

    public void setMtArea(int mtArea) {
        this.mtArea = mtArea;
    }

    public int getElemeArea() {
        return getMaxVal(elemeAreas);
    }

    public void setElemeArea(int elemeArea) {
        this.elemeArea = elemeArea;
    }

    @Override
    public String toString() {
        return shopId + "\t" + city+ "\t" + name+ "\t" + address+ "\t" + getMtArea()+ "\t" +getElemeArea()+"\t"+deliveryType;
    }

    private int getMaxVal(List<List<Integer>> areas) {
        if (CollectionUtils.isEmpty(areas)){
            return 0;
        }
        List<Integer> list = Lists.newArrayList();
        for (List<Integer> area: areas){
            for (Integer a: area){
                list.add(a);
            }
        }
        if (CollectionUtils.isEmpty(list)){
            return 0;
        }
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}
