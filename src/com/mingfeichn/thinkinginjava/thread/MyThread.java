package com.mingfeichn.thinkinginjava.thread;

public class MyThread implements Runnable {
    private boolean flag = true;
    private int num = 10;

    @Override
    public void run() {
        while (flag) {
            test3();
        }

    }

    /**
     * 线程不安全
     */
    private void test1() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> " + num--);
    }

    /**
     * 线程安全， 同步方法
     */
    private synchronized void test2() {
        if (num <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> " + num--);
    }

    /**
     * 线程安全，同步块
     */
    private void test3() {
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--> " + num--);
        }
    }

    /**
     * 线程不安全，锁定范围过小
     */
    private void test4() {
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> " + num--);
    }

    /**
     * 线程不安全，锁定資源不正确
     */
    private void test5() {
        synchronized (((Integer) num)) {
            if (num <= 0) {
                flag = false;
                return;
            }
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--> " + num--);
    }

    public void stop() {
        this.flag = !this.flag;
    }
}
