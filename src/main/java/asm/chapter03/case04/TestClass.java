package asm.chapter03.case04;

import java.util.List;

public class TestClass {
    private String name;
    private long money = Long.MAX_VALUE;

    private List<String> nameList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public boolean containName(String name) {
        return null == nameList ? false : nameList.contains(name);
    }
}
