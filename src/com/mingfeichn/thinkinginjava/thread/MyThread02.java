package com.mingfeichn.thinkinginjava.thread;

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
