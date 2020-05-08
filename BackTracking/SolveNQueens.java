/**
 * 51. N皇后
 */

package LeetcodeJava.BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {

    public static void main(String[] args) {
        int n = 1;
        SolveNQueens obj = new SolveNQueens();
        List<List<String>> solution = obj.solveNQueens(n);
        for(List<String> s:solution){
            System.out.println(s);
        }
//        System.out.println(solution);
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

    void backTracking(int i, int n, String[] base, boolean[][] mark, List<String> curr, List<List<String>> ans) {
        if (i == n) {
            ans.add(new ArrayList<>(curr));//Correct
            return;
        }
        for (int j = 0; j < n; j++) {
            if (check(mark, i, j)) {
                //标记当前位置为已用
                mark[i][j] = true;
                curr.add(base[j]);
                backTracking(i + 1, n, base, mark, curr, ans);
                curr.remove(i);
                //标记当前位置为可用
                mark[i][j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //构造n个基本String如对于 n=4， base[1]=".Q..";
        String[] base = new String[n];
        char[] charArray = new char[n];
        for (int i = 0; i < n; i++) {
            charArray[i] = '.';
        }
        for (int i = 0; i < n; i++) {
            charArray[i] = 'Q';
            base[i] = (String.valueOf(charArray));
            charArray[i] = '.';
        }
        //mark 表用来记录哪些位置已经放置了 Queen
        boolean[][] mark = new boolean[n][n];
//        mark[0][0] = true;
//        mark[1][2] = true;
//        System.out.println(check(mark,3,0));
        backTracking(0, n, base,mark,new ArrayList<>(), ans);

        return ans;

    }
}
