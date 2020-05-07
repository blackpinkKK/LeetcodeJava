/**
 * 784. 字母大小写全排列
 */

package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    void backTrace(int i, String S, String curr, List<String> ans) {
        //upper: 65-90, lower: 97-122
        if (i == S.length()) {
            ans.add(curr);
            return;
        }
        char c = S.charAt(i);
        backTrace(i + 1, S, curr + c, ans);
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
            backTrace(i + 1, S, curr + c, ans);
        } else if (c >= 'a' && c <= 'z') {
            c = (char) (c - 32);
            backTrace(i + 1, S, curr + c, ans);
        }
    }

    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) return null;
        List<String> ans = new ArrayList<>();
        backTrace(0, S, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        String S = "a z";
        LetterCasePermutation obj = new LetterCasePermutation();
        System.out.println(obj.letterCasePermutation(S));
    }
}
