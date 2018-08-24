package cn.code.lc;

import cn.code.tools.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    
    private TreeNode build(int postEnd,int inStart,int inEnd,int[] inorder, int[] postorder){
    	if(postEnd<0||inStart>inEnd){
    		return null;
    	}
    	TreeNode node = new TreeNode(postorder[postEnd]);
    	int index = 0;
    	for(int i=0;i<inorder.length;i++){
    		if(postorder[postEnd]==inorder[i]){
    			index = i;
    		}
    	}
    	node.left = build(postEnd-(inEnd-index+1),inStart,index-1,inorder,postorder);
    	node.right = build(postEnd-1,index+1,inEnd,inorder,postorder);
    	return node;
    }
}
