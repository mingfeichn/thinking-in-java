package com.mingfeichn.thinkinginjava.generics;

import java.util.*;

/**
 * 使用泛型实现的容器工具类，类型参数推断避免了重复的泛型参数列表
 *
 * @author Mingfei
 * @version Created in 7/23/2018
 */
public class New {
    public static <K, V> Map<K, V> map(){
        return new HashMap<>();
    }

    public static <T> List<T> list(){
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> lList(){
        return new LinkedList<>();
    }

    public static <T> Set<T> set(){
        return new HashSet<>();
    }

    public static <T> Queue<T> queue(){
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.lList();
        Set<String> ss = New.set();
        Queue<String> qs = New.queue();
    }
}
