package cn.code.lc;

public class PowerofFour342 {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        int tmp = (int)Math.sqrt(n);
        if(tmp*tmp==n){
            return Integer.bitCount(tmp)==1;
        }
        return false;
    }
}
