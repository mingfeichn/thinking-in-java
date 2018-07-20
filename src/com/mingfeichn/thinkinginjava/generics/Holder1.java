package com.mingfeichn.thinkinginjava.generics;

/**
 * 引用固定类型
 *
 * @author Mingfei
 * @version Created in 7/20/2018
 */
public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
}

class Automobile {
}
