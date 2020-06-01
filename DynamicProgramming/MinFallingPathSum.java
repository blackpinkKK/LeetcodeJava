/**
 * 931. 下降路径最小和
 */

package LeetcodeJava.DynamicProgramming;

import java.util.Arrays;

public class MinFallingPathSum {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] nums = {{-80,-13,22},{83,94,-5},{73,-48,61}};
//        int[][] nums = {{-51,-35,74},{-62,14,-53},{94,61,-10}};
        MinFallingPathSum obj = new MinFallingPathSum();
        System.out.println(obj.minFallingPathSum(nums));
    }

    public int minFallingPathSum(int[][] A) {
        int columnNum = A[0].length;
        int ans = 0;
        if(columnNum==1){
            for(int[] a:A){
                ans+=a[0];
            }
            return ans;
        }

        int[] dp = Arrays.copyOf(A[0],A[0].length);
        int dpLast = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (j == 0) {
                    dpLast =dp[j];
                    dp[j] = A[i][j] + Math.min(dp[j],dp[j+1]);
                } else if (j == columnNum - 1) {
                    dp[j] = A[i][j] + Math.min(dpLast, dp[j]);
                } else {
                    int tmp = dp[j];
                    dp[j] = A[i][j] + Math.min(dpLast, Math.min(dp[j],dp[j + 1]));
                    dpLast = tmp;
                }
                if (i == A.length - 1) {
                    if(j==0){
                        ans = dp[j];
                    }else{
                        ans = Math.min(ans, dp[j]);
                    }
                }
            }
        }

        return ans;
    }
}
