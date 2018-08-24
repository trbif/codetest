package cn.code.lc;

import cn.code.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers129 {

    public int sumNumbers(TreeNode root) {
        helperNewNew(root,0);
        return total;
    }
    
    private void helper(TreeNode root,List<List<Integer>> result,List<Integer> current){
    	if(root==null){
    		return;
    	}
    	current.add(root.val);
    	if(root.left==null&&root.right==null){
    		result.add(new ArrayList<Integer>(current));
    	}
    	helper(root.left,result,current);
    	helper(root.right,result,current);
    	current.remove(current.size()-1);
    }
    
    private int helperNew(TreeNode root){
    	if(root.left==null&&root.right==null){
			return 10*root.val;
		}
    	if(root.left==null){
    		return 10*root.val+helperNew(root.right);
    	}
    	if(root.right==null){
    		return 10*root.val+helperNew(root.left);
    	}
    	return 10*root.val+helperNew(root.left)+helperNew(root.right);
    }
    
    private int total = 0;
    private void helperNewNew(TreeNode root,int sum){
        if(root==null){
        	return;
        }
        sum = 10*sum+root.val;
        if(root.left==null&&root.right==null){
        	total += sum;
        }
        helperNewNew(root.left,sum);
        helperNewNew(root.right,sum);
        sum = (sum-root.val)/10;
    }
}
