package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	int[] nums = new int[n];
    	for(int i=0;i<nums.length;i++){
    		nums[i] = i+1;
    	}
    	backTrack(result,new ArrayList<Integer>(),0,nums,k);
    	return result;
    }
    
    private void backTrack(List<List<Integer>> result,List<Integer> current,int start,int[] nums,int k){
    	if(current.size()==k){
    		result.add(new ArrayList<Integer>(current));
    		return;
    	}
    	for(int i=start;i<nums.length;i++){
    		if(current.size()!=0&&current.get(current.size()-1)>=nums[i]) continue;
        	current.add(nums[i]);
    		backTrack(result,current,i+1,nums,k);
        	current.remove(current.size()-1);
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new Combinations77().combine(5, 3));
	}
}
