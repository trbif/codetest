/**
 * 
 */
package cn.code.lc;

import cn.code.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangqi
 * @date 2018年3月22日 下午3:03:33
 * @version V1.0
 * @说明:
 */
public class BinaryTreePaths257 {

	Stack<Integer> stack = new Stack<Integer>();
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> result = new ArrayList<String>();
    	pre(root,result);
    	return result;
    }
    
    private void pre(TreeNode root,List<String> result){
    	if(root==null){
    		return;
    	}
    	stack.push(root.val);
    	pre(root.left,result);
    	pre(root.right,result);
    	if(root.left==null&&root.right==null){
    		StringBuilder str = new StringBuilder();
    		for(Integer integer:stack){
    			str.append(integer+"->");
    		}
    		if(str.length()>2){
    			str.delete(str.length()-2, str.length());
    		}
    		result.add(str.toString());
    	}
		if(!stack.isEmpty()){
			stack.pop();
		}
    }
}
