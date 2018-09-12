package com.mingfeichn.thinkinginjava.annotations;

/*import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;*/

/**
 * apt工具需要一个工厂类为其指明正确的处理器，然后才能调用处理器上的process()方法
 */
public class InterfaceExtractorProcessorFactory /*implements AnnotationProcessorFactory*/ {
/*    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }

    *//**
     * 获取注解处理器
     *
     * @param atds 类型声明的Set
     * @param env  AnnotationProcessorEnvironment对象，将传给处理器对象
     * @return 返回注解处理器
     *//*
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }*/
}
