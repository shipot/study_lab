package com.zx.starter.controller.encoding;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhouxiong
 * @Title: Ascll
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/215:57
 */
@Slf4j
public class Ascll {

    @Test
    public static void main(String[] args) {
        System.out.println(stringToASCII("我是一个字符串"));
        System.out.println(convertStringToHex("我是一个字符串"));
        System.out.println(convertHexToString(convertStringToHex("我是一个字符串")));
    }

    //字符串转换为ASCII
    public static String stringToASCII(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            sbu.append((int)chars[i]);
        }
        return sbu.toString();
    }

    //字符串转换为十六进制
    public static String convertStringToHex(String str) {
        char[] chars = str.toCharArray();
        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }
        return hex.toString();
    }

    //十六进制转换为字符串
    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < hex.length() - 1; i += 2) {
            String output = hex.substring(i, (i + 2));
            int decimal = Integer.parseInt(output, 16);
            sb.append((char) decimal);
            temp.append(decimal);
        }
        return sb.toString();
    }



}
