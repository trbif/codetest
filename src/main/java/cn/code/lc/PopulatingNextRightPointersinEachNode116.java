/**
 * 
 */
package cn.code.lc;

import cn.code.tools.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangqi
 * @date 2018年3月14日 上午10:42:32
 * @version V1.0
 * @说明:
 */
public class PopulatingNextRightPointersinEachNode116 {
	
    public void connect(TreeLinkNode root) {
    	BFS(root);
    }
    
    private void BFS(TreeLinkNode root) {
    	Queue<TreeLinkNode> queue = new LinkedList<>();
    	queue.offer(root);
    	int depth = 1;
    	for(int i=2;!queue.isEmpty();i++){
    		TreeLinkNode first = queue.poll();
    		if(first.left!=null){
    			queue.offer(first.left);
    		}
    		if(first.right!=null){
    			queue.offer(first.right);
    		}
    		if((int)Math.pow(2, depth)==i){
    			depth++;
    			first.next = null;
    		}else if(!queue.isEmpty()){
    			first.next = queue.element();
    		}
    	}
    }

    
    public void preShow(TreeLinkNode node){
    	if(node==null){
    		return;
    	}
    	if(node.next==null){
        	System.out.println(node.val+"~null");
    	}else{
        	System.out.println(node.val+"~"+node.next.val);
    	}
    	preShow(node.left);
    	preShow(node.right);
    }
    
    public static void main(String[] args) {
    	int[] preorder = {1,2,4,5,3,6,7};
		int[] inorder = {4,2,5,1,6,3,7};
		TreeLinkNode tree = new ConstructBinaryTreefromPreorderandInorderTraversal105().buildLinkedTree(preorder, inorder);
		PopulatingNextRightPointersinEachNode116 test= new PopulatingNextRightPointersinEachNode116();
		test.connect(tree);
		test.preShow(tree);
	}
}
