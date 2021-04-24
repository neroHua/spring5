package asm.chapter04.case05;

import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.*;

/**
 * When an ICONST_0 is visited,
 * it must be removed only if the next instruction is an IADD.
 */
public class RemoveAddZeroAdapter extends PatternMethodAdapter {

    private static int SEEN_ICONST_0 = 1;

    public RemoveAddZeroAdapter(MethodVisitor mv) {
        super(ASM5, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        if (state == SEEN_ICONST_0) {
            if (opcode == IADD) {
                state = SEEN_NOTHING;
                return;
            }
        }
        visitInsn();
        if (opcode == ICONST_0) {
            state = SEEN_ICONST_0;
            return;
        }
        mv.visitInsn(opcode);
    }

    protected void visitInsn() {
        if (state == SEEN_ICONST_0) {
            mv.visitInsn(ICONST_0);
        }
        state = SEEN_NOTHING;
    }

}
