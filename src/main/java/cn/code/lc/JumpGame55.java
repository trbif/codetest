/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018��3��13�� ����8:57:17
 * @version V1.0
 * @˵��:
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
    	int pos = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
        	if(nums[i]>=pos-i){
        		pos = i;
        	}
        }
        return pos==0;
    }
    
    
    public static void main(String[] args) {
    	int[] nums = {1,0,1,1,9};
		System.out.println(new JumpGame55().canJump(nums));
	}
    
}
