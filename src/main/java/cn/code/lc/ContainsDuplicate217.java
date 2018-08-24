/**
 * 
 */
package cn.code.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangqi
 * @date 2018��3��22�� ����2:22:44
 * @version V1.0
 * @˵��:
 */
public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!set.add(nums[i])){
        		return true;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {};
		System.out.println(new ContainsDuplicate217().containsDuplicate(nums));
	}
}
