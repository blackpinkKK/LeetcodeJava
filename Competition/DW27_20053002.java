/**
 * 双周赛27-2020-05-30 第2题 检查一个字符串是否包含所有长度为 K 的二进制子串
 */

package LeetcodeJava.Competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DW27_20053002 {
    public static void main(String[] args) {
        String s ="000100110011101";
        int k = 3;
        DW27_20053002 obj = new DW27_20053002();
        System.out.println(obj.hasAllCodes(s, k));
    }

    public boolean hasAllCodes(String s, int k) {
        Set<String> pattern = new HashSet<>();

        for(int i = 0;i<s.length()-k+1;i++){
            pattern.add(s.substring(i,i+k));
        }
        System.out.println(pattern.size());
        return pattern.size()==Math.pow(2,k);
    }
}
