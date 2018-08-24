package cn.code.javaex.IOC.exa;

/**
 * @Description: 要注入的DAo类
 * @ClassName: UserDaoImpl
 * @Project: spring-aop
 * @Author: zxf
 * @Date: 2011-6-7
 */
public class UserDaoImpl {

    String name ;

    public void show(){
        System.out.println("这里是dao方法........");
    }
}
