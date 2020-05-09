/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */


package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permute obj = new Permute();
        System.out.println(obj.permute(nums));
    }

    //1.递归回溯法
    void backTracking(int i, int[] nums, List<Integer> curr, List<List<Integer>> ans,boolean[] used) {
        if (i == nums.length) {
//            ans.add(curr);//Wrong
            ans.add(new ArrayList<>(curr));//Correct
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!used[j]){
                used[j] = true;
                curr.add(nums[j]);
                backTracking(i + 1, nums, curr, ans,used);
                curr.remove(i);
                used[j] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backTracking(0, nums, new ArrayList<>(), ans, used);
        return ans;
    }
}
