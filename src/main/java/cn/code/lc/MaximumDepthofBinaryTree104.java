/**
 * 
 */
package cn.code.lc;


/**
 * @author zhangqi
 * @date 2018年3月14日 上午8:10:12
 * @version V1.0
 * @说明:
 */
public class MaximumDepthofBinaryTree104 {

	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

    public int maxDepth(TreeNode root) {
        int[] depth = new int[1];
        depth[0] = 0;
        preDepth(root,depth,1);
        return depth[0];
    }
    
    private void preDepth(TreeNode root,int[] depth,int current){
    	if(root==null){
    		return;
    	}
    	depth[0] = Math.max(depth[0], current);
    	preDepth(root.left,depth,current+1);
    	preDepth(root.right,depth,current+1);
    }
    
    public int maxDepthNew(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
