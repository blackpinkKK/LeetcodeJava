/**
 * 441. 排列硬币
 */

package LeetcodeJava.Num;

public class ArangeCoins {
    public static void main(String[] args) {
        ArangeCoins obj = new ArangeCoins();
        System.out.println(obj.arrangeCoins(6));
    }

    public int arrangeCoins(int n) {
//        //数学公式法
//        double x = Math.sqrt((n - 0.375) * 2) - 0.5;
//        //double x =Math.sqrt( 2*n -0.75)-0.5; 这个写法会导致 整型溢出
//        int x_ceil = (int) Math.ceil(x);
//        if ((x_ceil + 1) * x_ceil <= 2 * n) return x_ceil;
//        else return x_ceil - 1;

        //二分法
        if(n==0) return 0;
        if(n<3) return 1;
        if(n==3) return 2;
        long begin = 0, end = n/2+1;
        while (begin < end) {
            long mid = (int) (begin + end) / 2;
            if (mid * (mid + 1) / 2 == n) {
                return (int)mid;
            } else if (mid * (mid + 1) / 2 < n) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)begin - 1;
    }
}
