package com.mingfeichn.thinkinginjava.generics;

import java.io.Serializable;

public class ArrayAlg2 {

    /**
     * 类型变量的限定
     * @param a
     * @param <T>
     * @return
     */
    /*public static <T> T min(T[] a){
        if (a == null && a.length == 0)
            return null;

        T smallest = a[0];
        for (int i = 0; i < a.length; i ++){
            //compareTo()方法会报错，因为无法判断T所属的类有该方法
            //解决的方法：将T限制为实现了Compareable接口的类
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }

        return smallest;
    }*/

    /**
     * 限定类型变量
     * 使用extends而不是implements,T和绑定类型可以是类也可以是接口，选择extends是因为更接近子类的概念，T表示绑定类型的字类型（subType）
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T min(T[] a){
        if (a == null && a.length == 0)
            return null;

        T smallest = a[0];
        for (int i = 0; i < a.length; i ++){
            //compareTo()方法会报错，因为无法判断T所属的类有该方法
            //解决的方法：将T限制为实现了Compareable接口的类
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }

        return smallest;
    }

    /**
     * 一个类型变量或通配符可以有多个限定，使用“&”符号隔开限定类型，用逗号分隔类型变量
     * 由于Java的单继承多实现，限定中可以有多个接口，但至多一个类
     * 如果用一个类作为限定，它必须是限定列表中的第一个
     * @param a
     * @param <T>
     * @return
     */
    public static <T extends Comparable & Serializable> T min2(T[] a){
        if (a == null && a.length == 0)
            return null;

        T smallest = a[0];
        for (int i = 0; i < a.length; i ++){
            //compareTo()方法会报错，因为无法判断T所属的类有该方法
            //解决的方法：将T限制为实现了Compareable接口的类
            if (smallest.compareTo(a[i]) > 0)
                smallest = a[i];
        }

        return smallest;
    }
}
