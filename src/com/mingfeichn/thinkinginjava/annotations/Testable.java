package com.mingfeichn.thinkinginjava.annotations;

/**
 * 使用@Test对testExecute()方法进行注解
 */
public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }

    @Test
    void testExecute() {
        execute();
    }
}