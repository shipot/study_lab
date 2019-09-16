package com.zx.starter.controller.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author zhouxiong
 * @Title: stream
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/2210:09
 */
public class stream {
    public static void main(String[] args) {

        List<Integer> s = Arrays.asList();

        System.out.println(s.stream().max(Integer::compareTo).isPresent());

/*
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        wordLengths.forEach(System.out::println);*/
        /*// [7, 2, 6]
        List<Integer> l = map(
                Arrays.asList("lambdas","in","action"),
                s-> s.length()
        );

        l.stream().forEach(System.out::println);*/
    }
    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }

}
