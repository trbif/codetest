/**
 * 
 */
package cn.code.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangqi
 * @date 2018年3月20日 下午4:24:57
 * @version V1.0
 * @说明:
 */
public class NQueensII52 {

	Set<Integer> column = new HashSet<Integer>();
	Set<Integer> diagLeft = new HashSet<Integer>();
	Set<Integer> diagRight = new HashSet<Integer>();
	int totalCount;
    public int totalNQueens(int n) {
    	queens(0,n);
    	return totalCount;
    }
    
    private void queens(int deep,int n){
    	if(deep==n){
    		totalCount++;
    		return;
    	}
    	
    	for(int i=0;i<n;i++){
    		if(column.contains(i)||diagRight.contains(deep+i)||diagLeft.contains(deep-i)){
    			continue;
    		}
    		column.add(i);
    		diagRight.add(deep+i);
    		diagLeft.add(deep-i);
        	queens(deep+1,n);
        	column.remove(i);
        	diagRight.remove(deep+i);
        	diagLeft.remove(deep-i);
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new NQueensII52().totalNQueens(8));
	}
}
