package com.zx.starter.controller.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author zhouxiong
 * @Title: DateTest
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1410:12
 */
public class DateTest {

    @Test
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        String td = LocalDate.now().toString();
        String zd = LocalDate.now().minusDays(7).toString();

        System.out.println(td+"——" +zd);
    }
}
