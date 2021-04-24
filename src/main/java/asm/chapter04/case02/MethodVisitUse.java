package asm.chapter04.case02;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

import static org.objectweb.asm.Opcodes.*;

public class MethodVisitUse {

    public static void main(String[] args) throws IOException {
        way1();
        way2();
        way3();
    }

    public static void way1() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter04/case02/Bean", null, "java/lang/Object",
                null);

        cw.visitField(ACC_PRIVATE , "f", "I", null, null).visitEnd();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "getF", "()I", null, null);
        cw.visitMethod(ACC_PUBLIC, "setF", "(I)V", null, null).visitEnd();

        cw.visitEnd();
        byte[] b = cw.toByteArray();

        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(printWriter);
        ClassReader cr = new ClassReader(b);
        cr.accept(traceClassVisitor, 0);
    }

    public static void way2() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter04/case02/Bean", null, "java/lang/Object",
                null);

        cw.visitField(ACC_PRIVATE , "f", "I", null, null).visitEnd();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "getF", "()I", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, "asm/chapter04/case02/Bean", "f", "I");
        mv.visitInsn(IRETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();

        cw.visitMethod(ACC_PUBLIC, "setF", "(I)V", null, null).visitEnd();

        cw.visitEnd();
        byte[] b = cw.toByteArray();

        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(printWriter);
        ClassReader cr = new ClassReader(b);
        cr.accept(traceClassVisitor, 0);
    }

    public static void way3() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter04/case02/Bean", null, "java/lang/Object",
                null);

        cw.visitField(ACC_PRIVATE , "f", "I", null, null).visitEnd();

        MethodVisitor methodVisitor = cw.visitMethod(ACC_PUBLIC, "getF", "()I", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(ALOAD, 0);
        methodVisitor.visitFieldInsn(GETFIELD, "asm/chapter04/case02/Bean", "f", "I");
        methodVisitor.visitInsn(IRETURN);
        methodVisitor.visitMaxs(1, 1);
        methodVisitor.visitEnd();

        cw.visitMethod(ACC_PUBLIC, "setF", "(I)V", null, null).visitEnd();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "checkAndSetF", "(I)V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ILOAD, 1);
        Label label = new Label();
        mv.visitJumpInsn(IFLT, label);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(ILOAD, 1);
        mv.visitFieldInsn(PUTFIELD, "pkg/Bean", "f", "I");
        Label end = new Label();
        mv.visitJumpInsn(GOTO, end);
        mv.visitLabel(label);
        mv.visitFrame(F_SAME, 0, null, 0, null);
        mv.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "()V");
        mv.visitInsn(ATHROW);
        mv.visitLabel(end);
        mv.visitFrame(F_SAME, 0, null, 0, null);
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 2);
        mv.visitEnd();

        cw.visitEnd();
        byte[] b = cw.toByteArray();

        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(printWriter);
        ClassReader cr = new ClassReader(b);
        cr.accept(traceClassVisitor, 0);
    }

}
