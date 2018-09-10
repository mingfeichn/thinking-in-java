package com.mingfeichn.thinkinginjava.generics;

import java.io.Serializable;

/**
 * 泛型代码和虚拟机
 * 虚拟机没有泛型类型对象，所有对象都属于普通类
 * 无论何时定义一个泛型类型，都自动提供了一个相应的原始类型（raw type）
 * 原始类型的名字是删去类型参数后的泛型类名，擦除类型变量，并替换为限定类型（无限定的变量用Object）
 */
public class Pair2<T> {
}

/**
 * Pair2<T>泛型类的原始类型
 */
//public class Pair2{}


/**
 * 原始类型用第一个限定的类型变量来替换
 * 一般将标签接口放在边界列表的末尾
 */
//public class Interval<T extends Comparable & Serializable> implements Serializable{
//  private T lower;
//  private T upper;
//
//  public Interval(T first, T second){
//      if(first.compareTo(second) <= 0){lower = first; upper = second;}
//      else {lower = second; upper = first;}
//  }
// }

//public class Interval implements Serializable{
//  private Comparable lower;
//  private Comparable upper;
//
//  public Interval(Comparable first, Comparable second) {...}
// }