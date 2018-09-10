package com.mingfeichn.thinkinginjava.generics.pair;

/**
 * 定义一个简单的泛型类Pair
 * Pair类引入了泛型变量T， 使用<>括起来，并放在类名的后面
 * 泛型类可以有多个类型变量，如： Pair<T, U>
 * @param <T>
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
