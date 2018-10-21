package com.honeypot.honeypot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
//    获取某一时间的前n天的日期
    public static String getSpecifiedDayBefore(String specifiedDay, int n){

        StringBuilder stringBuilder = new StringBuilder(specifiedDay);
        stringBuilder.setCharAt(4,'-');
        stringBuilder.setCharAt(7,'-');
        specifiedDay = stringBuilder.substring(0,10);
        System.out.println(specifiedDay);
        Calendar c = Calendar.getInstance();
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
//            System.out.print(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day-n);

        String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayBefore;
    }

}
