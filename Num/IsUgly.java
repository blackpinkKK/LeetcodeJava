/**
 * 263.丑数
 */

package LeetcodeJava.Num;

public class IsUgly {
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

    public static void main(String[] args) {
        IsUgly i = new IsUgly();
        boolean solution = i.isUgly(6);
        System.out.println(solution);
    }
}
