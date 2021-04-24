package proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        saveProxyFile();

        DynamicGoods dynamicGoodsAProxy = (DynamicGoods) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[] {DynamicGoods.class}, new DynamicGoodsAProxy(new DynamicGoodsA(10, "动态商品A")));
        dynamicGoodsAProxy.showMyPrice();
        dynamicGoodsAProxy.showMyName();
        System.out.println(dynamicGoodsAProxy.getClass());
    }

    private static void saveProxyFile() {
        FileOutputStream out = null;
        try {
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", DynamicGoodsA.class.getInterfaces());
            out = new FileOutputStream( "E:\\ideaLearnSpace\\book\\spring5\\src\\main\\java\\proxy\\jdk\\" + "$Proxy0.class");
            out.write(classFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
