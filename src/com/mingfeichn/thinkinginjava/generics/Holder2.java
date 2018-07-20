package com.mingfeichn.thinkinginjava.generics;

/**
 * 引用Object类
 *
 * @author Mingfei
 * @version Created in 7/20/2018
 */
public class Holder2 {
    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }

    public void set(Object a) {
        this.a = a;
    }

    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not a Automobile");
        String s = (String) h2.get();
        h2.set(1); //自动装箱为Integer
        Integer x = (Integer) h2.get();
    }
}
