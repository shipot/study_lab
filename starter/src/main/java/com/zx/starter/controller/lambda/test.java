package com.zx.starter.controller.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/28 17:31
 */
public class test {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple(10,"b"),new Apple(20, "green"),new Apple(10, "a"));

        /**
         * 匿名类
         */
        list.sort(new Comparator<Apple>() {
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        /**
         * lambda
         */
        list.sort((a1,a2) ->a1.getWeight().compareTo(a2.getWeight()));
        /**
         * 简化：import static java.util.Comparator.comparing;
         */
        list.sort(comparing(a->a.getWeight()));
        /**
         * 方法引用
         */
        list.stream().sorted(comparing(Apple::getWeight).thenComparing(Apple::getColor));


        System.out.println(list);

    }

}
