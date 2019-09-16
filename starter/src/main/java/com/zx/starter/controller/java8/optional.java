package com.zx.starter.controller.java8;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author zhouxiong
 * @description
 * @date 2019/9/4 19:27
 */
public class optional {

    public static void main(String[] args) {



        Optional<Apple> appleOptional = Optional.of(new Apple(341, "red"));

        System.out.println(stringToInt("3").getAsInt());
        //System.out.println(testOfAndofNullable());

    }

    public static OptionalInt stringToInt(String s){
        try {
            return OptionalInt.of(Integer.parseInt(s));
        }catch (NumberFormatException e){
            return OptionalInt.empty();
        }

    }

    public static String testOfAndofNullable(){
        Optional<Object> value = Optional.ofNullable(null);
        String s = "";
        if (value.isPresent()){
            s = "不为空";
        }else {
            s ="为空";
        }
        return s;
    }

}
