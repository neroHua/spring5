package asm.util;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.ASM5;

public class BiteCodeViewer extends ClassVisitor {

    public BiteCodeViewer() {
        super(ASM5);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.print(viewClassAccess(access) + name + " extends " + superName + " implements ");
        if (null != interfaces && interfaces.length > 0) {
            for (String interfaceName : interfaces) {
                System.out.print(interfaceName + ", ");
            }
        }
        System.out.println(" {");
    }

    public void visitSource(String source, String debug) {
    }

    public void visitOuterClass(String owner, String name, String desc) {
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return null;
    }

    public void visitAttribute(Attribute attr) {
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        System.out.println(viewFieldAccess(access) + " " + desc + " " + name + " = " + value);
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println(viewMethodAccess(access) + " " + name + desc);
        return null;
    }

    public void visitEnd() {
        System.out.println("}");
    }

    private String viewClassAccess(int access) {
        String accessString = "";
        accessString += (access & ClassAccessEnum.ACC_PUBLIC.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_PUBLIC.getDescription();
        accessString += (access & ClassAccessEnum.ACC_FINAL.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_FINAL.getDescription();
        accessString += (access & ClassAccessEnum.ACC_INTERFACE.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_INTERFACE.getDescription();
        accessString += (access & ClassAccessEnum.ACC_ABSTRACT.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_ABSTRACT.getDescription();
        accessString += (access & ClassAccessEnum.ACC_ANNOTATION.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_ANNOTATION.getDescription();
        accessString += (access & ClassAccessEnum.ACC_ENUM.getFlag()) <= 0 ? "" : ClassAccessEnum.ACC_ENUM.getDescription();
        return accessString;
    }

    private String viewFieldAccess(int access) {
        String accessString = "";
        accessString += (access & FieldAccessEnum.ACC_PUBLIC.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_PUBLIC.getDescription();
        accessString += (access & FieldAccessEnum.ACC_PRIVATE.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_PRIVATE.getDescription();
        accessString += (access & FieldAccessEnum.ACC_PROTECTED.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_PROTECTED.getDescription();
        accessString += (access & FieldAccessEnum.ACC_STATIC.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_STATIC.getDescription();
        accessString += (access & FieldAccessEnum.ACC_FINAL.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_FINAL.getDescription();
        accessString += (access & FieldAccessEnum.ACC_VOLATILE.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_VOLATILE.getDescription();
        accessString += (access & FieldAccessEnum.ACC_TRANSIENT.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_TRANSIENT.getDescription();
        accessString += (access & FieldAccessEnum.ACC_SYNTHETIC.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_SYNTHETIC.getDescription();
        accessString += (access & FieldAccessEnum.ACC_ENUM.getFlag()) <= 0 ? "" : FieldAccessEnum.ACC_ENUM.getDescription();
        return accessString;
    }

    private String viewMethodAccess(int access) {
        String accessString = "";
        accessString += (access & MethodAccessEnum.ACC_PUBLIC.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_PUBLIC.getDescription();
        accessString += (access & MethodAccessEnum.ACC_PRIVATE.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_PRIVATE.getDescription();
        accessString += (access & MethodAccessEnum.ACC_PROTECTED.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_PROTECTED.getDescription();
        accessString += (access & MethodAccessEnum.ACC_STATIC.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_STATIC.getDescription();
        accessString += (access & MethodAccessEnum.ACC_FINAL.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_FINAL.getDescription();
        accessString += (access & MethodAccessEnum.ACC_SYNCHRONIZED.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_SYNCHRONIZED.getDescription();
        accessString += (access & MethodAccessEnum.ACC_BRIDGE.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_BRIDGE.getDescription();
        accessString += (access & MethodAccessEnum.ACC_VARARGS.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_VARARGS.getDescription();
        accessString += (access & MethodAccessEnum.ACC_NATIVE.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_NATIVE.getDescription();
        accessString += (access & MethodAccessEnum.ACC_ABSTRACT.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_ABSTRACT.getDescription();
        accessString += (access & MethodAccessEnum.ACC_STRICT.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_STRICT.getDescription();
        accessString += (access & MethodAccessEnum.ACC_SYNTHETIC.getFlag()) <= 0 ? "" : MethodAccessEnum.ACC_SYNTHETIC.getDescription();
        return accessString;
    }
}
