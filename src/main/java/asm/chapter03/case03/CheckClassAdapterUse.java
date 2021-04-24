package asm.chapter03.case03;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class CheckClassAdapterUse {

    public static void main(String[] args) {
        chainOrder1();
        chainOrder2();
    }

    private static void chainOrder1() {
        PrintWriter printWriter = new PrintWriter(System.out);

        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor tcv = new TraceClassVisitor(cw, printWriter);
        CheckClassAdapter checkClassAdapter = new CheckClassAdapter(tcv);

        checkClassAdapter.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter02/case02/Comparable", null, "java/lang/Object",
                new String[] {"asm/chapter02/case02/pkg/Measurable"});
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        checkClassAdapter.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        checkClassAdapter.visitEnd();
        byte[] b = cw.toByteArray();
    }

    private static void chainOrder2() {
        PrintWriter printWriter = new PrintWriter(System.out);

        ClassWriter cw = new ClassWriter(0);
        CheckClassAdapter cca = new CheckClassAdapter(cw);
        TraceClassVisitor checkClassAdapter = new TraceClassVisitor(cca, printWriter);

        checkClassAdapter.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter02/case02/Comparable", null, "java/lang/Object",
                new String[] {"asm/chapter02/case02/pkg/Measurable"});
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        checkClassAdapter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        checkClassAdapter.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        checkClassAdapter.visitEnd();
        byte[] b = cw.toByteArray();
    }

}
