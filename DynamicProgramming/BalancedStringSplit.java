/**
 * 1221. 分割平衡字符串
 * 输入是平衡字符串，分割出的每个子字符串都必须是平衡字符串
 * */

package LeetcodeJava.DynamicProgramming;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int L,R,count;
        L=R=count=0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='L') L++;
            else R++;
            if(L==R && R!=0){
//                System.out.println("L==R:"+L+","+R);
                count++;
                L=R=0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "LLLLRRRR";
//        int[] nums = new int[]{};
        BalancedStringSplit obj = new BalancedStringSplit();
        int solution = obj.balancedStringSplit(s);
        System.out.println(solution);
    }
}
