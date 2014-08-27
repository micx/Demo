package com.demo.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Created by chenxi.chen on 2014/08/21/下午2:49.
 */
public class TimerTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void  main(String[] args){
        Calendar calendar = Calendar.getInstance();
        // 指定01:00:00点执行
        calendar.setTime(new Date());
        System.out.println(sdf.format(calendar.getTime()));
        calendar.set(Calendar.HOUR_OF_DAY, 13);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.add(Calendar.DATE, 1);
        System.out.println(sdf.format(calendar.getTime()));

  Timer timer = new Timer();

        //timer.schedule(new NoticeTask(),date);
        // 若需循环执行，需改为以下代码
        // 任务执行周期(毫秒)
         Long period = Long.valueOf(10 * 1000);
         timer.schedule(new NoticeTask(), calendar.getTime(), period);
    }


}
