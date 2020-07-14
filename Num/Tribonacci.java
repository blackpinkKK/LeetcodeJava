/**
 * 1137. 第 N 个泰波那契数
 */

package LeetcodeJava.Num;

public class Tribonacci {
    public static void main(String[] args) {
        int n = 25;
        Tribonacci obj = new Tribonacci();
        System.out.println(obj.tribonacci(n));
    }

    public int tribonacci(int n) {
        if(n==0) return 0;
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i < n + 1; i++) {
            int tmp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tmp;
        }

        return t2;
    }
}
