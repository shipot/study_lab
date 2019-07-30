package com.zx.starter.controller.users;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhouxiong
 * @Title: TestController
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/7/3010:05
 */
@Slf4j
public class TestController {

    @Test
    public static void main(String[] args) {

        String s = "dahdkad";
        System.out.println(s.lastIndexOf("a"));
        System.out.println(s.indexOf("a"));
        System.out.println(s.substring(s.lastIndexOf("a")));
        System.out.println(s.substring(s.indexOf("a")));


    }

}
