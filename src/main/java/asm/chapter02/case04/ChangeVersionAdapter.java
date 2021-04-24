package asm.chapter02.case04;

import org.objectweb.asm.ClassVisitor;

import static org.objectweb.asm.Opcodes.ASM5;
import static org.objectweb.asm.Opcodes.V1_8;

public class ChangeVersionAdapter extends ClassVisitor {

    public ChangeVersionAdapter(ClassVisitor cv) {
        super(ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(V1_8, access, name, signature, superName, interfaces);
    }

}
