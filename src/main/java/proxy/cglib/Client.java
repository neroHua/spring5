package proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Client {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\proxy\\cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DynamicGoods.class);
        enhancer.setCallback(new DynamicGoodsProxy());
        DynamicGoods dynamicGoodsProxy = (DynamicGoods) enhancer.create();

        dynamicGoodsProxy.showMyName();
        dynamicGoodsProxy.showMyPrice();

        DynamicGoods dynamicGoods = new DynamicGoods();
        System.out.println(dynamicGoods.getClass());
        System.out.println(dynamicGoodsProxy.getClass());
    }
}
