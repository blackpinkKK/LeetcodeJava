/**
 * 双周赛26-2020-05-16 第2题
 */

package LeetcodeJava.Competition;

import java.util.ArrayList;
import java.util.List;

public class DW26_20051602 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();

        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if (gcd(i, j) == 1) {
                    String s = j + "/" + i;
                    ans.add(s);
                }

            }
        }
        return ans;
    }
    public int gcd(int i, int j){
        if(j==0) return i;
        return gcd(j,i%j);
    }


    public static void main(String[] args) {
        int n = 12;
        DW26_20051602 obj = new DW26_20051602();
        List<String> solution= obj.simplifiedFractions(n);
        System.out.println(solution.toString());
    }
}
