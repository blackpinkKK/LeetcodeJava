/**
 * 373. 查找和最小的K对数字
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class KSmallestPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7, 11}, nums2 = {2, 4, 6};
//        int[] nums2 = {1, 2, 7, 11}, nums1 = {2, 4, 6};
        int k = 3;
//        int[] nums1 = {1, 1, 2}, nums2 = {};
//        int k = 2;
        KSmallestPairs obj = new KSmallestPairs();
        List<List<Integer>> solution = obj.kSmallestPairs(nums1, nums2, k);
        System.out.println(solution);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return ans;
        boolean isSwap = false;
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 =tmp;
            isSwap = true;
        }

        int[] finalNums1 = nums1;
        int[] finalNums2 = nums2;
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> (finalNums1[o[0]] + finalNums2[o[1]])));
        for (int i = 0; i < nums1.length; i++) heap.offer(new int[]{i, 0});

        while (ans.size() < k) {
            int[] tmp = heap.poll();
            if (tmp == null) {
                break;
            } else {
                if (isSwap) {
                    ans.add(new ArrayList<Integer>() {{
                        add(finalNums2[tmp[1]]);
                        add(finalNums1[tmp[0]]);
                    }});
                } else {
                    ans.add(new ArrayList<Integer>() {{
                        add(finalNums1[tmp[0]]);
                        add(finalNums2[tmp[1]]);
                    }});
                }
                if (tmp[1] + 1 < nums2.length)
                    heap.offer(new int[]{tmp[0], (tmp[1] + 1)});
            }
        }
        return ans;
    }
}
