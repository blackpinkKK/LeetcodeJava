/**
 * 72. 编辑距离
 */

package LeetcodeJava.DynamicProgramming;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        if(word1.length()==0) return word2.length();
        if(word2.length()==0) return word1.length();

        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1;i++) dp[i][0] = i;
        for (int i = 0; i <= n2;i++) dp[0][i] = i;
        if(word1.charAt(0)==word2.charAt(0)) dp[1][1]=0;
        else dp[1][1]=1;

        int i,j;
        for(i = 1; i <= n1; i++){
            for(j = 1; j <= n2; j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
//                    System.out.println(dp[i-1][j]+" "+dp[i][j-1]+" "+dp[i-1][j-1]);
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
//                    System.out.println("dp["+i+"]["+j+"]:"+dp[i][j]);
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
//        String word1 = "horse", word2 = "ros";
        String word1 = "intention", word2 = "execution";
        MinDistance obj = new MinDistance();
        int solution = obj.minDistance(word1,word2);
        System.out.println(solution);
    }
}
