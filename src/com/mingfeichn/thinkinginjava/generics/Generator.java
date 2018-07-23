package com.mingfeichn.thinkinginjava.generics;

/**
 * 使用泛型创建一个生成器(Generator)
 *
 * @author Mingfei
 * @version Created in 7/23/2018
 */
public interface Generator<T> {
    T next();
}
