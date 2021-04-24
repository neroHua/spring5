package asm.chapter02.case03;

import org.objectweb.asm.ClassWriter;

import static org.objectweb.asm.Opcodes.*;

public class StubClassLoader extends ClassLoader {
    @Override
    protected Class findClass(String name) throws ClassNotFoundException {
        if (name.endsWith("_Stub")) {
            ClassWriter cw = new ClassWriter(0);
            cw.visit(V1_8, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                    "asm/chapter02/case02/Comparable_Stub", null, "java/lang/Object",
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
            return defineClass(name, b, 0, b.length);
        }

        return super.findClass(name);
    }

}
