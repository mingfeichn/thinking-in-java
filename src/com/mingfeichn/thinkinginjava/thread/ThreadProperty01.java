package com.mingfeichn.thinkinginjava.thread;

public class ThreadProperty01 extends Thread {
    public void run(){
        System.out.println("MyThread1 run priority=" + this.getPriority());
        ThreadProperty01 thread01 = new ThreadProperty01();
        thread01.start();
    }
}
