/**
 * 双周赛24-2020-04-18 第2题 1414. 和为 K 的最少斐波那契数字数目
 */

package LeetcodeJava.Competition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DW24_20041802 {

    public int findMinFibonacciNumbers(int k) {
        long[] t = new long[50];
        int i=2;
        t[0]=t[1]=1;
        while((t[i]=t[i-1]+t[i-2])<=k) ++i;
//        System.out.println(Arrays.toString(t));
        int c=0;
        while(k!=0)
        {
            if(k>=t[i]){
                k-=t[i];
                ++c;
            }
            --i;
        }
        return c;
    }

    public static void main(String[] args) {
        DW24_20041802 cls = new DW24_20041802();
        int solution = cls.findMinFibonacciNumbers(19);
        System.out.println(solution);
    }
}
