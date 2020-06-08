/***
 * 1351. 统计有序矩阵中的负数
 */

package LeetcodeJava.Array;

import LeetcodeJava.Num.IsUgly;
import com.sun.javaws.security.AppContextUtil;

public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {4, 3, 2, -1, -2},
                {3, 2, 1, -1, -3},
                {1, 1, -1, -2, -3},
                {-1, -2, -2, -3, -3}};
//        int[][] grid = new int[][]{
//                {5,1,0},
//                {-5,-5,-5}};
//        int[][] grid = new int[][]{
//                {4,3,2,0},
//                {3,2,1,0},
//                {1,1,0,0}};
        CountNegatives obj = new CountNegatives();
        int solution = obj.countNegatives(grid);
        System.out.println(solution);
    }

    public int count(int[][] subGrid, int beginRow, int endRow, int beginColumn, int endColumn) {
        //若首位为负，则全部为负
        if (subGrid[beginRow][beginColumn] < 0) {
            if (beginRow == endRow && beginColumn == endColumn) return 1;
            if (beginRow == endRow) return (endColumn - beginColumn + 1);
            if (beginColumn == endColumn) return (endRow - beginRow + 1);
            return (endRow - beginRow + 1) * (endColumn - beginColumn + 1);
        }
        //若不为负，且只剩一个，必为非负数
        if (beginRow == endRow && beginColumn == endColumn) {
            return 0;
        }

        int row = beginRow;
        int column = beginColumn;
        //沿对角线向右下角查询
        while (subGrid[row][column] >= 0 && row < endRow && column < endColumn) {
            row++;
            column++;
        }
        //查询完整个矩阵且最右下角非负
        if (column == endColumn && row == endRow && subGrid[row][column] >= 0) return 0;
        //查询完列，且右下角非负
        if (column == endColumn && subGrid[row][column] >= 0) {
            return count(subGrid, row + 1, endRow, beginColumn, endColumn);
        }
        //查询完行，且右下角非负
        if (row == endRow && subGrid[row][column] >= 0) {
            return count(subGrid, beginRow, endRow, beginColumn + 1, endColumn);
        }
        //为查询完，剩下不止一行一列，切分成四个小矩阵，计算左下和右上的非负数
        return count(subGrid, row, endRow, beginColumn, column - 1)//左下
                + count(subGrid, beginRow, row - 1, column, endColumn)//右上
                + (endRow - row + 1) * (endColumn - column + 1);//右下全部为负数
    }

    //另一种解法
//    public int countNegatives(int[][] grid) {
//        int col=grid[0].length;
//        int row = grid.length;
//        int ans = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] < 0) {
//                    ans += (col - j) * (row - i);
//                    col = j;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    public int countNegatives(int[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;

        return count(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }
}
