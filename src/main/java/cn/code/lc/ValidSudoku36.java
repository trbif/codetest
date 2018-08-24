/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月21日 上午8:40:54
 * @version V1.0
 * @说明:
 */
public class ValidSudoku36 {

    public boolean isValidSudoku(char[][] board) {
//    	System.err.println("threePlusThreeValid: "+threePlusThreeValid(4,6,board));
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[i].length;j++){
        		System.err.println("threePlusThreeValid: "+threePlusThreeValid(i,j,board));
        		System.err.println("rowValid: "+rowValid(i,j,board));
        		System.err.println("columnValid: "+columnValid(i,j,board));
        		if(threePlusThreeValid(i,j,board)&&rowValid(i,j,board)&&columnValid(i,j,board)){
        			continue;
        		}
        		return false;
        	}
        }
        return true;
    }
    
    private boolean threePlusThreeValid(int i,int j,char[][] board){
//    	System.out.println("row: "+(i/3)*3+"~"+(i/3+1)*3);
//    	System.out.println("col: "+(j/3)*3+"~"+(j/3+1)*3);
    	for(int row=(i/3)*3;row<(i/3+1)*3;row++){
    		for(int col=(j/3)*3;col<(j/3+1)*3;col++){
//				System.out.print(board[row][col]+"#");
    			if(i!=row&&j!=col&&board[row][col]!='.'&&(int)board[row][col]==board[i][j]){
//    				System.out.println("i: "+i+"~j: "+j);
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean rowValid(int i,int j,char[][] board){
    	for(int col=0;col<9;col++){
    		if(j!=col&&board[i][col]!='.'&&(int)board[i][col]==board[i][j]){
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean columnValid(int i,int j,char[][] board){
    	for(int row=0;row<9;row++){
    		if(i!=row&&board[row][j]!='.'&&(int)board[row][j]==board[i][j]){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		char[][] board = {
				{'.','.','5','.','.','.','.','.','6'},
				{'.','.','.','.','1','4','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','9','2','.','.'},
				{'5','.','.','.','.','2','.','.','.'},
				{'.','.','.','.','.','.','.','3','.'},
				{'.','.','.','5','4','.','.','.','.'},
				{'3','.','.','.','.','.','4','2','.'},
				{'.','.','.','2','7','.','6','.','.'}};
		
		System.out.println(new ValidSudoku36().isValidSudoku(board));
	}
}
