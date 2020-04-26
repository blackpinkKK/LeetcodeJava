/**
 * 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
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
