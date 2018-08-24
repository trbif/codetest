/**
 * 
 */
package cn.code.lc;

import java.util.Arrays;

/**
 * @author zhangqi
 * @date 2018年3月12日 上午9:56:26
 * @version V1.0
 * @说明:
 */
public class ThreeSumClosest16 {
	
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int result = nums[0]+nums[1]+nums[2];
    	int sum = result;
    	for(int i=0;i<nums.length-2;i++){
    		int begin = i+1;
    		int end = nums.length-1;
        	if(i==0||(i>0&&nums[i]!=nums[i-1])){
        		while(begin<end){
        			System.err.println(Arrays.asList(nums[i],nums[begin],nums[end]));
            		sum = nums[i]+nums[begin]+nums[end];
        			if(sum<target){
        				while(begin<end&&nums[begin]==nums[begin+1]) begin++;
        				begin++;
        			}else if(sum>target){
        				while(begin<end&&nums[end]==nums[end-1]) end--;
        				end--;
        			}else{
        				return target;
        			}
        			if(Math.abs(target-sum)<Math.abs(target-result)){
        				result = sum;
        			}
        		}
        	}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		int[] nums = {-3,0,1,2};
		System.out.println(new ThreeSumClosest16().threeSumClosest(nums,1));
	}

}
