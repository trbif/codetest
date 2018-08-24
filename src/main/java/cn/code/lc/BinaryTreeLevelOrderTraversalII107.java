/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author zhangqi
 * @date 2018年3月14日 上午8:54:20
 * @version V1.0
 * @说明:
 */
public class BinaryTreeLevelOrderTraversalII107 {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<>();
    	pre(root,0,result);
    	return result;
        
    }
    
    private void pre(TreeNode root,int deep,List<List<Integer>> result){
    	if(root==null){
    		return;
    	}
    	if(result.size()<=deep){
    		result.add(0,new ArrayList<>());
    	}
    	result.get(result.size()-deep-1).add(root.val);
    	pre(root.left,deep+1,result);
    	pre(root.right,deep+1,result);
    }
    
}
