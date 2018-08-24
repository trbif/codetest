/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年2月23日 上午9:08:52
 * @version V1.0
 * @说明:
 */
public class SameTree100 {
	
	//Definition for a binary tree node.
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		
	}
	
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null&&q==null){
    		return true;
    	}
    	if(p!=null&&q!=null){
    		return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    	}
    	return false;
    }

}
