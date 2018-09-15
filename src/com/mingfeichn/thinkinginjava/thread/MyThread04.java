package com.mingfeichn.thinkinginjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池创建线程
 */
public class MyThread04 implements Runnable {
    private static int POOL_NUM = 5;

    @Override
    public void run() {
        System.out.println("Hello myThread04");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < POOL_NUM; i++){
            MyThread04 myThread04 = new MyThread04();
            executorService.execute(myThread04);
        }
    }
}
