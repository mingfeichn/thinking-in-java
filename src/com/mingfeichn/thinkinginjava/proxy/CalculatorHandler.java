package com.mingfeichn.thinkinginjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorHandler implements InvocationHandler {

    /**
     * 要代理的真实对象
     */
    private Object obj;

    /**
     * 构造方法，要代理的真实对象赋初值
     * @param obj
     */
    public CalculatorHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * 调用真实对象实例的方法并返回结果
     * 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
     *
     * @param proxy  调用该方法的代理实例
     * @param method 被调用真实对象的某个方法的对象
     * @param args   调用方法的参数
     * @return 调用方法返回的结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[CalculatorHandler]before invoke");
        Object ret = method.invoke(obj, args);
        System.out.println("[CalculatorHandler]after invoke");

        return ret;
    }
}
