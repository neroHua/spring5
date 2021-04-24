package asm.chapter03.case01;

import org.objectweb.asm.Type;

public class TypeUse {

    public static void test01() {
        String internalName = Type.getType(String.class).getInternalName();
        System.out.println(internalName);
    }

    public static void test02() {
        String descriptor = Type.getDescriptor(String.class);
        System.out.println(descriptor);
    }

    public static void test03() {
        String descriptor = Type.INT_TYPE.getDescriptor();
        System.out.println(descriptor);
    }

    public static void test04() {
        String descriptor = Type.VOID_TYPE.getDescriptor();
        String className = Type.VOID_TYPE.getClassName();
        System.out.println(descriptor);
        System.out.println(className);
    }

    public static void test05() {
        Type[] argumentTypes = Type.getArgumentTypes("(I)V");
        for (int i = 0; i < argumentTypes.length; i++) {
            String descriptor = argumentTypes[i].getDescriptor();
            System.out.println(descriptor);
        }
    }

    public static void test06() {
        Type returnType = Type.getReturnType("(I)V");
        System.out.println(returnType.getDescriptor());
    }

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
        test05();
        test06();
    }

}
