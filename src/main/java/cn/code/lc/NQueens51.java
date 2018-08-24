/**
 * 
 */
package cn.code.lc;

import java.util.*;

/**
 * @author zhangqi
 * @date 2018年3月19日 下午1:53:12
 * @version V1.0
 * @说明:
 */
public class NQueens51 {

	Set<Integer> column = new HashSet<>();
	Set<Integer> diagLeft = new HashSet<>();
	Set<Integer> diagRight = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<>();
    	queens(result,new ArrayList<>(),0,n);
    	return result;
    }

	//Time Limit Exceeded
    private void queens(List<List<String>> result,List<String> current,int deep,int n){
    	if(deep==n){
    		result.add(new ArrayList<>(current));
    		return;
    	}
    	
    	for(int i=0;i<n;i++){
    		if(column.contains(i)||diagRight.contains(deep+i)||diagLeft.contains(deep-i)){
    			continue;
    		}
    		column.add(i);
    		diagRight.add(deep+i);
    		diagLeft.add(deep-i);
        	char[] row = new char[n];
        	Arrays.fill(row, '.');
        	row[i] = 'Q';
        	current.add(new String(row));
        	queens(result,current,deep+1,n);
        	current.remove(current.size()-1);
        	column.remove(i);
        	diagRight.remove(deep+i);
        	diagLeft.remove(deep-i);
    	}
    }
    

    public List<List<String>> solveNQueensNew(int n) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	queensNew(result,new ArrayList<String>(),0,n);
    	return result;
    }
    
    private void queensNew(List<List<String>> result,List<String> current,int deep,int n){
    	if(deep==n){
    		result.add(new ArrayList<String>(current));
    		return;
    	}
    	
    	for(int i=0;i<n;i++){
    		if(column.contains(i)||diagRight.contains(deep+i)||diagLeft.contains(deep-i)){
    			continue;
    		}
    		column.add(i);
    		diagRight.add(deep+i);
    		diagLeft.add(deep-i);
        	char[] row = new char[n];
        	Arrays.fill(row, '.');
        	row[i] = 'Q';
        	current.add(new String(row));
        	queensNew(result,current,deep+1,n);
        	current.remove(current.size()-1);
        	column.remove(i);
        	diagRight.remove(deep+i);
        	diagLeft.remove(deep-i);
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new NQueens51().solveNQueensNew(9));
	}
}
