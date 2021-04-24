package asm.util;

public enum ClassAccessEnum {

    ACC_PUBLIC(0x0001, "public "),
    ACC_FINAL(0x0010, "final "),
    ACC_SUPER(0x0020, ""),
    ACC_INTERFACE(0x0200, "interface "),
    ACC_ABSTRACT(0x0400, "abstract "),
    ACC_SYNTHETIC(0x1000, "inner class"),
    ACC_ANNOTATION(0x2000, "@"),
    ACC_ENUM(0x4000, "enum");

    private int flag;
    private String description;

    ClassAccessEnum(int flag, String description) {
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
