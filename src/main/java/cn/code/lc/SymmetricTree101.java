/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月13日 上午9:14:41
 * @version V1.0
 * @说明:
 */
public class SymmetricTree101 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
        	return true;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        fromLeft(root,left);
        fromRight(root,right);
        return compare(left,right);
    }
    
    private boolean compare(List<Integer> left,List<Integer> right){
    	if(left.size()!=right.size())
    		return false;
    	for(int i=0;i<left.size();i++){
    		if(left.get(i)!=right.get(i))
    			return false;
    	}
    	return true;
    }
    
    private void fromLeft(TreeNode root,List<Integer> left){
    	if(root==null){
        	left.add(null);
    		return;
    	}
    	left.add(root.val);
    	fromLeft(root.left,left);
    	fromLeft(root.right,left);
    }
    
    private void fromRight(TreeNode root,List<Integer> right){
    	if(root==null){
    		right.add(null);
    		return;
    	}
    	right.add(root.val);
    	fromRight(root.right,right);
    	fromRight(root.left,right);
    }
    
}
