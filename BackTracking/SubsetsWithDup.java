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

public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 4, 1, 4};
        SubsetsWithDup obj = new SubsetsWithDup();
        System.out.println(obj.subsetsWithDup(nums));
    }

    //1.递归回溯法
    void backTracking(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            //假如在同一位置选取与上一循环（不是上一递归层）同样的值，则continue
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            curr.add(nums[j]);
            backTracking(j + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
