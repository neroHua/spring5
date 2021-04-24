package asm.chapter02.case03;

/**
 * using generated class
 */
class MyClassLoader extends ClassLoader {

    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }

}
