package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicGoodsProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我正在为goods进行统一前置处理");
        methodProxy.invokeSuper(object, objects);
        System.out.println("我正在为goods进行统一后置处理");
        return object;
    }

}
