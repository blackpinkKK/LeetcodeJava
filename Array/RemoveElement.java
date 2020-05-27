/**
 * 27. 移除元素
 *
 * */

package LeetcodeJava.Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index =0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int[] nums = new int[]{3,2,2,3};
//         int[] nums = new int[]{1,7,1,2,1,2,1,1,2,1};

        RemoveElement obj = new RemoveElement();
        int solution = obj.removeElement(nums,3);
        System.out.println(solution);
    }
}
