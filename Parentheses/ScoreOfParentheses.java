/**
 * 856. 括号的分数
 */

package LeetcodeJava.Parentheses;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ScoreOfParentheses {
    public static void main(String[] args) {
        String s = "(()(()))";
        ScoreOfParentheses obj = new ScoreOfParentheses();
        System.out.println(obj.scoreOfParentheses(s));
    }

    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[S.length() + 1];
        dp[0] = 0;
        char[] charArray = S.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.push(i);
//                dp[i+1] = dp[i];
            } else {
                int tmp = stack.pop();
                if (i - tmp == 1) {
                    //如果只添加了一对括号，则在本次添加括号的起始位置的前一位的dp值(dp[tmp])上加1
                    dp[i + 1] = dp[tmp] + 1;
                } else {
                    //如果是添加了1个括号将前面其他括号包含在内，则将前一位的dp值×2，
                    // 再加上本次添加括号的起始位置之前一位的dp值(dp[tmp])
                    dp[i + 1] = dp[i] * 2 + dp[tmp];
                }
            }
        }
        return dp[S.length()];
    }
}
