package com.zx.starter.controller.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
        System.out.println(TimeEnum.getValue(LocalTime.now()));

    }

}