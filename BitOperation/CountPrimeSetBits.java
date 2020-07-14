/**
 * 762. 二进制表示中质数个计算置位
 */

package LeetcodeJava.BitOperation;

public class CountPrimeSetBits {
    public static void main(String[] args) {
//        int L = 6, R = 10;
        int L = 10, R = 15;
        CountPrimeSetBits obj = new CountPrimeSetBits();
        System.out.println(obj.countPrimeSetBits(L, R));
    }

    public int countPrimeSetBits(int L, int R) {
        int ans = 0;

        int[] primes = {0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1};
        for (int i = L; i <= R; i++) {
//            if(primes[Integer.bitCount(i)-1]==1) ans++;
            if(primes[countBit(i)-1]==1) ans++;
//            System.out.println(Integer.bitCount(i));
//            System.out.println(countBit(i));
        }

        return ans;
    }

    public int countBit(int n){
        int count =0;

        while(n>0){
            n= n&(n-1);
            count++;
        }
        return count;
    }
}
