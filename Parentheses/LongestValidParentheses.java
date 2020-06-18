/**
 * 32. 最长有效括号
 */

package LeetcodeJava.Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "((()()";
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        int maxLen =0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    dp[i + 1] = 0;

                } else {
                    int tmp = stack.pop();
                    dp[i + 1] = i - tmp + 1 + dp[tmp];
                    if(dp[i+1]>maxLen) maxLen =dp[i+1];
                }
            }
        }
        return maxLen;
    }
}
