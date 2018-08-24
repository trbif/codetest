package cn.code.lc;

public class PowerofTwo231 {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n%2!=0) return false;
        if(n<=0) return false;
        int tmp = (int)Math.sqrt(n);
        if(tmp*tmp==n){
            return isPowerOfTwo(tmp);
        }else{
            return isPowerOfTwo(n/2);
        }
    }
    public boolean isPowerOfTwoNew(int n) {
        return n>0&&Integer.bitCount(n)==1;
    }
    public boolean isPowerOfTwoNewNew(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }


    public static void main(String[] args){
        System.out.println(new PowerofTwo231().isPowerOfTwo(0));
    }
}
