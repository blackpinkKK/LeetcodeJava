/**
 * 双周赛30-2020-07-11 第2题 1508. 子数组和排序后的区间和
 */

package LeetcodeJava.Competition;

import java.util.ArrayList;
import java.util.List;

public class DW30_20071102 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4, left = 1, right = 10;
        DW30_20071102 obj = new DW30_20071102();
        System.out.println(obj.rangeSum(nums, n, left, right));
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
        sums.sort((o1, o2) -> o1 - o2);

        int ans = 0;
        int mod = 1000000007;
        for (int i = left - 1; i < right; i++) {
            ans += sums.get(i);
            if (ans > mod) {
                ans -= mod;
            }
        }

        return ans;
    }
}
