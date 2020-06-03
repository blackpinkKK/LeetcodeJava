/**
 * 983. 最低票价
 */

package LeetcodeJava.DynamicProgramming;

public class MincostTickets {
    public static void main(String[] args) {
//        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
//        int[] costs = {2,7,15};
//        int[] days = {1,4,6,7,8,20};
//        int[] costs = {2,7,15};
//        int[] days = {1,4,6,7,8,20};
//        int[] costs = {7,2,15};
        int[] days = {2,3,4,6,8,12,14,18,19,26,27,28};
        int[] costs = {2,9,31};
        MincostTickets obj = new MincostTickets();
        int solution = obj.mincostTickets(days,costs);
        System.out.println(solution);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];
        if(maxDay==1){
            return minInThree(costs[0],costs[1],costs[2]);
        }
        int[] dp = new int[maxDay+1];

        dp[days[0]] = minInThree(costs[0],costs[1],costs[2]);

        int daysIndex = 1;
        for(int i =days[0]+1;i<dp.length;i++){
            while(i!=days[daysIndex]){
                dp[i]=dp[i-1];
                ++i;
            }
            ++daysIndex;
//            --i;
            if(i<7){
                dp[i]=minInThree(dp[i-1]+costs[0],costs[1],costs[2]);
            }else if (i<30){
                dp[i] = dp[i]=minInThree(dp[i-1]+costs[0],dp[i-7]+costs[1],costs[2]);
            }else{
                dp[i] = dp[i]=minInThree(dp[i-1]+costs[0],dp[i-7]+costs[1],dp[i-30]+costs[2]);
            }
//            System.out.println(i+"："+dp[i]);
        }
        return dp[maxDay];
    }

    int minInThree(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
