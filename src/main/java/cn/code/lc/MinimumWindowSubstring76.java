package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if(s==null||s.length()==0) return "";
        int[] helper = new int[256];
        for(int i:p.toCharArray()){
            helper[i]++;
        }
        for(int i=0;i<helper.length;i++){
            if(helper[i]>0) helper[i]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while(right<s.length()){
            char key = s.charAt(right);
            if(helper[key]>=2){
                helper[key]--;
                count++;
                right++;
            }else if(helper[key]==1){
                for(int i=left;i<right;i++){
                    helper[s.charAt(i)]++;
                }
                right = ++left;
                count = 0;
            }else{
                right++;
                continue;
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
        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(new MinimumWindowSubstring76().minWindow("ADOBECODEBANC","ABC"));
    }
}
