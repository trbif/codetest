package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	backTrack(result,new ArrayList<Integer>(),0,nums);
    	return result;
    }
    
    private void backTrack(List<List<Integer>> result,List<Integer> current,int start,int[] nums){
    	result.add(new ArrayList<Integer>(current));
    	for(int i=start;i<nums.length;i++){
    		current.add(nums[i]);
    		backTrack(result,current,i+1,nums);
    		current.remove(current.size()-1);
    	}
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4};
		System.out.println(new Subsets78().subsets(nums));
	}
}
