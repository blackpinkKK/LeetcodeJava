/**
 * 740. 删除与获得点数
 * nums最大长度为20000，整数大小在[1,10000]
 * */

package LeetcodeJava.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        //解法1，二维数组dp
        //优化的话可以不适用排序，而是使用数组存放对应数字的个数，因为每个整数的大小都在[1,10000]排序其实可以
//        Arrays.sort(nums);
//        int[][] dp = new int[n+1][2];
//        dp[1][0] = 0;
//        dp[1][1] = nums[0];
//        for(int i=2;i<n+1;i++){
//            //同一个数只能取全部或者全不取
//            if(nums[i-1]==nums[i-2]){
//                dp[i][0] = dp[i-1][0];
//                dp[i][1] = dp[i-1][1] + nums[i-1];
//            }
//            if(nums[i-1]-nums[i-2]==1){
//                //相邻两数若只差1，则保存取与不取的前i-1项dp
//                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
//                dp[i][1] = dp[i-1][0]+nums[i-1];
//            }
//            if(nums[i-1]-nums[i-2]>1){
//                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
//                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1])+nums[i-1];
//            }
//
//        }
//        return Math.max(dp[n][0],dp[n][1]);

        //解法二
        int max =nums[0];
        for(int num:nums) max=Math.max(max,num);
        int[] newNums = new int[max+1];
        for(int num:nums) newNums[num]++;

        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = newNums[1];
        for(int i=2;i<max+1;i++){
            dp[i] = Math.max(dp[i-2]+ i * newNums[i],dp[i-1]);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2, 2, 2, 3, 3, 3, 4 };
//        int[] nums = new int[]{};
        DeleteAndEarn d = new DeleteAndEarn();
        int solution = d.deleteAndEarn(nums);
        System.out.println(solution);
    }
}
