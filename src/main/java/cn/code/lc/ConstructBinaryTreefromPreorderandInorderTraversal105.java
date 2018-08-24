/**
 * 
 */
package cn.code.lc;

import cn.code.tools.TreeLinkNode;
import cn.code.tools.TreeNode;

/**
 * @author zhangqi
 * @date 2018年3月14日 上午8:36:28
 * @version V1.0
 * @说明:
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	return build(0,0,inorder.length-1,preorder,inorder);
    }
    
    private TreeNode build(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
    	if(preStart>preorder.length-1||inEnd<inStart){
    		return null;
    	}
    	TreeNode node = new TreeNode(preorder[preStart]);
    	int index = 0;
    	for(int i=inStart;i<=inEnd;i++){//i<=inEnd =
    		if(preorder[preStart]==inorder[i]){
    			index = i;
    		}
    	}
    	node.left = build(preStart+1,inStart,index-1,preorder,inorder);
    	node.right = build(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
    	return node;
    }

    public TreeLinkNode buildLinkedTree(int[] preorder, int[] inorder) {
    	return buildLinked(0,0,inorder.length-1,preorder,inorder);
    }
    
    private TreeLinkNode buildLinked(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
    	if(preStart>preorder.length-1||inEnd<inStart){
    		return null;
    	}
    	TreeLinkNode node = new TreeLinkNode(preorder[preStart]);
    	int index = 0;
    	for(int i=inStart;i<=inEnd;i++){//i<=inEnd =
    		if(preorder[preStart]==inorder[i]){
    			index = i;
    		}
    	}
    	node.left = buildLinked(preStart+1,inStart,index-1,preorder,inorder);
    	node.right = buildLinked(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
    	return node;
    }
}
