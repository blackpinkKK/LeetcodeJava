/**
 * 121. 买卖股票的最佳时机
 *
 * */

package LeetcodeJava.DynamicProgramming;

import sun.applet.AppletResourceLoader;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0) return  0;
        int low=prices[0];
        int benefit=0;

        for (int price : prices) {
            benefit = Math.max(benefit, price - low);
            low = Math.min(low, price);
//            if(prices[i]<low)low=prices[i];
        }
        benefit=Math.max(0,benefit);
        return benefit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{};
        MaxProfit obj = new MaxProfit();
        int solution = obj.maxProfit(prices);
        System.out.println(solution);
    }
}
