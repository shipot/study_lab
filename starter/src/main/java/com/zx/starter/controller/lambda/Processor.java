package com.zx.starter.controller.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/27 14:56
 */
public class Processor {
    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try (
                BufferedReader br = new BufferedReader(new FileReader("e:/ces/ss.txt"))){
               return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println(processFile(br->br.readLine() +"\n" + br.readLine()+"\n"+ br.readLine()));
    }

}
