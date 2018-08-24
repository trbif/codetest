package cn.code.lc;

import java.util.*;

public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {

        class KeySort{
            int id;
            int key;
            public KeySort(int id,int key){
                this.id = id;
                this.key = key;
            }
            public int getId(){
                return this.id;
            }
            public int getKey(){
                return this.key;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        Map<Integer,Integer> helper1 = new HashMap<Integer,Integer>();
        TreeMap<KeySort,Integer> helper2 = new TreeMap<KeySort,Integer>(new Comparator<KeySort>() {
            @Override
            public int compare(KeySort o1, KeySort o2) {
                if(o2.key>o1.key) return 1;
                else if(o2.key<o1.key) return -1;
                else{
                    return o2.id-o1.id;
                }
            }
        });
        for(int i=0;i<nums.length;i++){
            helper1.put(nums[i],helper1.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:helper1.entrySet()){
            helper2.put(new KeySort(entry.getKey(),entry.getValue()),entry.getKey());
        }
        for(Map.Entry<KeySort,Integer> entry:helper2.entrySet()){
            if(k<=0) break;
            result.add(entry.getValue());
            k--;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,2};
        System.out.println(new TopKFrequentElements347().topKFrequent(nums,2));
    }
}
