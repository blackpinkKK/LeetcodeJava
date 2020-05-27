/**
 * 169.多数元素
 *  给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * */

package LeetcodeJava.Array;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int candidate = nums[0];
        int votes = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i] == candidate) votes++;
            else {
                votes--;
                if (votes == 0){
                    candidate = nums[i];
                    votes = 1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,1,2};
         int[] nums = new int[]{1,7,1,2,1,2,1,1,2,1};

        MajorityElement solution = new MajorityElement();
        int ans = solution.majorityElement(nums);
        System.out.println(ans);
    }
}
