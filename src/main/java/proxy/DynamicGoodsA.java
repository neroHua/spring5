package proxy.jdk;

public class DynamicGoodsA implements DynamicGoods {
    
    private int price;
    private String name;
    
    public DynamicGoodsA(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void showMyPrice() {
        System.out.println("我的价格是:" + this.price);
    }

    @Override
    public void showMyName() {
        System.out.println("我的名字是:" + this.name);
    }

}
