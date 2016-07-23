/**
 * ShopInfo.java
 * Created on  12/1/2016 8:04 PM
 * modify on                user            modify content
 * 12/1/2016 8:04 PM        micx
 * <p/>
 * Dianping.com Inc.
 * Copyright (c) 2003-2014 All Rights Reserved.
 */

package com.demo.polygon;

import clover.org.apache.commons.lang.builder.ToStringBuilder;
import clover.org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by micx  on 2016/01/12 8:04 PM.
 */

public class ShopInfo{
    private int shopId;
    private int cityId;
    private String name;
    private String address;
    private int thirdpartyId;
    private int thirdpartyShopId;
    private String geoJson;
    private int deliveryType;


    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public int getThirdpartyId() {
        return thirdpartyId;
    }

    public void setThirdpartyId(int thirdpartyId) {
        this.thirdpartyId = thirdpartyId;
    }

    public int getThirdpartyShopId() {
        return thirdpartyShopId;
    }

    public void setThirdpartyShopId(int thirdpartyShopId) {
        this.thirdpartyShopId = thirdpartyShopId;
    }

    public String getGeoJson() {
        return geoJson;
    }

    public void setGeoJson(String geoJson) {
        this.geoJson = geoJson;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);

    }
}
