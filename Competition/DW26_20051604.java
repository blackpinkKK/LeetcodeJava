/**
 * 双周赛26-2020-05-16 第4题
 */

package LeetcodeJava.Competition;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DW26_20051604 {
    public static void main(String[] args) {
        int[] cost = new int[]{2, 4, 6, 2, 4, 6, 4, 4, 4};
        int target = 5;
//        [2,4,6,2,4,6,4,4,4]
//        5
        DW26_20051604 obj = new DW26_20051604();
        System.out.println(obj.largestNumber(cost, target));
    }

    public String largestNumber(int[] cost, int target) {
        int[] f = new int[target + 1];
        f[0] = 0;
        for (int i = 1; i <= target; i++) {
            f[i] = -1;
            for (int j = 1; j <= 9; j++) {
                int c = cost[j - 1];
                if (i >= c) {
                    if (f[i - c] == -1 && f[i] == -1) {
                        f[i] = -1;
                    } else {
                        f[i] = Math.max(f[i - c] + 1, f[i]);//判断加入当前数位之后能否使位数比使用其他同cost组合要多
                    }
                }
            }
        }
        System.out.println(Arrays.toString(f));
        if (f[target] < 0) return "0";
        StringBuilder s = new StringBuilder();
        while (target > 0) {
            for (int i = 9; i >= 1; --i) {
                int c = cost[i - 1];
                if (c <= target && f[target] == f[target - c] + 1) {
                    s.append(i);
                    target -= c;
                    break;
                }
            }
        }
        return s.toString();
    }
}
