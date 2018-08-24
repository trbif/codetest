package cn.code.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString438 {

    //错误的答案，忽略了重叠
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> helperMap = new HashMap<Character,Integer>();
        for(int i=0;i<p.length();i++){
            helperMap.put(p.charAt(i),helperMap.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> result = new ArrayList<Integer>();
        int index = 0;
        boolean flag = true;
        Map<Character,Integer> helperMapWorker = new HashMap<Character,Integer>(helperMap);
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            if(helperMapWorker.containsKey(key)){
                if(flag) {
                    index = i;
                    flag = false;
                }
                int val = helperMapWorker.get(key);
                if(val>0){
                    helperMapWorker.put(key,val-1);
                    if(val==1){
                        helperMapWorker.remove(key);
                        if(helperMapWorker.size()==0){
                            result.add(index);
                            index = i+1;
                            flag = true;
                            helperMapWorker = new HashMap<Character,Integer>(helperMap);
                        }
                    }
                }
            }else{
                index++;
            }
        }
        return result;
    }

    //超时
    public List<Integer> findAnagramsNew(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0) return result;
        Map<Character,Integer> helperMap = new HashMap<Character,Integer>();
        for(int i=0;i<p.length();i++){
            helperMap.put(p.charAt(i),helperMap.getOrDefault(p.charAt(i),0)+1);
        }
        Map<Character,Integer> helperMapWorker = new HashMap<Character,Integer>(helperMap);
        int left = 0;
        int right = 0;
        while(right<s.length()){
            char key = s.charAt(right);
            if(helperMapWorker.containsKey(key)){
                int val = helperMapWorker.get(key);
                if(val==1){
                    helperMapWorker.remove(key);
                    if(helperMapWorker.size()==0){
                        result.add(left);
                        right = (++left);
                        helperMapWorker = new HashMap<Character,Integer>(helperMap);
                        continue;
                    }
                }else if(val>1){
                    helperMapWorker.put(key,val-1);
                }
                right++;
            }else{
                right = (++left);
                helperMapWorker = new HashMap<Character,Integer>(helperMap);
            }
        }
        return result;
    }
    public List<Integer> findAnagramsNewNew(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0) return result;
        int[] helper = new int[256];
        for(int i:p.toCharArray()){
            helper[i]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while(right<s.length()){
            char key = s.charAt(right);
            if(helper[key]>=1){
                helper[key]--;
                count++;
                right++;
            }else if(helper[key]<1){
                for(int i=left;i<right;i++){
                    helper[s.charAt(i)]++;
                }
                right = ++left;
                count = 0;
            }
            if(count==p.length()){
                result.add(left);
                for(int i=left;i<right;i++){
                    helper[s.charAt(i)]++;
                }
                right = ++left;
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new FindAllAnagramsinaString438().findAnagramsNewNew("abacbabc","abc"));
    }
}
