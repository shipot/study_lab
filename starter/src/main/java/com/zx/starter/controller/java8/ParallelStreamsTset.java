package com.zx.starter.controller.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * @author zhouxiong
 * @description
 * @date 2019/9/3 13:33
 */
public class ParallelStreamsTset {
    public static void main(String[] args) {
        long start = System.nanoTime();
        long sum = forkJoinSum(10000000);
        long end = (System.nanoTime() - start)/1_000_000;
        System.out.println(sum + "\n" +end);
    }
    public static long measureSumPerf(Function<Long,Long> adder, Long n){
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long end = (System.nanoTime() - start)/1_000_000;
            System.out.println("Result："+ sum);
            if (end<fastest) fastest = end;
        }
        return fastest;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        System.out.println(Runtime.getRuntime().availableProcessors());
        return new ForkJoinPool().invoke(task);
    }



}
