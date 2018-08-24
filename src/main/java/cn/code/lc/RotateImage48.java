/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月21日 下午3:13:01
 * @version V1.0
 * @说明:
 */
public class RotateImage48 {

    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length/2;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		swapIJ(i,j,matrix.length-1-i,j,matrix);
        	}
        }
        for(int i=0;i<matrix.length/2;i++){
        	for(int j=i+1;j<matrix[0].length;j++){
        		swapIJ(i,j,j,i,matrix);
        	}
        }
    }
    
    private void swapIJ(int rowI,int colI,int rowJ,int colJ,int[][] matrix){
    	int tmp = matrix[rowI][colI];
    	matrix[rowI][colI] = matrix[rowJ][colJ];
    	matrix[rowJ][colJ] = tmp;
    }
}
