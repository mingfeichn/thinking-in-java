package com.mingfeichn.thinkinginjava.thread;

public class ShareDataThread extends Thread {
    private int count = 5;

    synchronized public void run(){
        super.run();
        count--;
        System.out.println(ShareDataThread.currentThread().getName() + ":" + count );
    }

    public static void main(String[] args) {
        ShareDataThread shareDataThread = new ShareDataThread();
        Thread thread01 = new Thread(shareDataThread, "A");
        Thread thread02 = new Thread(shareDataThread, "B");
        Thread thread03 = new Thread(shareDataThread, "C");
        Thread thread04 = new Thread(shareDataThread, "C");
        Thread thread05 = new Thread(shareDataThread, "C");
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
}
