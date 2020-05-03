/**
 * 双周赛25-2020-04-25 第3题 5386. 检查一个字符串是否可以打破另一个字符串
 */

package LeetcodeJava.Competition;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DW25_20050203 {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();
        int[] l1,l2;
        l1 = new int[26];
        l2 = new int[26];
        for (int i = 0; i < n; i++){
            l1[s1.charAt(i)-'a']++;
            l2[s2.charAt(i)-'a']++;
        }

//        System.out.println(Arrays.toString(l1));
//        System.out.println(Arrays.toString(l2));
        boolean safe1=true,safe2=true;

        for (char c:s2.toCharArray()){
            safe1 = false;
            for(int j = c-'a';j>=0;j--){
                if(l1[j]>0){
//                    System.out.println(l1[j]);
                    l1[j]--;
                    safe1 =true;
//                    System.out.println(c+" "+j);
                    break;
                }
            }
            if (!safe1) break;
        }

        for (char c:s1.toCharArray()){
            safe2 = false;
            for(int j = c-'a';j>=0;j--){
                if(l2[j]>0){
//                    System.out.println(l1[j]);
                    l2[j]--;
                    safe2 =true;
//                    System.out.println(c+" "+j);
                    break;
                }
            }
            if (!safe2) break;
        }

        return safe1||safe2;
    }


    public static void main(String[] args) {
        String s1 = "leetcodee", s2 = "interview";
        DW25_20050203 obj = new DW25_20050203();
        boolean solution = obj.checkIfCanBreak(s1,s2);
        System.out.println(solution);
    }
}
