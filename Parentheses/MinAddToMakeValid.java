/**
 * 921. 使括号有效的最少添加
 */

package LeetcodeJava.Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "((()()";
        MinAddToMakeValid obj = new MinAddToMakeValid();
        System.out.println(obj.minAddToMakeValid(s));
    }

    public int minAddToMakeValid(String S) {
        if(S==null || S.length()==0) return 0;
        int ans = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else
                if (stack.isEmpty() || c!=stack.pop())
                    ans++;
        }
        return stack.size()+ans;
    }
}
