/**
 * 152. 乘积最大子数组
 */

package LeetcodeJava.DynamicProgramming;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        //二维dp
//        int[] dpMax = new int[n];
//        int[] dpMin = new int[n];
//        dpMax[0] = dpMin[0] = nums[0];
//        int max=nums[0];
//        for(int i = 1; i < n; i++){
//            dpMax[i] = Math.max(nums[i],Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]));
//            dpMin[i] = Math.min(nums[i],Math.min(dpMin[i-1]*nums[i],dpMax[i-1]*nums[i]));
//            max=Math.max(max,dpMax[i]);
//        }

        //备忘录dp
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for(int i = 1; i < n; i++){
            int dpMaxLast = dpMax;
            dpMax = Math.max(nums[i],Math.max(dpMax*nums[i],dpMin*nums[i]));
            dpMin= Math.min(nums[i],Math.min(dpMin*nums[i],dpMaxLast*nums[i]));
            max = Math.max(max,dpMax);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,-2,4};
        int[] nums = new int[]{-4,-3,-2};
//        int[] nums = new int[]{-2,0,-1};
        MaxProduct obj = new MaxProduct();
        System.out.println(obj.maxProduct(nums));
    }
}
