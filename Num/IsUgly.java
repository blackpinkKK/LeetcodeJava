/**
 * 263.丑数
 */

package LeetcodeJava.Num;

public class IsUgly {
    public static void main(String[] args) {
        IsUgly obj = new IsUgly();
        boolean solution = obj.isUgly(6);
        System.out.println(solution);
    }

    public boolean isUgly(int num) {
        if(num==0) return false;
        for(int factor:new int[]{2,3,5}){
            while(num%factor == 0){
                num /= factor;
//                System.out.println(num);
            }
        }
        return num==1;
    }
}
