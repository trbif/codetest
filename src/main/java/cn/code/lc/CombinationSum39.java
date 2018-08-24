package cn.code.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	recursive(result,new ArrayList<Integer>(),candidates,target,0,0);
    	return result;
    }
    
    private void recursive(List<List<Integer>> result,List<Integer> current,int[] candidates,int target,int sum,int deep){
    	if(sum==target){
    		result.add(new ArrayList<Integer>(current));
    	}else if(sum>target){
    		return;
    	}else{
        	for(int i=deep;i<candidates.length;i++){
        		if(i > deep && candidates[i] == candidates[i-1]) continue;
        		current.add(candidates[i]);
        		sum += candidates[i];
            	recursive(result,current,candidates,target,sum,i+1);//deep加1，不回溯自己
            	sum -= current.get(current.size()-1);
            	current.remove(current.size()-1);
        	}
    	}
    }
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
        
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1); 
            }
        }
    } 
    
    public static void main(String[] args) {
    	int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    	int target = 8;
		System.out.println(new CombinationSum39().combinationSum(candidates, target));
	}
}
