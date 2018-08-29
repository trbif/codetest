package cn.code.javaex.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: codetest
 * @Description: 描述
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/29 16:44
 * @Version: 1.0.0
 */
public class Concurrent {
    public void mapFor(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        for(Map.Entry entry:map.entrySet()){
            map.remove("1");
        }
    }
    public void mapIterater(){
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            iterator.remove();
        }
    }
    public void concurrentMapFor(){
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("1","1");
        map.put("2","1");
        for(Map.Entry entry:map.entrySet()){
            map.remove("1");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Concurrent concurrent = new Concurrent();
        concurrent.mapIterater();
        Map<String,String> map = new HashMap<>();
        new MapPutThread(map).start();
        new MapRemoveThread(map).start();
    }
}

class MapRemoveThread extends Thread{
    private Map<String,String> map;
    public MapRemoveThread(Map<String,String> map){
        this.map = map;
    }
    @Override
    public void run(){
        while(true){
            Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> entry = iterator.next();
                System.out.println("remove: "+entry.getKey());
                iterator.remove();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MapPutThread extends Thread{
    private Map<String,String> map;
    public MapPutThread(Map<String,String> map){
        this.map = map;
    }
    @Override
    public void run(){
        long count = 1;
        while(true){
            map.put(count+"","");
//            System.out.println("put: "+count);
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
