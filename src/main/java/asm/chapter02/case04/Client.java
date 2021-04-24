package asm.chapter02.case04;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.*;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * transforming classes
 */
public class Client {

    public static void main(String[] args) {
        way1();
        way2();
    }

    public static void way1() {
        byte[] b1 = readClass();
        ClassWriter cw = new ClassWriter(0);
        ClassReader cr = new ClassReader(b1);
        cr.accept(cw, 0);
        // b2 represents the same class as b1
        byte[] b2 = cw.toByteArray();
    }

    public static void way2() {
        byte[] b1 = readClass();
        ClassWriter cw = new ClassWriter(0);

        // cv forwards all events to cw
        ClassVisitor cv = new ClassVisitor(ASM5, cw) {

        };

        ClassReader cr = new ClassReader(b1);
        cr.accept(cv, 0);
        // b2 represents the same class as b1
        byte[] b2 = cw.toByteArray();
    }

    public static byte[] readClass() {
        File f = new File("E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\asm\\chapter02\\case02");
        LineNumberReader lineNumberReader = null;
        try {
            lineNumberReader = new LineNumberReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        String lineStr = null;
        try {
            lineStr = lineNumberReader.readLine();
        } catch (IOException e) {
            return null;
        }

        try {
            while (lineStr != null) {
                sb.append(lineStr).append("\n");
                lineStr = lineNumberReader.readLine();
            }
        } catch (IOException e) {
            return null;
        }

        return sb.toString().getBytes();
    }

}
