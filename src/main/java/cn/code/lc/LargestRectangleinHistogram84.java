/**
 * 
 */
package cn.code.lc;

import java.util.Stack;

/**
 * @author zhangqi
 * @date 2018年3月19日 上午10:23:36
 * @version V1.0
 * @说明:
 */
public class LargestRectangleinHistogram84 {

    public int largestRectangleArea(int[] heights) {
    	int left = 0;
    	int right = heights.length-1;
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean flag = true;
    	int before = Integer.MAX_VALUE;
    	int periodLength = heights.length;
    	while(left<=right){
        	if(flag){
        		if(before<heights[left]){
        			stack.pop();
        		}
        	}else{
        		if(before<heights[right]){
        			stack.pop();
        		}
        	}
        	stack.push(Math.min(heights[left], heights[right])*(right-left+1));
        	if(flag){
        		before = heights[right];
        		right--;
        		flag = false;
        	}else{
        		before = heights[left];
        		left++;
        		flag = true;
        	}
    	}
        return stack.pop();
    }
    
    public static void main(String[] args) {
    	int[] heights = {2,1,5,1,2,3};
		System.out.println(new LargestRectangleinHistogram84().largestRectangleArea(heights));
	}
}
