/**
 * 
 */
package cn.code.lc;


/**
 * @author zhangqi
 * @date 2018年3月21日 下午4:38:38
 * @version V1.0
 * @说明:
 */
public class PermutationSequence60 {

    public String getPermutation(int n, int k) {
		char[] nums = new char[n];
		for(int i=0;i<n;i++){
			nums[i] = (char) (i+'1');
		}
    	while(k>1){
    		int preIndex = nums.length;
    		for(int i=nums.length-1;i>0;i--){
    			if(nums[i]>nums[i-1]){
    				preIndex = i;
    				break;
    			}
    		}
    		if(preIndex==nums.length){
    			break;
    		}
    		for(int i=nums.length-1;i>=preIndex;i--){
    			if(nums[i]>nums[preIndex-1]){
    	    		swap(i,preIndex-1,nums);
    	    		break;
    			}
    		}
    		for(int i=nums.length-1;i>preIndex;i--){
    			swap(preIndex,i,nums);
    			preIndex++;
    		}
    		k--;
    	}
    	return new String(nums);
    }
    
    private void swap(int i,int j,char[] nums){
    	char tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    public static void main(String[] args) {
		System.out.println(new PermutationSequence60().getPermutation(3, 2));
	}
}
