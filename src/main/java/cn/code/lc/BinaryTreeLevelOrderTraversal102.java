/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018��3��13�� ����1:49:34
 * @version V1.0
 * @˵��:
 */
public class BinaryTreeLevelOrderTraversal102 {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<>();
    	pre(root,0,result);
    	return result;
    }
    
    private void pre(TreeNode root,int deep,List<List<Integer>> result){
    	if(root==null){
    		return;
    	}
    	if(result.size()<=deep){
    		result.add(new ArrayList<>());
    	}
    	result.get(deep).add(root.val);
    	pre(root.left,deep+1,result);
    	pre(root.right,deep+1,result);
    }
}
