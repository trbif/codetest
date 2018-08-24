package cn.code.lc;

public class SuperUglyNumber313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglies = new int[n];
        int[] ugliesIndex = new int[primes.length];
        uglies[0] = 1;
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(min>uglies[ugliesIndex[j]]*primes[j]){
                    min = uglies[ugliesIndex[j]]*primes[j];
                }
            }
            for(int j=0;j<primes.length;j++){
                if(min==uglies[ugliesIndex[j]]*primes[j]){
                    ugliesIndex[j]++;
                }
            }
            uglies[i] = min;
        }
        return uglies[n-1];
    }

    public static void main(String[] args){
        for(int i=10;i<=12;i++) {
            System.out.println(new SuperUglyNumber313().nthSuperUglyNumber(i, new int[]{2, 3, 5}));
        }
    }
}
