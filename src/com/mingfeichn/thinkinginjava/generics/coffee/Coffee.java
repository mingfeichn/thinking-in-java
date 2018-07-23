package com.mingfeichn.thinkinginjava.generics.coffee;

/**
 * 用于生成器演示的coffee类
 *
 * @author Mingfei
 * @version Created in 7/23/2018
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName() + " " + id;
    }
}
