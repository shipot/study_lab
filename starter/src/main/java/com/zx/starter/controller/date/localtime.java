package com.zx.starter.controller.date;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/11 18:04
 */
public class localtime {

    public static void main(String[] args) {
        LocalTime time = LocalTime.of(0, 1,1);
        LocalTime now = LocalTime.of(22, 34, 45);
        long l = Duration.between(time, now).toMinutes();
        System.out.println(l);
    }

}
