/**
 * 
 */
package cn.code.lc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月12日 上午9:33:01
 * @version V1.0
 * @说明:
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new LinkedList<>();
    	for(int i=0;i<nums.length-2;i++){
    		int begin = i+1;
    		int end = nums.length-1;
        	if(i==0||(i>0&&nums[i]!=nums[i-1])){
        		while(begin<end){
        			System.err.println(Arrays.asList(nums[i],nums[begin],nums[end]));
        			if(nums[begin]+nums[end]==0-nums[i]){
        				while(begin<end&&nums[begin]==nums[begin+1]) begin++;
        				while(begin<end&&nums[end]==nums[end-1]) end--;
        				result.add(Arrays.asList(nums[i],nums[begin],nums[end]));
        				begin++;
        				end--;
        			}else if(nums[begin]+nums[end]<0-nums[i]){
        				begin++;
        			}else{
        				end--;
        			}
        		}
        	}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		int[] nums = {-2,0,0,2,2};
		System.out.println(new ThreeSum15().threeSum(nums));
	}
}
