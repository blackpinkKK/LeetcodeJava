/**
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 * */

package LeetcodeJava.Array;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //记录频次
        int[] counts = new int[101];
        for(int num:nums) counts[num]++;

        //频次前缀累加
        for(int i = 1; i < counts.length; i++){
            counts[i] = counts[i] + counts[i-1];
        }
        //输出结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++){
            if (nums[i] > 0) res[i] = counts[nums[i]-1];//=0时再取前一项会越界
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,1,2};
         int[] nums = new int[]{1,2,3,4,0,2,6,9};

        SmallerNumbersThanCurrent s = new SmallerNumbersThanCurrent();
        int[] ans = s.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(ans));
    }
}
