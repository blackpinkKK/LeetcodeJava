/**
 * 313. 超级丑数
 */

package LeetcodeJava.Num;

import java.util.Arrays;

public class NthSuperUglyNumber {
    public static void main(String[] args) {
        NthSuperUglyNumber obj = new NthSuperUglyNumber();
//        int[] primes = {2, 7, 13, 19};
        int[] primes = {2,3,7,13,17,23,31,41,43,47,89};
        int n = 100;
        int solution = obj.nthSuperUglyNumber(n, primes);
        System.out.println(solution);

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] nums = new int[n];
        nums[0] = 1;
        int minNum;
        int[] factors = new int[k];
        for (int i = 1; i < nums.length; i++) {
            minNum=Integer.MAX_VALUE;
            for(int j =0;j<k;j++){
                int tmp =nums[factors[j]]*primes[j];
//                if()
                if(tmp<minNum ){
                    if(tmp>nums[i-1]){
                        minNum = tmp;
                    }
                }
            }
            nums[i] = minNum;
            for(int j = 0;j<k;j++){
                if(nums[factors[j]]*primes[j]==minNum) factors[j]++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[n - 1];
    }

}
