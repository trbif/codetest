package cn.code.javaex.threadlocal;

import java.util.Random;

/**
 * @ProjectName: codetest
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/29 14:23
 * @Version: 1.0.0
 */
public class TestThreadLocal {

    private static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new LocalTestThread(local).start();
        }
    }
}

class LocalTestThread extends Thread{
    private ThreadLocal<Integer> threadLocal;
    public LocalTestThread(ThreadLocal<Integer> threadLocal) {
        this.threadLocal = threadLocal;
    }
    @Override
    public void run(){
        threadLocal.set(new Random().nextInt());
        System.out.println(threadLocal.get());
    }
}
