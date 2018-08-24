/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月12日 下午3:54:54
 * @version V1.0
 * @说明:
 */
public class Searcha2DMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
    	System.err.println(matrix[0].length);
    	if(matrix.length==0||matrix[0].length==0){
    		return false;
    	}
    	int begin = 0;
    	int end = matrix.length-1;
    	while(begin<=end){
    		int index =  (end+begin)/2;
			System.out.println(begin+"~"+end+"~"+index);
    		if(begin==end){
    			System.out.println(begin+"#"+end);
    			if(matrix[begin][0]>target){
    				begin = index-1;
    			}
    			break;
    		}
    		if(matrix[index][0]>target){
    			System.err.println(begin+"%"+end+"%"+index);
    			end = index;
    		}else if(matrix[index][0]<target){
    			begin = index+1;
    		}else{
    			return true;
    		}
			System.out.println(begin+"!"+end);
    	}
    	System.err.println(begin);
    	if(begin<0){
    		return false;
    	}
    	int beginRow = 0;
    	int endRow = matrix[0].length-1;
    	while(beginRow<=endRow){
    		int index =  (endRow+beginRow)/2;
    		if(beginRow==endRow&&matrix[begin][index]!=target){
    			return false;
    		}
    		if(matrix[begin][index]>target){
    			endRow = index-1;
    		}else if(matrix[begin][index]<target){
    			beginRow = index+1;
    		}else{
    			return true;
    		}
    	}
    	return false;
    }
    
    
    public boolean searchMatrixNew(int[][] matrix, int target) {
    	if(matrix.length==0||matrix[0].length==0){
    		return false;
    	}
    	int rowLength = matrix.length;
    	int colLength = matrix[0].length;
    	int begin = 0;
    	int end = rowLength*colLength-1;
    	while(begin<=end){
    		int index = (begin+end)/2;
    		if(matrix[index/colLength][index%colLength]<target){
    			begin = index+1;
    		}else if(matrix[index/colLength][index%colLength]>target){
    			end = index;
    		}else{
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
		 int[][] matrix = {{-10,-8},{-6,-5},{-2,-2},{-1,0},{3,4},{7,7},{8,9},{10,10},{11,11},{12,14},{15,16},{17,19},{20,21},{22,22},{25,27},{28,30},{32,32},{35,36}};
		 long startTime = System.currentTimeMillis();
		 System.out.println(new Searcha2DMatrix74().searchMatrixNew(matrix, 28));
		 long endTime = System.currentTimeMillis();
		 System.out.println(endTime-startTime);
	}
    
    
}
