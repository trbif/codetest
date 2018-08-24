/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月21日 上午10:09:47
 * @version V1.0
 * @说明:
 */
public class Permutations46 {

    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
    	while(true){
    		List<Integer> curList = new ArrayList<Integer>();
    		for(int i=0;i<nums.length;i++){
    			curList.add(nums[i]);
    			System.out.print(nums[i]);
    		}
    		System.out.println();
    		result.add(curList);
    		int preIndex = nums.length;
//    		int curIndex = nums.length-1;
    		for(int i=nums.length-1;i>0;i--){
    			if(nums[i]>nums[i-1]){
    				preIndex = i;
    				break;
    			}
    		}
    		if(preIndex==nums.length)
    			break;
    		for(int i=nums.length-1;i>=preIndex;i--){
    			if(nums[i]>nums[preIndex-1]){
//    				curIndex = i;
    	    		swap(i,preIndex-1,nums);
    	    		break;
    			}
    		}
    		for(int i=nums.length-1;i>preIndex;i--){
    			swap(preIndex,i,nums);
    			preIndex++;
    		}
    	}
    	return result;
    }
    
    private void swap(int i,int j,int[] nums){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,1,2};
		System.out.println(new Permutations46().permute(nums));
	}
}
