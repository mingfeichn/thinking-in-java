package com.mingfeichn.thinkinginjava.generics;

import java.util.Iterator;

/**
 * 通过适配器扩展Fibonacci类
 *
 * @author Mingfei
 * @version Created in 7/23/2018
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)){ //提供一个边界值，hasNext()才能知道何时返回false
            System.out.println(i + " ");
        }
    }
}
