package cn.code.lc;

public class UglyNumber263 {

    private int[] uglies = {2,3,5};
    public boolean isUgly(int num) {
        if(num==0) return false;
        for(int index=0;index<uglies.length;index++){
            while(num%uglies[index]==0){
                num /= uglies[index];
            }
        }
        return num==1;
    }

    public static void main(String[] args){
        System.out.println(new UglyNumber263().isUgly(0));
    }
}
