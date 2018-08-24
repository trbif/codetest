/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月13日 下午5:06:51
 * @version V1.0
 * @说明:
 */
public class PascalsTriangleII119 {

    public List<Integer> getRow(int rowIndex) {
    	int numRows = rowIndex+1;
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> current = new ArrayList<>();
    	for(int i=0;i<numRows;i++){
    		current.add(0,1);
    		for(int j=1;j<current.size()-1;j++){
    			current.set(j, current.get(j)+current.get(j+1));
    		}
    		result.add(new ArrayList<>(current));
    	}
    	return result.get(rowIndex);
    }
    
    public static void main(String[] args) {
		System.out.println(new PascalsTriangleII119().getRow(3));
	}
    
    
}
