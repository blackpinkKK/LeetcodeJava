/**
 * 191. 位1的个数
 */

package LeetcodeJava.BitOperation;

public class HammingWeight {
    public static void main(String[] args) {
        int num = 32;
        HammingWeight obj = new HammingWeight();
        System.out.println(obj.hammingWeight(num));
    }

    public int hammingWeight(int n) {
        int count =0;
        while(n!=0){
            n=n&n-1;
            count++;
        }
        return  count;
    }
}
