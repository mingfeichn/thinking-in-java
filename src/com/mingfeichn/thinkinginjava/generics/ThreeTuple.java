package com.mingfeichn.thinkinginjava.generics;

/**
 * 三维元组
 *
 * @author Mingfei
 * @version Created in 7/20/2018
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    public String toString() {
        return "(" + first + "," + second + "," + third + ")";
    }
}
