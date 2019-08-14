package com.zx.starter.controller.quartz;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zhouxiong
 * @Title: Test
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1414:13
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCronExpr(new Date()));
    }

    public static String getCronExpr(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        int second=calendar.get(Calendar.SECOND);

        return new StringBuilder().append(second).append(" ")
                .append(minute).append(" ")
                .append(hour).append(" ")
                .append(day).append(" ")
                .append(month).append(" ")
                .append("?").append(" ")
                .append(year).toString();
    }
}
