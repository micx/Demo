package com.demo.hessian.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qianhao.zhou on 8/25/14.
 */
public class Data implements Serializable {
    private static final long serialVersionUID = 6007254009849569713L;


    private int type;
    private Date timestamp;
    private String[] stringArr;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String[] getStringArr() {
        return stringArr;
    }

    public void setStringArr(String[] stringArr) {
        this.stringArr = stringArr;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);

    }
}
