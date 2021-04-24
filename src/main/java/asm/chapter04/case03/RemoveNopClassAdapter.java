package asm.chapter04.case03;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public class RemoveNopClassAdapter extends ClassVisitor {
    public RemoveNopClassAdapter(int api) {
        super(api);
    }

    public RemoveNopClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv;
        mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv != null) {
            mv = new RemoveNopAdapter(api, mv);
        }
        return mv;
    }

}
