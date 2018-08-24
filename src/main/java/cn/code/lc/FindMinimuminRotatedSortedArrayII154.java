/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月22日 上午9:00:10
 * @version V1.0
 * @说明:
 */
public class FindMinimuminRotatedSortedArrayII154 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
        	int mid = (left+right)>>1;
        	if(nums[mid]>=nums[mid+1]){
        		return nums[mid+1];
        	}
        	if(mid>0&&nums[mid]<=nums[mid-1]){
        		return nums[mid];
        	}
        	if(nums[mid+1]<=nums[0]){
        		right = mid-1;
        	}else{
        		left = mid+1;
        	}
        }
        return nums[0];
    }
    
    public static void main(String[] args) {
		int[] nums = {10,1,10,10,10};
		System.out.println(new FindMinimuminRotatedSortedArrayII154().findMin(nums));
	}
}
