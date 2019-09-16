package com.zx.starter.controller.java8;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author zhouxiong
 * @description
 * @date 2019/9/3 13:42
 */
public class ParallelStreams {
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n){
           return LongStream.rangeClosed(1, n)
                   .parallel()
                   .reduce(0L, Long::sum);
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }


}
