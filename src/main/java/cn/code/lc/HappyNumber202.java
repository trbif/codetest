/**
 * 
 */
package cn.code.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangqi
 * @date 2018年3月22日 上午11:06:54
 * @version V1.0
 * @说明:
 */
public class HappyNumber202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
    	int tmp = n;
        while(set.add(tmp)){
        	int sum = 0;
        	while(tmp!=0){
        		sum += Math.pow(tmp%10, 2);
        		tmp /= 10;
        	}
        	if(sum==1){
        		return true;
        	}
        	tmp = sum;
        }
        return false;
    }
    
    public static void main(String[] args) {
		System.out.println(new HappyNumber202().isHappy(19));
	}
}
