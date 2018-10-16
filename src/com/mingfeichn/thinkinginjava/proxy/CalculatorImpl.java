package com.mingfeichn.thinkinginjava.proxy;

/**
 * 被代理类，实现Calculator接口
 */
public class CalculatorImpl implements Calculator {

    @Override
    public Integer add(Integer num1, Integer num2) {
        System.out.println("[CalculatorImpl]|add方法");

        return num1 + num2;
    }

    @Override
    public Integer minus(Integer num1, Integer num2) {
        System.out.println("[CalculatorImpl]|minus方法");

        return num1 - num2;
    }
}
