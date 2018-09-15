package com.mingfeichn.thinkinginjava.thread;

/**
 * 通过继承Thread类创建线程
 */
public class MyThread01 extends Thread {

    @Override
    public void run() {
        System.out.println("Hello myThread01");
    }

    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        myThread01.start();
    }
}
