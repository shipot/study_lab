package com.zx.starter.controller.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author zhouxiong
 * @Title: IoController
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/7/3010:05
 */
@Slf4j
public class IoController {

    @Test
    public static void main(String[] args) throws IOException{
        //OutPut();
        InPut();
    }
    public static void OutPut() throws IOException{
        byte[] bytes = InPut();
        FileOutputStream out = new FileOutputStream(new File("e:/ces/tt.txt"));
        PrintStream printStream = new PrintStream(out);
        printStream.println("zhouxiong");
        out.write(bytes);
        printStream.close();
        out.close();
    }


    public static byte[] InPut() throws IOException{

        File file = new File("e:/ces/ss.txt");
        InputStream in = new FileInputStream(file);
        System.out.println(file.length());
        byte[] bytes = new byte[(int)file.length()];
        int len = in.read(bytes);
        int i = 0;
        while (bytes.length>0 && i<len){
            System.out.println(bytes[i]);
            i++;
        }
        in.close();
        return bytes;
    }


}
