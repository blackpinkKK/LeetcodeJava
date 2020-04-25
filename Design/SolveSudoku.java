/**
 * 37.解数独
 * */

package LeetcodeJava.Design;

import java.lang.reflect.Array;
import java.util.*;

public class SolveSudoku {

    boolean solved;
    int n = 3;
    int N = n * n;
    int[][] grids = new int[N][N];
    int[][] rows = new int[N][N];
    int[][] columns = new int[N][N];

    int[][] intBoard = new int[N][N];

    public boolean shouldPlace(int row, int column, int num){
        try {
            return rows[row][num - 1] + columns[column][num - 1] + grids[row / n * n + column / n][num - 1] == 0;

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("%d, %d, %d\n",row,column,num);
            return false;
        }
    }

    public void placeNum(int row, int column, int num){
        intBoard[row][column] = num;
//        System.out.println("Try "+intBoard[row][column]);
        rows[row][num-1]++;
        columns[column][num-1]++;
        grids[row/n*n+column/n][num-1]++;
    }

    public void removeNum(int row, int column, int num){
        intBoard[row][column] = 0;
        rows[row][num-1]--;
        columns[column][num-1]--;
        grids[row/n*n+column/n][num-1]--;
    }

    public void backTrace(int row, int column){
//        System.out.printf("With [%d, %d] : %d\n",row,column,intBoard[row][column]);
        while(intBoard[row][column] != 0) {
            if (N - 1 != column) {
                column++;
            } else if (N - 1 != row) {
                row++;
                column = 0;
            } else {
                //假如全都填满
                if(N-1 == row && N-1 == column){
                    solved = true;
                    return;
                }
            }
        }

        for(int i=1; i<N+1;i++){
//            if(intBoard[row][column] != 0){
            if(shouldPlace(row,column,i)){
                placeNum(row,column,i);
                if(N-1 == row && N-1 == column){
                    solved =true;
                }
//                System.out.printf("Place [%d, %d] : %d\n",row,column,i);
//                System.out.println(Arrays.toString(rows[0]));
                backTrace(row,column);
                if(!solved){
                    removeNum(row,column,i);
//                    System.out.println("Not solved!");
                }

            }
        }

    }

    public void solveSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    intBoard[i][j]= board[i][j]-'0';
                    rows[i][board[i][j]-1-'0']++;
                    columns[j][board[i][j]-1-'0']++;
                    grids[i/n*n+j/n][board[i][j]-1-'0']++;
                }
            }
        }

        backTrace(0,0);

//        for(int[] b:intBoard){
//            System.out.println(Arrays.toString(b));
//        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                     board[i][j] = (char) (intBoard[i][j]+'0');
                }
            }
        }

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

        SolveSudoku s = new SolveSudoku();
        s.solveSudoku(board);
        for(char[] boardRow:board){
            System.out.println(Arrays.toString(boardRow));
        }

    }
}
