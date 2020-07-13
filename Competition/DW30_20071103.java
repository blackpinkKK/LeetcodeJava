/**
 * 双周赛30-2020-07-11 第3题 1509. 三次操作后最大值与最小值的最小差
 */

package LeetcodeJava.Competition;

import java.util.Arrays;

public class DW30_20071103 {
    public static void main(String[] args) {
//        int[] nums = {5, 3, 2, 4};
//        int[] nums = {1,5,0,10,14};
//        int[] nums = {6,6,0,1,1,4,6};
        int[] nums = {1,5,6,14,15};
        DW30_20071103 obj = new DW30_20071103();
        System.out.println(obj.minDifference(nums));
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if(nums.length <= 4 ) return 0;

        Arrays.sort(nums);
        //从前三个和后三个中任意去除3个数
        int ans = nums[n-1] - nums[0];
        for (int i = 1; i < 5; i++) {
            ans = Math.min(ans,nums[n-i] - nums[4-i]);
        }
        return ans;
    }
}
