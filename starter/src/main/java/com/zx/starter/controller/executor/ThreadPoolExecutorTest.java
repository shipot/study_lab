package com.zx.starter.controller.executor;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhouxiong
 * @description
 * @date 2019/12/17 10:58
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        // 3y线程启动
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3y终于写完了");
                countDownLatch.countDown();

            }
        }).start();

        // 其他员工线程启动
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("其他员工需要等待3y");
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("3y终于写完了，其他员工可以开始了！");
                }
            }).start();
        }
    }
}
