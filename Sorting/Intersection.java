/**
 * 349. 两个数组的交集
 */

package LeetcodeJava.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        Intersection obj = new Intersection();
        int[] solution = obj.intersection(nums1, nums2);
//        System.out.println(solution);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        boolean same = false;
        int i = 0, j = 0;
        if (nums1[i] == nums2[j]) {
            list.add(nums1[i]);
            same = true;
            i++;
            j++;
        } else {
            if (nums1[i] > nums2[j]) j++;
            else i++;
        }

        while (i < nums1.length && j < nums2.length) {
            if (same) {
                if (nums1[i] == nums1[i - 1]) i++;
                else if (nums2[j] == nums2[j - 1]) j++;
                else same = false;
            } else {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    same = true;
                    i++;
                    j++;
                } else {
                    if (nums1[i] > nums2[j]) j++;
                    else i++;
                    same = false;
                }
            }
        }
        int[] ans = new int[list.size()];
        for (i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        System.out.println(list);
        return ans;
    }

}
