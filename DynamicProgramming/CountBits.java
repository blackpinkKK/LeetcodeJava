/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */

package LeetcodeJava.DynamicProgramming;

import java.util.Arrays;

public class CountBits {
    public static void main(String[] args) {
        int num = 1;
        CountBits obj = new CountBits();
        int[] solution = obj.countBits(num);
        System.out.println(Arrays.toString(solution));
    }

    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0]=0;
        if(num==0) return ans;

        for(int i=1;i<=num;i++){
//            ans[i]=ans[i/2]+i%2;
            ans[i]=ans[i&i-1]+1;
        }

        return  ans;
    }
}
