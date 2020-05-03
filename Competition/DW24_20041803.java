/**
 * 双周赛24-2020-04-18 第3题 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

package LeetcodeJava.Competition;

public class DW24_20041803 {

    public String getHappyString(int n, int k){
        int[] po = new int[n+1];
        po[0] = 1;
        for(int i = 1;i <= n; i++) po[i]=po[i-1]*2;
        if(po[n-1]*3<k) return "";//判断一共可以组成多少开心字符串，是否包含第k个

        StringBuilder ans = new StringBuilder(n);
        char last = ' ';
        for(int i=1;i<=n;i++){
            for(char s:new char[]{'a','b','c'}){
                if(s!=last){
                    //从第一个字符之后，每个位置的可能性有两种，判断第k个字符串被哪一种情况包含
                    if(k > po[n-i]) k-=po[n-i];//不在第一种情况

                        //在第一种情况
                    else{
                        ans.append(s);
                        last = s;
                        break;
                    }

                }
            }
        }
        return ans.substring(0);
    }

    public static void main(String[] args) {
        int n=7;
        int k=50;
        DW24_20041803 cls = new DW24_20041803();
        String solution = cls.getHappyString(n,k);
        System.out.println(solution);
    }
}
