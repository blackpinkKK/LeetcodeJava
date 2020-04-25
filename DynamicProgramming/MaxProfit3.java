/**
 * 123. 买卖股票的最佳时机 III
 * 只能交易 2 次
 * */

package LeetcodeJava.DynamicProgramming;

public class MaxProfit3 {
    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length==0) return  0;
//        int k_max = 2;
//        int n=prices.length;
//        int[][][] dp = new int[n][k_max+1][2];
//        dp[0][1][0] = 0;            //已交易一次，未持有
//        dp[0][1][1] = -prices[0];   //第一次买入
//        dp[0][2][0] = 0;            //已交易二次，未持有
//        dp[0][2][1] = -prices[0];    //第二次买入
//        for (int i=1;i<n;i++) {
//            for (int k=1;k<=k_max;k++){
//                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
//                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
//            }
//        }
//        return dp[n-1][k_max][0];


        if(prices == null || prices.length==0) return  0;
        int dp_10 = 0, dp_20 = 0, dp_11 = -prices[0], dp_21 = -prices[0];
//        int dp_10 = 0, dp_20 = 0, dp_11 = Integer.MIN_VALUE, dp_21 = Integer.MIN_VALUE;

        for(int price:prices){
            dp_10 = Math.max(dp_10,dp_11+price);
            dp_11 = Math.max(dp_11,-price);//dp_00-price = 0-price
            System.out.println(dp_10+","+dp_11);

            dp_20 = Math.max(dp_20,dp_21+price);
            dp_21 = Math.max(dp_21,dp_10-price);
            System.out.println(dp_20+","+dp_21);

        }

        return dp_20;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
//        int[] prices = new int[]{1,2,3,4,5};
        MaxProfit3 obj = new MaxProfit3();
        int solution = obj.maxProfit(prices);
        System.out.println(solution);
    }
}
