package cn.code.lc;

import cn.code.tools.TreeNode;

public class PathSumIII437 {

    public int pathSum(TreeNode root, int sum) {
        return pathSumHelper(root,sum);
    }
	
    private int pathSumHelper(TreeNode root, int sum) {
        if(root==null){
        	return 0;
        }
        if((sum-root.val)==0){
        	return pathSumHelper(root.left,sum-root.val)+pathSumHelper(root.right,sum-root.val)+1;
        }else{
        	return pathSumHelper(root.left,sum-root.val)+pathSumHelper(root.right,sum-root.val)+0;
        }
    }
}
