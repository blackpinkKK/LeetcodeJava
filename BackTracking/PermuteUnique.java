/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */


package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 3};
        PermuteUnique obj = new PermuteUnique();
        System.out.println(obj.permuteUnique(nums));
    }

    //1.递归回溯法
    void backTracking(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans, boolean[] used) {
        if (i == nums.length) {
//            ans.add(curr);//Wrong
            ans.add(new ArrayList<>(curr));//Correct
            return;
        }

        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            if (!set.contains(nums[j])) {
                System.out.printf("%d,%d: %s\n", i, j, curr.toString());
                if (!used[j]) {
                    System.out.printf("Use nums[%d]\n", j);
                    used[j] = true;
                    curr.add(nums[j]);
                    backTracking(i + 1, nums, curr, ans, used);
                    curr.remove(i);
                    used[j] = false;
                    set.add(nums[j]);
                } else {
                    System.out.printf("Nums[%d] is used\n", j);
                }
            } else {
                System.out.printf("Number %d is used\n", nums[j]);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backTracking(0, nums, new ArrayList<>(), ans, used);
        return ans;
    }
}
