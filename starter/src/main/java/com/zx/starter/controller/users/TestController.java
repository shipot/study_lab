package com.zx.starter.controller.users;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    public static void main(String[] args) throws IOException{
        File file = new File("e:/ces/ss.txt");
        InputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        int b = fileInputStream.read(bytes);
        System.out.println(b);
    }

}
