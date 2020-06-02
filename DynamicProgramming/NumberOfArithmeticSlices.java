/**
 * 413. 等差数列划分
 */

package LeetcodeJava.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
//        int[] nums = {0,1, 2, 3, 4, 6, 8, 10, 12, 14, 19};
        int[] nums = {0, 1, 2, 3, 4, 6, 8, 10, 12, 14, 19, 22, 25, 28, 29, 30, 31, 32, 32, 32, 32, 32};
        NumberOfArithmeticSlices obj = new NumberOfArithmeticSlices();
        System.out.println(obj.numberOfArithmeticSlices(nums));
    }

//    public int numberOfArithmeticSlices(int[] A) {
//        if (A.length < 3) return 0;
//
//        //计算总共有几个等差数列，每个长度为多少
//        int diff = A[1] - A[0];
//        int currLen = 2;
//        int maxLen = 2;
//        List<Integer> len = new ArrayList<>();
//        for (int i = 2; i < A.length; i++) {
//            if (A[i] - A[i - 1] == diff) {
//                ++currLen;
//            } else {
//                if (currLen > 2) {
//                    len.add(currLen);
//                    if (currLen > maxLen) maxLen = currLen;
//                }
//                currLen = 2;
//                diff = A[i] - A[i - 1];
//            }
//        }
//        if (currLen > 2) {
//            len.add(currLen);
//            if (currLen > maxLen) maxLen = currLen;
//        }
//        //没有等差数列
//        if(maxLen == 2) return 0;
//        //等差数列最长为3个数字，所以每个都只包含一个子数组
//        if(maxLen == 3) return len.size();
//
//        //计算每个长度等差数列对应的子数组个数
//        int[] f = new int[maxLen + 1];
//        f[3] = 1;
//        for (int i = 4; i < f.length; i++) {
//            f[i] = f[i - 1] + i - 2;
//        }
//
//        int ans = 0;
//        for (int l : len) {
//            ans += f[l];
//            System.out.println(f[l]);
//        }
//
//        return ans;
//    }


    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        int dp = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            }else{
                dp=0;
            }
        }

        return sum;
    }
}
