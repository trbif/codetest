/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午3:33:32
 * @version V1.0
 * @说明:
 */
public class SetMatrixZeroes73 {

    public void setZeroes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++){
        		if(matrix[i][j]==0){
        			setZ(matrix,i,j);
        		}
        	}
        }

        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++){
        		System.out.print(matrix[i][j]);
        	}
        }
    }
    
    private void setZ(int[][] matrix,int i,int j){
    	System.err.println(i+"~"+j);
    	for(int index=0;index<matrix[i].length;index++){
    		matrix[i][index] = 0;
    	}
    	for(int index=0;index<matrix.length;index++){
    		matrix[index][j] = 0;
    	}
    }
    
    public void setZeroesNew(int[][] matrix) {
	    boolean fr = false,fc = false;
	    for(int i = 0; i < matrix.length; i++) {
	        for(int j = 0; j < matrix[i].length; j++) {
	            if(matrix[i][j] == 0) {
	                if(i == 0) fr = true;
	                if(j == 0) fc = true;
	                matrix[0][j] = 0;
	                matrix[i][0] = 0;
	            }
	        }
	    }
	    for(int i = 1; i < matrix.length; i++) {
	        for(int j = 1; j < matrix[0].length; j++) {
	            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	                matrix[i][j] = 0;
	            }
	        }
	    }
	    if(fr) {
	        for(int j = 0; j < matrix[0].length; j++) {
	            matrix[0][j] = 0;
	        }
	    }
	    if(fc) {
	        for(int i = 0; i < matrix.length; i++) {
	            matrix[i][0] = 0;
	        }
	    }

        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[i].length;j++){
        		System.out.print(matrix[i][j]);
        	}
        }
    }
    
    public static void main(String[] args) {
		 int[][] matrix = {{1,2,3},{0,0,6},{7,8,9}};
		 new SetMatrixZeroes73().setZeroesNew(matrix);
	}
}
