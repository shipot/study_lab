package com.zx.starter.controller.diamondextend;

/**
 * @author zhouxiong
 * @description
 * @date 2019/9/4 14:32
 */
public interface A {
    default void hello(){
        System.out.println("Hello from A");
    }
}
