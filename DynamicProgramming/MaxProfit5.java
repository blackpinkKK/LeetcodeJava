/**
 * 309. 最佳买卖股票时机含冷冻期
 * */

package LeetcodeJava.DynamicProgramming;

public class MaxProfit5 {
    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length==0 || prices.length==1)
//            return  0;
//        int n=prices.length;
//        int[][] dp = new int[n][2];
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        dp[1][0]=Math.max(dp[0][0],prices[1]-prices[0]);
//        dp[1][1]=Math.max(-prices[0],-prices[1]);
//        for (int i=2;i<n;i++) {
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
//        }
//        return Math.max(0,dp[n-1][0]);

        if(prices == null || prices.length==0 || prices.length==1)
            return  0;
        int n=prices.length;
        int dp_0 = 0, dp_1 = -prices[0];
        int prev=dp_0;

        for (int i=1;i<n;i++) {
            if(i == 1){
                dp_0=Math.max(dp_0,dp_1+prices[i]);
                dp_1=Math.max(dp_1,-prices[i]);
                continue;
            }
            int tmp = dp_0;
            dp_0=Math.max(dp_0,dp_1+prices[i]);
            dp_1=Math.max(dp_1,prev-prices[i]);
            prev = tmp;
        }
        return dp_0;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{1,2,3,0,2};
        int[] prices = new int[]{1,2,0,2,3};
//        int[] prices = new int[]{1,2,4};
//        int[] prices = new int[]{4,2,7,1,11};
        MaxProfit5 obj = new MaxProfit5();
        int solution = obj.maxProfit(prices);
        System.out.println(solution);
    }
}
