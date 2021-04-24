package asm.chapter02.case01;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 * read class
 */
public class Client {
    public static void main(String[] args) throws IOException {
        ClassPrinter cp = new ClassPrinter();
        ClassReader cr = new ClassReader("java.lang.Runnable");
        cr.accept(cp, 0);
    }
}
