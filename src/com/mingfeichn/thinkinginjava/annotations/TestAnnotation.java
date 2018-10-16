package com.mingfeichn.thinkinginjava.annotations;

import java.lang.annotation.*;

/**
 * 定义@Test注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
}
