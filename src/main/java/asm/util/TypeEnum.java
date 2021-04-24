package asm.util;

public enum TypeEnum {

    BOOLEAN("boolean", "Z", ""),
    CHAR("char", "C", ""),
    BYTE("byte", "B", ""),
    SHORT("short", "S", ""),
    INT("int", "I", ""),
    FLOAT("float", "F", ""),
    LONG("long", "J", ""),
    DOUBLE("double", "D", ""),
    // Obejct  <-> Ljava/lang/Object
    OBJECT("Object", "L", ""),
    // int[]        <-> [I
    // int[][]      <-> [[I
    // Ojbect[]     <-> [Ljava/lang/Object
    // Ojbect[][]   <-> [[Ljava/lang/Object
    ARRAY("array", "[", "");

    private String javaType;
    private String classType;
    private String description;

    TypeEnum(String javaType, String classType, String description) {
        this.javaType = javaType;
        this.classType = classType;
        this.description = description;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getClassType() {
        return classType;
    }

    public String getDescription() {
        return description;
    }
}
