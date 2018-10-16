package com.mingfeichn.thinkinginjava.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 要代理的真实对象
        CalculatorImpl calculatorImpl = new CalculatorImpl();

        //要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的实例
        CalculatorHandler calculatorHandler = new CalculatorHandler(calculatorImpl);

        /**
         * 通过Proxy的newProxyInstance方法来创建代理对象
         * 第一个参数 CalculatorImpl.getClass().getClassLoader() ，这里使用CalculatorImpl这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数calculatorImpl.getClass().getInterfaces()，这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数calculatorHandler， 这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         *
         * 为什么这里可以将其转化为Calculator类型的对象？
         * 原因就是在newProxyInstance这个方法的第二个参数上，我们给这个代理对象提供了一组什么接口，那么我这个代理对象就会实现了这组接口，
         * 这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是Subject类型，所以就可以将其转化为Subject类型了
         */
        Calculator calculator = (Calculator) Proxy.newProxyInstance(CalculatorImpl.class.getClassLoader(), calculatorImpl.getClass().getInterfaces(), calculatorHandler);

        /**
         * 通过生成的代理对象调用方法
         *
         * 打印动态代理对象名称
         * 输出“动态代理对象： com.sun.proxy.$Proxy0”，
         * 通过 Proxy.newProxyInstance 创建的代理对象是在jvm运行时动态生成的一个对象，它并不是我们的InvocationHandler类型，也不是我们定义的那组接口的类型，
         * 而是在运行是动态生成的一个对象，并且命名方式都是这样的形式，以$开头，proxy为中，最后一个数字表示对象的标号
         */
        System.out.println("动态代理对象： " + calculator.getClass().getName());
        System.out.println(calculator.add(1, 2));
        System.out.println(calculator.minus(1, 2));
    }
}
