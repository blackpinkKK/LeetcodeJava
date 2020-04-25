/**
* 36.有效的数独
* */

package LeetcodeJava.Design;

import java.util.Arrays;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int n = 3;
        int N = 9;
        int[][] grids = new int[N][N];
        int[][] rows = new int[N][N];
        int[][] columns = new int[N][N];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(rows[i][board[i][j]-'1']>0){
                        return false;
                    }else rows[i][board[i][j]-'1']++;

                    if(columns[j][board[i][j]-'1']>0){
                        return false;
                    }else columns[j][board[i][j]-'1']++;

                    if(grids[i/n*n+j/n][board[i][j]-'1']>0){
                        return false;
                    }else grids[i/n*n+j/n][board[i][j]-'1']++;
                }
            }
        }

    return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                 {'6','.','.','1','9','5','.','.','.'},
                 {'.','9','8','.','.','.','.','6','.'},
                 {'8','.','.','.','6','.','.','.','3'},
                 {'4','.','.','8','.','3','.','.','1'},
                 {'7','.','.','.','2','.','.','.','6'},
                 {'.','6','.','.','.','.','2','8','.'},
                 {'.','.','.','4','1','9','.','.','5'},
                 {'.','.','.','.','8','.','.','7','9'}};
//        char[][] board = new char[][]
//                {{'.','.','9','7','4','8','.','.','.'},
//                {'7','.','.','.','.','.','.','.','.'},
//                {'.','2','.','1','.','9','.','.','.'},
//                {'.','.','7','.','.','.','2','4','.'},
//                {'.','6','4','.','1','.','5','9','.'},
//                {'.','9','8','.','.','.','3','.','.'},
//                {'.','.','.','8','.','3','.','2','.'},
//                {'.','.','.','.','.','.','.','.','6'},
//                {'.','.','.','2','7','5','9','.','.'}};

        IsValidSudoku s = new IsValidSudoku();
        boolean solution = s.isValidSudoku(board);
        System.out.println(solution);
    }
}
