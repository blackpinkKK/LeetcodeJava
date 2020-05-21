/**
 * 1403. 非递增顺序的最小子序列
 */

package LeetcodeJava.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
    public static void main(String[] args) {
//        int[] nums = {4,4,7,6,7};
        int[] nums = {6};
//        int[] nums = {4,3,10,9,8};
        MinSubsequence obj = new MinSubsequence();
        List<Integer> solution = obj.minSubsequence(nums);
        System.out.println(solution);
    }

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ans  = new ArrayList<>();
        if (nums==null || nums.length==0) return ans;

        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int subSeqSum = 0;
        for(int i=nums.length-1;i>=0;i--){
            subSeqSum+=nums[i];
            ans.add(nums[i]);
            if(subSeqSum>(sum/2)){
                break;
            }
        }
        return ans;
    }

}
