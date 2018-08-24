package cn.code.lc;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int index=0;index<nums.length;index++){
            int cuplicateIndex = -1;
            for(int i=index;i<nums.length;i++){
            	if(!set.add(nums[i])){
            		cuplicateIndex = i;
            		break;
            	}
            }
            for(int i=index;i<cuplicateIndex;i++){
            	if(nums[i]==nums[cuplicateIndex]){
            		if((cuplicateIndex-i)<=k){
            			return true;
            		}
            		cuplicateIndex = i;
            		break;
            	}
            }
            if(cuplicateIndex==-1) break;
            index = cuplicateIndex;
            set.clear();
        }
        return false;
    }
    
    public boolean containsNearbyDuplicateNew(int[] nums,int k){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
        	if(i>k){
        		set.remove(nums[i-k-1]);
        	}
        	if(!set.add(nums[i])){
        		return true;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,0,1,1};
		System.out.println(new ContainsDuplicateII219().containsNearbyDuplicateNew(nums, 1));
	}
}
