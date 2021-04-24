package asm.chapter04.case03;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.NOP;

public class RemoveNopAdapter extends MethodVisitor {

    public RemoveNopAdapter(int api) {
        super(api);
    }

    public RemoveNopAdapter(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode != NOP) {
            mv.visitInsn(opcode);
        }
    }

}
