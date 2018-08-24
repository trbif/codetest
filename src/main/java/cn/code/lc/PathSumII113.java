/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年2月28日 上午8:35:08
 * @version V1.0
 * @说明:
 */
public class PathSumII113 {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        hasPathSum(root,sum,result,new ArrayList<Integer>());
        return result;
    }
	
    private void hasPathSum(TreeNode root, int sum, List<List<Integer>> result,List<Integer> current) {
        if(root==null){
        	return;
        }
    	current.add(root.val);
        if(root.left==null&&root.right==null&&(sum-root.val)==0){
        	result.add(new ArrayList<Integer>(current));
        }
        hasPathSum(root.left,sum-root.val,result,current);
        hasPathSum(root.right,sum-root.val,result,current);
        current.remove(current.size()-1);
    }
    
    public static void main(String[] args) {
		
	}

}
