/**
 * 516. 最长回文子序列
 * dp二维画表
 * */

package LeetcodeJava.DynamicProgramming;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0) return 0;

        int n =s.length();
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[j][j] = 1;
            for(int i = j-1; i>=0;i--){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromeSubseq obj = new LongestPalindromeSubseq();
        int solution = obj.longestPalindromeSubseq(s);
        System.out.println(solution);
    }
}
