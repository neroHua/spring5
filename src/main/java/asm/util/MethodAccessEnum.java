package asm.util;

public enum MethodAccessEnum {

    ACC_PUBLIC(0x0001, "public "),
    ACC_PRIVATE(0x0002, "private "),
    ACC_PROTECTED(0x0004, "protected "),
    ACC_STATIC(0x0008, "static "),
    ACC_FINAL(0x0010, "final "),
    ACC_SYNCHRONIZED(0x0020, "synchronized "),
    ACC_BRIDGE(0x0040, "bridge "),
    ACC_VARARGS(0x0080, "varargs "),
    ACC_NATIVE(0x0100, "native "),
    ACC_ABSTRACT(0x0400, "abstract "),
    ACC_STRICT(0x0800, "strict "),
    ACC_SYNTHETIC(0x1000, "synthetic ");

    private int flag;
    private String description;

    MethodAccessEnum(int flag, String description) {
        this.flag = flag;
        this.description = description;
    }

    public int getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }
}
