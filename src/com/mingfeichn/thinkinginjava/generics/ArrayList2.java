package com.mingfeichn.thinkinginjava.generics;

import java.io.File;

/**
 * 为什么要使用泛型程序设计
 * 这是一个增加泛型类之前的ArrayList类
 */
public class ArrayList2 {
    private Object[] elementData;

    //...
    public Object get(int i) {
        //...

        return elementData[i];
    }

    public void add(Object o) {
        //...
    }

    public static void main(String[] args) {
        ArrayList2 files = new ArrayList2();

        //...

        //1. 当获取一个值时必须进行强制类型转换
        String fileNem = (String) files.get(0);

        //2. 没有错误检查，可以向列表中增加任何类型的对象
        files.add(new File("..."));
    }
}
