package com.mingfeichn.thinkinginjava.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通过sleep阻塞线程，演示倒计时
 */
public class SleepDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Date endDate = new Date(System.currentTimeMillis() + 10 * 01000);
        long endTime = endDate.getTime();

        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endDate));
            Thread.sleep(1000);
            endDate = new Date(endDate.getTime() - 1000);
            if (endTime - 10000 > endDate.getTime()){
                break;
            }

        }
    }
}
