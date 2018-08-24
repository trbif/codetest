package cn.code.lc;

public class PermutationinString567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] helper = new int[256];
        for(char ch:s1.toCharArray()){
            helper[ch]++;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        while(right<s2.length()){
            int key = s2.charAt(right);
            if(helper[key]>0){
                helper[key]--;
                count++;
                right++;
            }else{
                for(int i=left;i<right;i++){
                    helper[s2.charAt(i)]++;
                }
                right = ++left;
                count = 0;
            }
            if(count==s1.length()){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(new PermutationinString567().checkInclusion("ab","eidb3aooo"));
    }
}
