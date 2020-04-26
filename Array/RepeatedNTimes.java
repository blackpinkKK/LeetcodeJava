/**
 * 169.多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * */

package LeetcodeJava.Array;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        //记录频次
//        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
////        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
////
////        for(int k:map.keySet()){
////            if (map.get(k)>1) return k;
////        }
////
////        throw null;

        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int num:nums) {
            if (map.getOrDefault(num,0) != 0) return num;
            map.put(num,map.getOrDefault(num,0)+1);
        }

        throw null;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,1,2};
         int[] nums = new int[]{2,7,3,2,0,2,2,1};

        RepeatedNTimes r = new RepeatedNTimes();
        int ans = r.repeatedNTimes(nums);
        System.out.println(ans);
    }
}
