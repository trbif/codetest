/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年2月22日 下午4:28:40
 * @version V1.0
 * @说明:
 */
public class ContainerWithMostWater11 {

	public static void main(String[] args) {
		int[] height = {2,3,1,1,4};
		System.out.println(new ContainerWithMostWater11().maxArea(height));
	}
	
    public int maxArea(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length-1;
        while(start<end){
        	area = Math.max(area, (end-start)*Math.min(height[start], height[end]));
        	if(height[start]<height[end]){
        		start++;
        	}else{
        		end--;
        	}
        }
        return area;
    }
}
