/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月22日 上午9:44:49
 * @version V1.0
 * @说明:
 */
public class SearchinRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left<=right){
        	int mid = (left+right)>>1;
//			System.out.println("mid: "+mid);
//			System.out.println("nums[mid]: "+nums[mid]);
//			System.out.println("target: "+target);
//			System.out.println("nums[0]: "+nums[0]);
            if (nums[mid] == target)
                return mid;
        
            if (nums[left] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[left]) 
                	 right = mid - 1;
                 else
                	 left = mid + 1;
            } 
        
            if (nums[mid] <= nums[right]){
                if (target > nums[mid] && target <= nums[right])
                	left = mid + 1;
                 else
                	 right = mid - 1;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
		int[] nums = {3,4,5,6,7,0,1,2};
		System.out.println(new SearchinRotatedSortedArray33().search(nums,0));
	}

}
