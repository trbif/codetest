/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月22日 上午8:43:09
 * @version V1.0
 * @说明:
 */
public class MaximumProductSubarray152 {

	//题意理解错误
    public int maxProduct(int[] nums) {
    	if(nums.length==1){
    		return nums[0];
    	}
    	int max = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(nums[i]*nums[i-1]>max){
        		max = Math.max(nums[i], nums[i]*nums[i-1]);
        	}else{
        		max = Math.max(nums[i], max);
        	}
        }
        return max;
    }
    
    public int maxProductNew(int[] nums) {
    	if(nums.length==1){
    		return nums[0];
    	}
    	int max = nums[0];
        for(int i=1;i<nums.length;i++){
        	if(nums[i]*nums[i-1]>max){
        		max = Math.max(nums[i], nums[i]*nums[i-1]);
        	}else{
        		max = Math.max(nums[i], max);
        	}
        }
        return max;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,3,-4};
		System.out.println(new MaximumProductSubarray152().maxProduct(nums));
	}
}
