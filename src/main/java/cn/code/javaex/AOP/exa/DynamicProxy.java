package cn.code.javaex.AOP.exa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    public DynamicProxy(Object target){
        this.target = target;
    }

    private void before(){
        System.out.println("eat before");
    }
    private void after(){
        System.out.println("eat after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    public static void main(String[] args){
        Humen humen = new HumenImpl();
        humen.eat("rice");
        DynamicProxy dynamicProxy = new DynamicProxy(humen);
        Humen humenProxy = dynamicProxy.getProxy();

//        Humen humenProxy = (Humen) Proxy.newProxyInstance(
//                humen.getClass().getClassLoader(),
//                humen.getClass().getInterfaces(),
//                dynamicProxy
//        );

        humenProxy.eat("rice");
    }
}
