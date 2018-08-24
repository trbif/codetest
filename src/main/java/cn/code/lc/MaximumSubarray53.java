/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月13日 下午2:33:20
 * @version V1.0
 * @说明:
 */
public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
        	System.out.println("maxEndingHere: "+maxEndingHere);
        	System.out.println("nums["+i+"]: "+nums[i]);
        	System.out.println("maxSoFar: "+maxSoFar);
        	maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
        	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
        	System.out.println("maxSoFar&maxEndingHere: "+maxSoFar+"~"+maxEndingHere);
        }
        return maxSoFar;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new MaximumSubarray53().maxSubArray(nums));
	}
}
