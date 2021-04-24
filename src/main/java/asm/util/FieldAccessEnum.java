package asm.util;

public enum FieldAccessEnum {

    ACC_PUBLIC(0x0001, "public "),
    ACC_PRIVATE(0x0002, "private "),
    ACC_PROTECTED(0x0004, "protected "),
    ACC_STATIC(0x0008, "static "),
    ACC_FINAL(0x0010, "final "),
    ACC_VOLATILE(0x0040, "volatile"),
    ACC_TRANSIENT(0x0080, "transient "),
    ACC_SYNTHETIC(0x1000, " inner"),
    ACC_ENUM(0x4000, "enum");

    private int flag;
    private String description;

    FieldAccessEnum(int flag, String description) {
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
