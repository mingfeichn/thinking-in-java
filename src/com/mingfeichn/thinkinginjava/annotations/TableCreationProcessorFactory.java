package com.mingfeichn.thinkinginjava.annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

import java.util.Collection;
import java.util.Set;

public class TableCreationProcessorFactory implements AnnotationProcessorFactory {
    @Override
    public Collection<String> supportedOptions() {
        return null;
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return null;
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return new TableCreationProcessor(env);
    }

    /**
     * 处理器
     */
    private static class TableCreationProcessor implements AnnotationProcessor {
        private final AnnotationProcessorEnvironment env;

        private String sql = "";

        public TableCreationProcessor(AnnotationProcessorEnvironment env) {
            this.env = env;
        }

        @Override
        public void process() {

        }
    }

    /**
     * 访问者
     */
    private class TableCreationVisitor extends SimpleDeclarationVisitor {
        public void visitClassDeclaration(ClassDeclaration d) {

        }

        public void visitFieldDeclaration(FieldDeclaration d) {

        }

        /**
         * 获取约束
         * @param con
         * @return
         */
        private String getConstraints(Constraints con) {
            String constraints = "";
            if (!con.allowNull())
                constraints += " NOT NULL";
            if (con.primaryKey())
                constraints += " PRIMARY KEY";
            if (con.unique())
                constraints += " UNIQUE";

            return constraints;
        }
    }
}


