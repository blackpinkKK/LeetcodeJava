/**
 * 188. 买卖股票的最佳时机 IV
 * 可以交易 k 次
 * */

package LeetcodeJava.DynamicProgramming;

public class MaxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length==0) return  0;
        int n=prices.length;
        //判断 k 是否足够大，足够的话相当于无穷
        if (k > n / 2){
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int temp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
                dp_i_1 = Math.max(dp_i_1, temp - price);
            }
            return dp_i_0;
        }

        int[][][] dp = new int[n][k+1][2];

        for (int i=0;i<n;i++) {
            for (int ki=1;ki<=k;ki++){
                if(i==0){
                    dp[i][ki][0]=0;
                    dp[i][ki][1]=-prices[0];
                    continue;
                }
                dp[i][ki][0]=Math.max(dp[i-1][ki][0],dp[i-1][ki][1]+prices[i]);
                dp[i][ki][1]=Math.max(dp[i-1][ki][1],dp[i-1][ki-1][0]-prices[i]);
            }
        }
        return dp[n-1][k][0];

    }

    public static void main(String[] args) {
        int[] prices = new int[]{2,4,1};
//        int[] prices = new int[]{3,2,6,5,0,3};
//        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int k=2;
        MaxProfit4 obj = new MaxProfit4();
        int solution = obj.maxProfit(k,prices);
        System.out.println(solution);
    }
}
