/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月14日 下午1:53:12
 * @version V1.0
 * @说明:
 */
public class SingleNumber136 {
	
    public int singleNumber(int[] nums) {
    	if(nums.length==0){
    		return 0;
    	}
    	int xor = nums[0];
        for(int i=1;i<nums.length;i++){
        	xor ^= nums[i];
        }
        return xor;
    }
    
    public static void main(String[] args) {
//    	int[] nums = {1,1,2,3,4,5,6};
    	int[] nums = {1,1,3,3,5,5,7};
		System.out.println(new SingleNumber136().singleNumber(nums));
	}

}
