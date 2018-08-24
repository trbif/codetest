/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018��3��13�� ����3:42:47
 * @version V1.0
 * @˵��:
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
    	if(m==0||n==0)
    		return 0;
        int[][] result = new int[m][n];
        for(int i=0;i<m;i++){
        	result[i][0] = 1;
        }
        for(int i=0;i<n;i++){
        	result[0][i] = 1;
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		result[i][j] = result[i-1][j]+result[i][j-1];
        	}
        }
        return result[m-1][n-1];
    }
    
    public static void main(String[] args) {
		System.out.println(new UniquePaths62().uniquePaths(3, 7));
	}
}