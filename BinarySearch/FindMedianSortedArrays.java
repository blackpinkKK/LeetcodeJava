/**
 * 4. 寻找两个正序数组的中位数
 */

package LeetcodeJava.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMedianSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
//        int[] nums1 = {4, 5, 9}, nums2 = {4, 4, 8, 9, 9};
        int[] nums1 = {1,2,3,4}, nums2 = {5};
        FindMedianSortedArrays obj = new FindMedianSortedArrays();
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int begin = 0;
        int end = m;
        int k = (m + n + 1) / 2;

        int mid1, mid2;
        while (begin < end) {
            mid1 = (begin + end) / 2;
            mid2 = k - 1 - mid1;
            if (nums1[mid1] > nums2[mid2]) {
                System.out.println(nums1[mid1] + ">=" + nums2[mid2]);
                end = mid1;
            } else {
                System.out.println(nums1[mid1] + "<=" + nums2[mid2]);
                begin = mid1 + 1;
            }
        }
        int m1 = begin, m2 = k - m1;
        System.out.println("m1:" + m1+ ", m2:"+m2);
        System.out.println(m1 + " , " + m2);
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);

        if ((m + n) % 2 == 1) {
            return c1;
        }
        int c2 = Math.min( m1 >= m ? Integer.MAX_VALUE :nums1[m1],
                m2 >= n ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }

}
