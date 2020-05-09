/**
 * 52. N皇后 II
 */

package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class TotalNQueens {

    public static void main(String[] args) {
        int n = 5;
        TotalNQueens obj = new TotalNQueens();
        System.out.println(obj.totalNQueens(n));
    }


    boolean check(boolean[][] mark, int i, int j) {
        int x = i, y = j;
        while (x > 0) {
            if (mark[--x][y]) return false;
        }
        x = i;
        //检查左上角对角线
        while (x > 0 && y > 0) {
            if (mark[--x][--y]) return false;
        }
        //检查右上角对角线
        x = i;
        y = j;
        while (x > 0 && y <mark.length-1) {
            if (mark[--x][++y]) return false;
        }

        return true;
    }

    int backTracking(int i, int n, boolean[][] mark) {
        if (i == n) {
            return 1;
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (check(mark, i, j)) {
                //标记当前位置为已用
                mark[i][j] = true;
                count+=backTracking(i + 1, n, mark);
                //标记当前位置为可用
                mark[i][j] = false;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //mark 表用来记录哪些位置已经放置了 Queen
        boolean[][] mark = new boolean[n][n];
        return backTracking(0, n,mark);
    }
}
