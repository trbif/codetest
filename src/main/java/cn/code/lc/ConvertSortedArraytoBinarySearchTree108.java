/**
 * 
 */
package cn.code.lc;


import cn.code.tools.TreeNode;

/**
 * @author zhangqi
 * @date 2018年3月14日 上午9:12:24
 * @version V1.0
 * @说明:
 */
public class ConvertSortedArraytoBinarySearchTree108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0,nums.length-1,nums);
    }
    
    private TreeNode build(int start, int end, int[] nums){
    	if(end<start){
    		return null;
    	}
    	int mid = start + (end-start)/2;//防止int溢出
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = build(start,mid-1,nums);
    	node.right = build(mid+1,end,nums);
    	return node;
    }
    
    public void preShow(TreeNode node){
    	System.out.println(node.val);
    	preShow(node.left);
    	preShow(node.right);
    }
    
    public static void main(String[] args) {
    	int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode tree = new ConstructBinaryTreefromPreorderandInorderTraversal105().buildTree(preorder, inorder);
		ConvertSortedArraytoBinarySearchTree108 test = new ConvertSortedArraytoBinarySearchTree108();
//		test.preShow(test.so);
	}
}
