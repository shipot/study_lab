package com.zx.starter.controller.lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * @author zhouxiong
 * @description
 * @date 2019/8/27 9:47
 */
public class 行为参数化 {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple(68,"green"),
                new Apple(57,"red"),
                new Apple(108,"pink"));

        long fastest = Long.MAX_VALUE;
        int i = Integer.MIN_VALUE;
        System.out.println(fastest+"\n"+i);


    }
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public static   boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
