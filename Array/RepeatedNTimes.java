/**
 * 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
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
