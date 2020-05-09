/**
 * 78. 子集
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集
 */


package LeetcodeJava.BackTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4};
        Subsets obj = new Subsets();
        System.out.println(obj.subsets(nums));
    }

    //1.递归回溯法
    void backTracking(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        //(1)
//        if (i == nums.length) {
//            ans.add(new ArrayList<>(curr));
//
//        backTracking(i + 1, nums, curr, ans);
//        curr.add(nums[i]);
//        backTracking(i + 1, nums, curr, ans);
//        curr.remove(curr.size()-1);

        //(2)
        ans.add(new ArrayList<>(curr));
        for(int j=i;j<nums.length;j++){
            curr.add(nums[j]);
            backTracking(j + 1, nums, curr, ans);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
