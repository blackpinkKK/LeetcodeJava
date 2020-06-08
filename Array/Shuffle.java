/***
 * 1470. 重新排列数组
 */

package LeetcodeJava.Array;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
//        int n = 3;
        int[] nums = new int[]{1,1,2,2};
        int n = 2;
        Shuffle obj = new Shuffle();
        int[] solution = obj.shuffle(nums, n);
        System.out.println(Arrays.toString(solution));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i += 1) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
