package com.demo.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * Created by chenxi.chen on 2014/08/21/下午2:53.
 */
public class NoticeTask extends TimerTask {

    public void run() {
        System.out.println("定时执行，当前时间：" + getTimeStamp());
    }

    private String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(new Date());
    }
}
