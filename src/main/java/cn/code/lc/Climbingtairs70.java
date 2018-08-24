/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午3:10:23
 * @version V1.0
 * @说明:
 */
public class Climbingtairs70 {

//	Time Limit Exceeded 
    public int climbStairs(int n) {
    	if(n==1){
    		return 1;
    	}
    	if(n==2){
    		return 2;
    	}
        return climbStairs(n-1)+climbStairs(n-2);
    }
    
    public int climbStairsNew(int n){
        // base cases
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for(int i=2; i<n; i++){
        	all_ways = one_step_before + two_steps_before;
        	two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
    
    public int climbStairsNewNew(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
    	int[] result = new int[n+1];
        
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        
        for(int i=3; i<=n; i++){
        	result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
    
    public static void main(String[] args) {
		System.out.println(new Climbingtairs70().climbStairsNewNew(44));
	}
}
