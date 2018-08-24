/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年2月22日 下午1:50:41
 * @version V1.0
 * @说明:
 */
public class NextPermutation31 {
	
	public static void main(String[] args) {
        int[] array=new int[]{3,2,1}; 
        new NextPermutation31().nextPermutation(array);
	}
	
    public void nextPermutation(int[] nums) {
    	int index1 = -1;
    	int index2 = -1;
        for(int i=nums.length-2;i>=0;i--){
        	if(nums[i]<nums[i+1]){
        		index1 = i;
        		break;
        	}
        }
        if(index1!=-1){
            for(int i=nums.length-1;i>=0;i--){
            	if(nums[i]>nums[index1]){
            		index2 = i;
            		break;
            	}
            }
        	swap(nums,index1,index2);
        }
        int k = nums.length-1;
        for(int i=index1+1;i<k;i++){
            swap(nums,i,k);
            k--;
        }
        for(int i=0;i<nums.length;i++){
        	System.out.print(nums[i]);
        }
    }
    
    private void swap(int[] arr,int i,int j){
    	int tmp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = tmp;
    }
}
