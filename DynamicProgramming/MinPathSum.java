/**
 * 64. 最小路径和
 * 每次只能向下或者向右移动一步。
 */

package LeetcodeJava.DynamicProgramming;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
//        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] nums = {{1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}};
//        int[][] nums = {{-51,-35,74},{-62,14,-53},{94,61,-10}};
        MinPathSum obj = new MinPathSum();
        System.out.println(obj.minPathSum(nums));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 0) {
                        dp[j] = grid[0][j] + dp[j - 1];
                    }
                    continue;
                }
                //i>0
                if (j == 0) {
                    dp[0] += grid[i][0];
                } else {
                    dp[j] = grid[i][j] + Math.min(dp[j-1], dp[j]);
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[n - 1];
    }
}
