/**
 * 31. 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */


package LeetcodeJava.BackTracking;

import java.lang.reflect.Array;
import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;

        //从后向前迭代，找到第一个 nums[i-1]<nums[i] 的i
        int moveIdx = -1;
        for (int i = nums.length - 1; i >= 1; --i) {
            if (nums[i - 1] < nums[i]) {
                moveIdx = i-1;
                break;
            }
        }

        //假如没找到moveIdx，说明整个数组是递减的，下一组是最小的，进行reverse
        if(moveIdx==-1){
            for (int i = 0; i < (nums.length / 2); ++i) {
                swap(nums,nums.length-1-i,i);
            }
            return;
        }

        //假如找到moveIdx，从end往前找直到moveIdx，找到第一个大于nums[moveIdx]的数，互换位置
        //此时从moveIdx之后（不包含moveIdx）到end都是递减
        for(int i = nums.length-1;i>moveIdx;--i){
            if(nums[i]>nums[moveIdx]){
                swap(nums,moveIdx,i);
                break;
            }
        }

        //在moveIdx之后的数列进行reverse
        int reverseIdx = moveIdx+1;
        int len = (nums.length - (reverseIdx));
        for (int i = 0; i < (len / 2); ++i) {
            swap(nums,reverseIdx+i,reverseIdx+len-1-i);
        }
    }

    void swap(int[] nums, int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
