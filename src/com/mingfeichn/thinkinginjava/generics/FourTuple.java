package com.mingfeichn.thinkinginjava.generics;

/**
 * 四维元组
 *
 * @author Mingfei
 * @version Created in 7/20/2018
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {

    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    public String toString() {
        return "(" + first + "," + second + "," + third + "," + fourth + ")";
    }
}
