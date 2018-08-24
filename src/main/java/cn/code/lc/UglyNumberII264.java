package cn.code.lc;

public class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        int ugly2Index = 0;
        int ugly3Index = 0;
        int ugly5Index = 0;
        uglies[0] = 1;
        for(int i=1;i<n;i++){
            uglies[i] = Math.min(uglies[ugly2Index]*2,Math.min(uglies[ugly3Index]*3,uglies[ugly5Index]*5));
            if(uglies[i]==uglies[ugly2Index]*2){
                ugly2Index++;
            }
            if(uglies[i]==uglies[ugly3Index]*3){
                ugly3Index++;
            }
            if(uglies[i]==uglies[ugly5Index]*5){
                ugly5Index++;
            }
        }
        return uglies[n-1];
    }

    public static void main(String[] args){
        for(int i=1;i<=12;i++){
            System.out.println(new UglyNumberII264().nthUglyNumber(i));
        }
    }
}
