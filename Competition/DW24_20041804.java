/**
 * 双周赛24-2020-04-18 第4题 5375. 恢复数组
 */

package LeetcodeJava.Competition;

import com.sun.media.jfxmediaimpl.HostUtils;

public class DW24_20041804 {
    public int numberOfArrays(String s, int k) {
        //dp
        int n = s.length();
        int[] dp =new int[n+1];
        dp[0] = 1;
        int mod = 1000000007;

        for(int i = 0; i< n;++i) {
            if (s.charAt(i) != '0') {
                long u = 0;
                for(int j = i; j<n; ++j){
                    u=10*u+s.charAt(j)-'0';
                    if(u>k) break;
                    dp[j+1]+=dp[i];
                    dp[j+1]%=mod;
                }
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        String s = "1234567890";
        int k = 90;
        DW24_20041804 cls = new DW24_20041804();
        int solution = cls.numberOfArrays(s,k);
        System.out.println(solution);
    }
}
