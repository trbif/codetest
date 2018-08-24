/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年2月28日 上午8:35:08
 * @version V1.0
 * @说明:
 */
public class PathSum112 {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
        	return false;
        if(root.left==null&&root.right==null&&(sum-root.val)==0)
        	return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    
    public static void main(String[] args) {
		
	}

}
