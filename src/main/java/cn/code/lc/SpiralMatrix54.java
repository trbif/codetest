/**
 * 
 */
package cn.code.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午2:17:41
 * @version V1.0
 * @说明:
 */
public class SpiralMatrix54 {

	public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<>();
    	
    	if (matrix.length == 0){
    		return result;
    	}
    	
    	int rowB = 0;
    	int rowE = matrix.length-1;
    	int clomunB = 0;
    	int clomunE = matrix[0].length-1;
    	
    	while(rowB<=rowE&&clomunB<=clomunE){
    		boolean rowFlag = false;
    		boolean clomunFlag = false;
    		for(int i=clomunB;i<=clomunE;i++){
    			System.err.println(rowB+"!"+i);
    			result.add(matrix[rowB][i]);
    		}
    		rowB++;
    		for(int i=rowB;i<=rowE;i++){
    			System.err.println(clomunE+"!!"+i);
    			result.add(matrix[i][clomunE]);
    			rowFlag = true;
    		}
    		clomunE--;
    		for(int i=clomunE;i>=clomunB&&rowFlag;i--){
    			System.err.println(rowE+"!!!"+i);
    			result.add(matrix[rowE][i]);
    			clomunFlag = true;
    		}
    		rowE--;
    		for(int i=rowE;i>=rowB&&clomunFlag;i--){
    			System.err.println(clomunB+"!!!!"+i);
    			result.add(matrix[i][clomunB]);
    		}
    		clomunB++;
    	}
    	return result;
    }

	public static void main(String[] args) {
		 int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = { { 1, 2 } };
		System.out.println(new SpiralMatrix54().spiralOrder(matrix));
	}

}
