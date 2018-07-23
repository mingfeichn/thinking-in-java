package com.mingfeichn.thinkinginjava.generics;

import javafx.scene.effect.PerspectiveTransform;

import java.util.Map;

/**
 * 类型推断的演示
 *
 * @author Mingfei
 * @version Created in 7/23/2018
 */
public class SimplerPets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
    }
}
