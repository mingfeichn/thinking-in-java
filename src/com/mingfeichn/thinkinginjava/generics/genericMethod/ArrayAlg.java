package com.mingfeichn.thinkinginjava.generics.genericMethod;


public class ArrayAlg {
    /**
     * 定义了一个泛型方法
     * 泛型方法可以定义在普通类中，也可以定义在泛型类中
     * 类型变量放在修饰符（public static）后面
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getMiddle(T... a){
        return a[a.length / 2];
    }

    //泛型方法的调用，调用中可以省略<String>类型参数
    String middle = ArrayAlg.<String>getMiddle("John", "Q", "Public");
    String middle2 = ArrayAlg.getMiddle("John", "Q", "Public");

}
