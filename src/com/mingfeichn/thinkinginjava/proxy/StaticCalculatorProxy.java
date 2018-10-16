package com.mingfeichn.thinkinginjava.proxy;

/**
 * 静态代理类
 */
public class StaticCalculatorProxy implements Calculator {
    Calculator obj;

    public StaticCalculatorProxy(Calculator obj) {
        this.obj = obj;
    }

    @Override
    public Integer add(Integer num1, Integer num2) {
        System.out.println("[StaticCalculatorProxy]before invoke real add");
        Integer ret = obj.add(num1, num2);
        System.out.println("[StaticCalculatorProxy]after invoke real add");

        return ret;
    }

    @Override
    public Integer minus(Integer num1, Integer num2) {
        System.out.println("[StaticCalculatorProxy]before invoke real minus");
        Integer ret = obj.minus(num1, num2);
        System.out.println("[StaticCalculatorProxy]after invoke real minus");

        return ret;
    }
}
