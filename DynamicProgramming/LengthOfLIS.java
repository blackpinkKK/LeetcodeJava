/**
 * 300. 最长上升子序列
 * */

package LeetcodeJava.DynamicProgramming;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0 ) return 0;
        if(nums.length==1) return 1;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] =1;
        for(int i = 1; i<n;i++){
            dp[i] = 1;
            for(int j = 0; j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
//            System.out.println(dp[i]);
        }

        int dp_max = 0;
        for(int d:dp){
            if(d>dp_max) dp_max = d;
        }
        return dp_max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,9,2,5,3,7,27,18,19};
        LengthOfLIS obj = new LengthOfLIS();
        int solution = obj.lengthOfLIS(nums);
        System.out.println(solution);
    }
}
