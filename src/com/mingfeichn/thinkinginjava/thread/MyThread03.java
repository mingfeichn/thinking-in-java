package com.mingfeichn.thinkinginjava.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread03 implements Callable {
    @Override
    public String call() throws Exception {
        String str = "Hello myThread03";
        System.out.println(str);

        return str;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new MyThread03();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread myThread03 = new Thread(futureTask);
        myThread03.start();
        System.out.println(futureTask.get());
    }
}
