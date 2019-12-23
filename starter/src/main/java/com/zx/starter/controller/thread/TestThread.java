package com.zx.starter.controller.thread;

/**
 * @author zhouxiong
 * @description
 * @date 2019/10/11 11:18
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+"进入线程");
        synchronized(this){
            test();
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+"锁以释放");
    }
    public void test(){
        for (int i =0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        TestThread s = new TestThread();
        TestThread s1 = new TestThread();
        Thread t1 = new Thread(s,"A");
        Thread t2 = new Thread(s1,"B");

        t1.start();
        t2.start();
    }

}
