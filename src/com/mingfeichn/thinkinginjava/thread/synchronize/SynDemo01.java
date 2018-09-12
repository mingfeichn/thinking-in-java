package com.mingfeichn.thinkinginjava.thread.synchronize;

import com.mingfeichn.thinkinginjava.thread.MyThread;

public class SynDemo01 {
    public static void main(String[] args) {
        MyThread runnable = new MyThread();

        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");
        Thread thread3 = new Thread(runnable, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
