/**
 * 
 */
package cn.code.lc;

/**
 * @author zhangqi
 * @date 2018年3月21日 上午9:20:14
 * @version V1.0
 * @说明:
 */
public class SudokuSolver37 {

    public void solveSudoku(char[][] board) {
		System.out.println(solve(board));
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
            		board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
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
		
		char[][] boardE = {
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		
		char[][] boardH = {
				{'8','.','.','.','.','.','.','.','.'},
				{'.','.','3','6','.','.','.','.','.'},
				{'.','7','.','.','9','.','2','.','.'},
				{'.','5','.','.','.','7','.','.','.'},
				{'.','.','.','.','4','5','7','.','.'},
				{'.','.','.','1','.','.','.','3','.'},
				{'.','.','1','.','.','.','.','6','8'},
				{'.','.','8','5','.','.','.','1','.'},
				{'.','9','.','.','.','.','4','.','.'}};
		
		new SudokuSolver37().solveSudoku(boardH);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				System.out.print(boardH[i][j]+",");
			}
			System.out.println();
		}
	}
}
