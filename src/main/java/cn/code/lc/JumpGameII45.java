/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018��2��22�� ����3:30:09
 * @version V1.0
 * @˵��:
 */
public class JumpGameII45 {
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new JumpGameII45().jump(nums));
	}
	
    public int jump(int[] nums) {
    	int jumps = 0, curEnd = 0, curFarthest = 0;
    	for (int i = 0; i < nums.length - 1; i++) {
    		curFarthest = Math.max(curFarthest, i + nums[i]);
    		if (i == curEnd) {
    			jumps++;
    			curEnd = curFarthest;
    		}
    	}
    	return jumps;
    }

}
