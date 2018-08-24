package cn.code.lc;

import java.util.*;

public class TopKFrequentWords692 {
    //°´ÕÕ³ö³¡Ë³Ðò
    public List<String> topKFrequent(String[] words, int k) {
        class KeySort{
            int id;
            int key;
            public KeySort(int id,int key){
                this.id = id;
                this.key = key;
            }
            KeySort addKey(){
                key++;
                return this;
            }

            @Override
            public String toString() {
                return id+"-"+key;
            }
        }
        List<String> result = new ArrayList<String>();
        Map<String,KeySort> helper1 =new HashMap<String,KeySort>();
        int id = 0;
        for(String str:words){
            helper1.put(str,helper1.getOrDefault(str,new KeySort(id++,0)).addKey());
        }
        Map<KeySort,String> helper2 = new TreeMap<KeySort,String>(new  Comparator<KeySort>(){

            @Override
            public int compare(KeySort o1, KeySort o2) {
                if(o2.key==o1.key) return o1.id-o2.id;
                return o2.key-o1.key;
            }
        });
        for(Map.Entry<String,KeySort> entry:helper1.entrySet()){
            helper2.put(entry.getValue(),entry.getKey());
        }
        for(Map.Entry<KeySort,String> entry:helper2.entrySet()){
            if(k<=0) break;
            result.add(entry.getValue());
            k--;
        }
        System.out.println(helper2);
        return result;
    }
    //°´ÕÕÊ××ÖÄ¸Ë³Ðò
    public List<String> topKFrequentNew(String[] words, int k) {
        class KeySort{
            String id;
            int key;
            public KeySort(String id,int key){
                this.id = id;
                this.key = key;
            }
            public String getId(){
                return this.id;
            }
            public int getKey(){
                return this.key;
            }
        }
        List<String> result = new ArrayList<String>();
        Map<String,Integer> helper1 =new HashMap<String,Integer>();
        for(String str:words){
            helper1.put(str,helper1.getOrDefault(str,0)+1);
        }
        Map<KeySort,String> helper2 = new TreeMap<KeySort,String>(new  Comparator<KeySort>(){

            @Override
            public int compare(KeySort o1, KeySort o2) {
                if(o2.key==o1.key) return o1.id.compareTo(o2.id);
                return o2.key-o1.key;
            }
        });
        for(Map.Entry<String,Integer> entry:helper1.entrySet()){
            helper2.put(new KeySort(entry.getKey(),entry.getValue()),entry.getKey());
        }
        for(Map.Entry<KeySort,String> entry:helper2.entrySet()){
            if(k<=0) break;
            result.add(entry.getValue());
            k--;
        }
        return result;
    }
    public List<String> topKFrequentNewNew(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public static void main(String[] args){
        String[] words = {"a","aa"};
        System.out.println(new TopKFrequentWords692().topKFrequentNewNew(words,2));
    }

}
