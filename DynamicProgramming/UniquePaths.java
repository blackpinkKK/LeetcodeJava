/**
 * 62. 不同路径
 * 从 m x n 网格的左上角 开始，每次向下或者向右移动一步，最后到达右下角。
 * 所有路径数
 **/

package LeetcodeJava.DynamicProgramming;

public class UniquePaths {
    public static void main(String[] args) {
//        int m = 3, n = 2;
        int m = 51, n = 9;
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(m, n));
    }

    //动态规划
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) return 1;
//
//        int[] dp = new int[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i==0){
//                    dp[j]=1;
//                    continue;
//                }
//                if(j>0){
//                    dp[j] = dp[j - 1] + dp[j];
//                }
//            }
//        }
//        return dp[n-1];
//    }

    //排列组合
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        // (m+n-2) 取(m-1) = (m+n-2)!/(m-1)
        if (m > n) return uniquePaths(n, m);
        long ans = 1;
        for (int i = m + n - 2; i > n - 1; i--) {
            ans *= i;
            ans /= (m + n - 2 - i + 1);
        }
        return (int)ans;
    }
}
