package com.mingfeichn.thinkinginjava.generics;

/**
 * 二维元组
 *
 * @author Mingfei
 * @version Created in 7/20/2018
 */
public class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }
}
