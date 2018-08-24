package cn.code.javaex.AOP.exa;

public class HumenImpl implements Humen {
    @Override
    public void eat(String food) {
        System.out.println("eat " + food);
    }
}
