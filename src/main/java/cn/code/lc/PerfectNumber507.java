/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月16日 上午9:04:21
 * @version V1.0
 * @说明:
 */
public class PerfectNumber507 {

	//Time Limit Exceeded
    public boolean checkPerfectNumber(int num) {
    	int sum = 0;
    	for(int i=(num+1)>>1;i>1;i--){
    		if(num%i==0){
        		System.err.println(num+"~"+i);
    			sum += i;
    		}
    	}
        return sum+1==num;
    }
    
    //Time Limit Exceeded 
    public boolean checkPerfectNumberNew(int num) {
    	int sum = 0;
    	int index = 0;
//    	System.err.println((num+1)>>1);
//    	System.err.println(((num+1)>>1)*((num+1)>>1));
    	for(int i=(num+1)>>1;i>Math.sqrt(num);i--){
    		if(num%i==0){
        		System.err.println(num+"~"+i);
    			sum += i+num/i;
    		}
    		index = i;
    	}
        return (index*index==num)?(sum+1+index==num):(sum+1==num);
    }
    

    public boolean checkPerfectNumberNewNew(int num) {
        if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;
        
        return sum == num;
    }
    
    public static void main(String[] args) {
		System.out.println(new PerfectNumber507().checkPerfectNumberNew(28));
	}
}
