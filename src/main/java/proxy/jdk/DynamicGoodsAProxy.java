package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicGoodsAProxy implements InvocationHandler {
    
    private DynamicGoodsA dynamicGoodsA;

    public DynamicGoodsAProxy(DynamicGoodsA dynamicGoodsA) {
        this.dynamicGoodsA = dynamicGoodsA;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我正在为goods进行统一前置处理");
        Object object = method.invoke(dynamicGoodsA, args);
        System.out.println("我正在为goods进行统一后置处理");
        return object;
    }

}
