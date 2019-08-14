package com.zx.starter.controller.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author zhouxiong
 * @Title: DateTest
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1410:12
 */
public class DateTest {
    public static void main(String[] args) {

        System.out.println(new Date());

        System.out.println(LocalTime.now());




       /* //获取当前时间   去掉毫秒值   17:45:41
        LocalTime now1 = LocalTime.now().withNano(0).withSecond(0);
        System.out.println(now1);
        //00:46:46.651  提供了把时分秒都设为0的方法
        //构造时间  05:43:22
        LocalTime time2 = LocalTime.parse("08:03:22");
        System.out.println(time2.withSecond(0));
*/
        /*Long time = 1565143231810L;
        Date date = new Date(time);

        System.out.println(date);*/



       /* SimpleDateFormat dateFormat= new SimpleDateFormat("HH:mm");
        System.out.println(dateFormat.format(new Date()));

        LocalTime now = LocalTime.now();
        String time = now.getHour()+":"+ now.getMinute() ;

        LocalDate date = LocalDate.now();

        int week = date.getDayOfWeek().getValue();

        System.out.println(time);
        System.out.println(week);*/



       /* String e="1,2,3";
        String[] s=e.split(",");
        for(String s1:s ){
            int i = Integer.parseInt(s1);
            System.out.println(i);
        }
     */

   /*     Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("HH:mm");
        System.out.println(dateFormat.format(date));

        String g = dateFormat.format(date);

        String f="15:27&17:46";
        List<String> j = new ArrayList<>();

        String[] h = f.split("&");
        if (g.compareTo(h[0])>=0 && g.compareTo(h[1])<=0){
            j.add(h[1]);
        }
        System.out.println(j.get(0));

        }

*/
    }


    /**
     * 处理日期 LocalDate
     */
    public static void test1(){
        //获取当前日期   2017-11-06
        LocalDate today = LocalDate.now();
        System.out.println(today);

        //构造日期   2017-10-08
        LocalDate today2 = LocalDate.of(2017,10,8);
        System.out.println(today2);

        //构造日期   2017-02-22    字符串严格按照yyyy-MM-dd
        LocalDate today3 = LocalDate.parse("2017-02-22");
        System.out.println(today3);

        //本月第一天  2017-11-01
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
        //本月第二天  2017-11-02   第n天
        LocalDate secondDayOfMonth = today.withDayOfMonth(2);
        System.out.println(secondDayOfMonth);

        //本月最后一天 2017-02-28  方便解决任何年份的二月份多少天
        LocalDate lastDayOfMonth = today3.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);


        //获取2017年12月的第一个周一   2017-12-04
        LocalDate firstDayOf201712 = LocalDate.parse("2017-12-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstDayOf201712);

    }

    /**
     * 处理时间  LocalTime
     */
    public static void test2(){
        //获取当前时间  含有毫秒值  17:18:41.571
        LocalTime now = LocalTime.now();
        System.out.println(now);

        //获取当前时间   去掉毫秒值   17:45:41
        LocalTime now1 = LocalTime.now().withNano(0);
        System.out.println(now1);
        //00:46:46.651  提供了把时分秒都设为0的方法
        LocalTime now2 = LocalTime.now().withHour(0);
        System.out.println(now2);

        //构造时间  00:20:55
        LocalTime time1 = LocalTime.of(0,20,55);
        System.out.println(time1);
        //构造时间  05:43:22
        LocalTime time2 = LocalTime.parse("05:43:22");
        System.out.println(time2);


        //标准时间 2017-11-06T17:53:15.930
        LocalDateTime lt = LocalDateTime.now();
        System.out.println(lt);
    }
}
