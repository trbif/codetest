/**
 * 
 */
package cn.code.lc;


import cn.code.tools.TreeNode;

/**
 * @author zhangqi
 * @date 2018年3月14日 上午10:04:54
 * @version V1.0
 * @说明:
 */
public class BalancedBinaryTree110 {
	
    public boolean isBalanced(TreeNode root) {
    	if(root==null)
    		return true;
        return helper(root.left,root.right,0,0);
    }
    
    private boolean helper(TreeNode left,TreeNode right,int depthLeft,int depthRight){
        if(Math.abs(depthLeft-depthRight)>1)
        	return false;
        if(left!=null&&right!=null){
	        return helper(left.left,left.right,depthLeft+1,depthRight+1)&&
	        helper(right.left,right.right,depthLeft+1,depthRight+1)&&
	        helper(left.left,right.right,depthLeft+1,depthRight+1)&&
	        helper(right.left,right.left,depthLeft+1,depthRight+1);
        }else if(left!=null&&right==null){
	        return helper(left.left,null,depthLeft+1,depthRight)&&
	        helper(left.right,null,depthLeft+1,depthRight);
        }else if(left==null&&right!=null){
	        return helper(null,right.right,depthLeft,depthRight+1)&&
	        helper(null,right.left,depthLeft,depthRight+1);
        }
        return true;
    }
    
    private int depth(TreeNode node){
    	if(node==null){
    		return 0;
    	}
    	return Math.max(depth(node.left), depth(node.right))+1;
    }
    
    private boolean helperNew(TreeNode left,TreeNode right,int depthLeft,int depthRight){
        if(Math.abs(depthLeft-depthRight)>1)
        	return false;
        if(left!=null&&right!=null){
	        return helper(left.left,left.right,depthLeft+1,depthRight+1)&&
	        helper(right.left,right.right,depthLeft+1,depthRight+1)&&
	        helper(left.left,right.right,depthLeft+1,depthRight+1)&&
	        helper(right.left,right.left,depthLeft+1,depthRight+1);
        }else if(left!=null&&right==null){
	        return helper(left.left,null,depthLeft+1,depthRight)&&
	        helper(left.right,null,depthLeft+1,depthRight);
        }else if(left==null&&right!=null){
	        return helper(null,right.right,depthLeft,depthRight+1)&&
	        helper(null,right.left,depthLeft,depthRight+1);
        }
        return true;
    }
    
    public static void main(String[] args) {
//    	int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
    	int[] preorder = {1,2,3,4,5,5,4,3,4,4,2,3,4,4,3};
		int[] inorder = {3,2};
		TreeNode tree = new ConstructBinaryTreefromPreorderandInorderTraversal105().buildTree(preorder, inorder);
		System.out.println(new BalancedBinaryTree110().isBalanced(tree));
	}
}
