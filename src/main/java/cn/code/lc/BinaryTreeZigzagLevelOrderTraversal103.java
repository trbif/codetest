/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月13日 下午1:49:34
 * @version V1.0
 * @说明:
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	pre(root,0,result);
    	return result;
    }
    
    private void pre(TreeNode root,int deep,List<List<Integer>> result){
    	if(root==null){
    		return;
    	}
    	if(result.size()<=deep){
    		result.add(new LinkedList<>());
    	}
    	if(deep%2==0){
        	result.get(deep).add(root.val);
    	}else{
        	result.get(deep).add(0,root.val);
    	}
    	pre(root.left,deep+1,result);
    	pre(root.right,deep+1,result);
    }
}
