/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */


package LeetcodeJava.BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    //1.递归回溯法
    void backTracking(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(curr);
            return;
        }
        List<Integer> copy = new ArrayList<>(curr);
        backTracking(i + 1, nums, copy, ans);
        curr.add(nums[i]);
        List<Integer> copy2 = new ArrayList<>(curr);
        backTracking(i + 1, nums, copy2, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(0, nums, new ArrayList<>(), ans);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4};
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(nums));
    }
}
