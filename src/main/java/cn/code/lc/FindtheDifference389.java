package cn.code.lc;

import java.util.Arrays;

public class FindtheDifference389 {
    public char findTheDifference(String s, String t) {
        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();
        Arrays.sort(sA);
        Arrays.sort(tA);
        int index = 0;
        for(char ch:sA){
            if(sA[index]!=tA[index]) break;
            index++;
        }
        return tA[index];
    }

    public static void main(String[] args){
        System.out.println(new FindtheDifference389().findTheDifference("abc","abdc"));
    }
}
