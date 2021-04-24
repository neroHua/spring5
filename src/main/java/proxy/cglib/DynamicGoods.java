package proxy.cglib;

public class DynamicGoods {

    private int price = 3;
    private String name = "itemA";

    public DynamicGoods() {
        this.price = price;
        this.name = name;
    }

    public void showMyPrice() {
        System.out.println("我的价格是:" + this.price);
    }

    public void showMyName() {
        System.out.println("我的名字是:" + this.name);
    }

}
