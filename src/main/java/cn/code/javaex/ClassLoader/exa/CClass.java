package cn.code.javaex.ClassLoader.exa;

public class CClass extends FClass {
    static {
        System.out.println("CClass");
    }

    public static void main(String[] args){
        System.out.println(FClass.value);
    }
}
