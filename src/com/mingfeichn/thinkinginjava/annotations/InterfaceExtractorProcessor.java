package com.mingfeichn.thinkinginjava.annotations;

/*import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;*/

public class InterfaceExtractorProcessor /*implements AnnotationProcessor*/ {

    /*private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<>();

    *//**
     * 处理器的构造器
     * 使用AnnotationProcessorEnvironment对象作为参数，通过该对象可以获知apt正在处理的所有类型（类定义），
     * 并通过它获得Messager对象和Filter对象
     * @param env
     *//*
    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) {
        this.env = env;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
            ExtractInterface annot = typeDecl.getAnnotation(ExtractInterface.class);
            if (annot == null) {
                break;
            }

            //找到public方法，不包括static,一旦找到将其加入列表中
            for (MethodDeclaration m : typeDecl.getMethods()) {
                if (m.getModifiers().contains(Modifier.PUBLIC) && !m.getModifiers().contains(Modifier.STATIC)) {
                    interfaceMethods.add(m);
                }
            }

            if (interfaceMethods.size() > 0) {
                try {
                    //Filter是一种PrintWriter，通过他创建新的文件，不使用普通PrintWriter，而是用Filter的原因是这样apt才能知道
                    //我们创建的新文件，从而对文件进行注解处理，并在需要的时候编译它们
                    PrintWriter writer = env.getFiler().createSourceFile(annot.value());
                    writer.println("package " + typeDecl.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + annot.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print(" public");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration parm : m.getParameters()) {
                            m.getParameters();
                            writer.print(parm.getType() + " " + parm.getSimpleName());
                            if (++i < m.getParameters().size())
                                writer.print(", ");
                        }
                        writer.println(")");
                    }
                    writer.println("}");
                    writer.close();
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }

            }
        }
    }*/
}
