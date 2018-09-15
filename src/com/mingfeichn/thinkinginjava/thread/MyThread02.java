package com.mingfeichn.thinkinginjava.thread;

/**
 * 通过实现Runnable接口创建线程
 */
public class MyThread02 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello myThread02");
    }

    public static void main(String[] args) {
        Thread myThread02 = new Thread(new MyThread02());
        myThread02.start();
    }
}
