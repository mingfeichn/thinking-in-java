package com.mingfeichn.thinkinginjava.thread;

/**
 * 演示线程优先级
 */
public class PropertyDemo01{

    public static void main(String[] args) throws InterruptedException {
        MyThread runnable1 = new MyThread();
        Thread thread1 = new Thread(runnable1, "线程1");
        MyThread runnable2 = new MyThread();
        Thread thread2 = new Thread(runnable2, "线程2");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        Thread.sleep(200);
        runnable1.stop();
        runnable2.stop();
    }
}
