package asm.chapter04.case04;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) throws IOException {
        compare();
        changeCToCChange();
    }

    public static void compare() throws IOException {
        PrintWriter printWriter1 = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor1 = new TraceClassVisitor(printWriter1);
        ClassReader classReader1 = new ClassReader(new FileInputStream(new File("E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\asm\\chapter04\\case04\\C.class")));
        classReader1.accept(traceClassVisitor1, 0);

        PrintWriter printWriter2 = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor2 = new TraceClassVisitor(printWriter2);
        ClassReader classReader2 = new ClassReader(new FileInputStream(new File("E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\asm\\chapter04\\case04\\CChange.class")));
        classReader2.accept(traceClassVisitor2, 0);
    }

    private static void changeCToCChange() throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(printWriter);

        AddTimerAdapter addTimerAdapter = new AddTimerAdapter(traceClassVisitor);

        ClassReader classReader = new ClassReader(new FileInputStream(new File("E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\asm\\chapter04\\case04\\C.class")));
        classReader.accept(addTimerAdapter, 0);
    }

}
