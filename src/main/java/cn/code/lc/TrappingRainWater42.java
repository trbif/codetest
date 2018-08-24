/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年2月22日 下午3:06:26
 * @version V1.0
 * @说明:
 */
public class TrappingRainWater42 {
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater42().trap(height));
	}
	
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
            	if(height[left] >= left_max){
            		left_max = height[left];
            	}else{
            		ans += (left_max - height[left]);
            	}
                ++left;
            }
            else {
            	if(height[right] >= right_max){
            		right_max = height[right];
            	}else{
            		ans += (right_max - height[right]);
            	}
                --right;
            }
        }
        return ans;
    }
}
