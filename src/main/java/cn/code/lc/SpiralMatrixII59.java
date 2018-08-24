/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午2:17:41
 * @version V1.0
 * @说明:
 */
public class SpiralMatrixII59 {

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if(n<=0){
			return matrix;
		}
    	
    	int rowB = 0;
    	int rowE = matrix.length-1;
    	int clomunB = 0;
    	int clomunE = matrix[0].length-1;
    	
    	int index = 0;
    	
    	while(rowB<=rowE&&clomunB<=clomunE){
    		boolean rowFlag = false;
    		boolean clomunFlag = false;
    		for(int i=clomunB;i<=clomunE;i++){
    			System.err.println(rowB+"!"+i);
    			matrix[rowB][i] = ++index;
    		}
    		rowB++;
    		for(int i=rowB;i<=rowE;i++){
    			System.err.println(clomunE+"!!"+i);
    			matrix[i][clomunE] = ++index;
    			rowFlag = true;
    		}
    		clomunE--;
    		for(int i=clomunE;i>=clomunB&&rowFlag;i--){
    			System.err.println(rowE+"!!!"+i);
    			matrix[rowE][i] = ++index;
    			clomunFlag = true;
    		}
    		rowE--;
    		for(int i=rowE;i>=rowB&&clomunFlag;i--){
    			System.err.println(clomunB+"!!!!"+i);
    			matrix[i][clomunB] = ++index;
    		}
    		clomunB++;
    	}
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[i].length;j++){
    			System.out.print(matrix[i][j]);
    		}
    	}
    	return matrix;
    }

	public static void main(String[] args) {
		new SpiralMatrixII59().generateMatrix(2);
	}

}
