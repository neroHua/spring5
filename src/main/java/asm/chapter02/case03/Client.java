package asm.chapter02.case03;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

/**
 * use generated class
 */
public class Client {

    public static void main(String[] args) throws ClassNotFoundException {
        way1();
        way2();
    }

    private static void way1() {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "asm/chapter02/case02/Comparable", null, "java/lang/Object",
                new String[] {"asm/chapter02/case02/Measurable"});
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "GREATER", "I",
                null, new Integer(1)).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo",
                "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        byte[] b = cw.toByteArray();

        MyClassLoader myClassLoader = new MyClassLoader();
        Class c = myClassLoader.defineClass("asm.chapter02.case02.Comparable", b);
        System.out.println(c.getName());
        System.out.println(c.getTypeName());
    }

    private static void way2() throws ClassNotFoundException {
        StubClassLoader stubClassLoader = new StubClassLoader();
        Class c = stubClassLoader.findClass("asm.chapter02.case02.Comparable_Stub");
        System.out.println(c.getName());
        System.out.println(c.getTypeName());
    }

}
