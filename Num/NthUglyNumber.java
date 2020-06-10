/**
 * 236.丑数II
 */

package LeetcodeJava.Num;

import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {
    public static void main(String[] args) {
        NthUglyNumber i = new NthUglyNumber();
        int solution = i.nthUglyNumber(11);
        System.out.println(solution);

    }

    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0]=1;
        int p1,p2,p3;
        p1=p2=p3=0;
        for(int i=1;i<nums.length;i++){
            nums[i]=Math.min(Math.min(nums[p1] * 2, nums[p2] * 3),nums[p3] * 5);
            if(nums[i]==nums[p1]*2) p1++;
            if(nums[i]==nums[p2]*3) p2++;
            if(nums[i]==nums[p3]*5) p3++;
        }
        return nums[n-1];
    }

}
