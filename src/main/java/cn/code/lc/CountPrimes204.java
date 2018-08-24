/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午1:47:32
 * @version V1.0
 * @说明:
 */
public class CountPrimes204 {

    public int countPrimes(int n) {
    	int result = 0;
        for(int i=1;i<n;i++){
        	if(isPrime(i)){
        		result++;
        	}
        }
        return result;
    }
    
    private boolean isPrime(int num){
    	if(num==1)
    		return false ;  
        //两个较小数另外处理  
    	if(num==2||num==3)
    		return true ;  
        //不在6的倍数两侧的一定不是质数  
        if(num%6!=1&&num%6!=5)
        	return false ;  
        int tmp = (int)Math.sqrt(num);  
        //在6的倍数两侧的也可能不是质数  
        for(int i=5;i<=tmp;i+=6){
        	if(num %i==0||num %(i+2)==0){
                return false ;  
        	}
        }
        //排除所有，剩余的是质数  
        return true ;  
    }
    
    public static void main(String[] args) {
		System.out.println(new CountPrimes204().countPrimes(1));
	}
}
