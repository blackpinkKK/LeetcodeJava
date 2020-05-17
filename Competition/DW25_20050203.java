/**
 * 双周赛25-2020-05-02 第3题 1433. 检查一个字符串是否可以打破另一个字符串
 */

package LeetcodeJava.Competition;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DW25_20050203 {
    public boolean checkIfCanBreak(String s1, String s2) {
//        int n = s1.length();
//        int[] l1,l2;
//        l1 = new int[26];
//        l2 = new int[26];
//        for (int i = 0; i < n; i++){
//            l1[s1.charAt(i)-'a']++;
//            l2[s2.charAt(i)-'a']++;
//        }
//
//        boolean safe1=true,safe2=true;
//        //判断s2可否击穿s1
//        for (char c:s2.toCharArray()){
//            safe1 = false;
//            for(int j = c-'a';j>=0;j--){
//                if(l1[j]>0){
//                    l1[j]--;
//                    safe1 =true;
//                    break;
//                }
//            }
//            if (!safe1) break;
//        }
//        //判断s1可否击穿s2
//        for (char c:s1.toCharArray()){
//            safe2 = false;
//            for(int j = c-'a';j>=0;j--){
//                if(l2[j]>0){
//                    l2[j]--;
//                    safe2 =true;
//                    break;
//                }
//            }
//            if (!safe2) break;
//        }
//        return safe1||safe2;
        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ++cnt[s1.charAt(i) - 'a'];
            --cnt[s2.charAt(i) - 'a'];
        }

        int sum = 0;
        boolean s1big = true, s2big = true;
        for (int i = cnt.length - 1; i >= 0; i--) {
            sum += cnt[i];
            if (sum > 0 && s2big) s2big = false;
            if (sum < 0 && s1big) s1big = false;
            if (!s1big && !s2big) return false;
        }
        return true;
    }


    public static void main(String[] args) {
//        String s1 = "leetcodee", s2 = "interview";
        String s1 = "abe", s2 = "acd";
        DW25_20050203 obj = new DW25_20050203();
        boolean solution = obj.checkIfCanBreak(s1, s2);
        System.out.println(solution);
    }
}
