package asm.chapter03.case02;

import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class TraceClassVisitorUse {

    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(printWriter);
        traceClassVisitor.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter02/case02/Comparable", null, "java/lang/Object",
                new String[] {"asm/chapter02/case02/pkg/Measurable"});
        traceClassVisitor.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        traceClassVisitor.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        traceClassVisitor.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        traceClassVisitor.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        traceClassVisitor.visitEnd();
    }

}
