package com.zx.starter.controller.java8;

import lombok.Data;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/27 10:32
 */
@Data
public class Apple {

    public Apple(Integer weight, String color){
        this.weight = weight;
        this.color = color;
    }

    private Integer weight;
    private String color;
}
