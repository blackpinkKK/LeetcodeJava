/**
 * 1021. 删除最外层的括号
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 */

package LeetcodeJava.Parentheses;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        RemoveOuterParentheses obj = new RemoveOuterParentheses();
        System.out.println(obj.removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return S;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c: S.toCharArray()) {
            if(c=='(') cnt++;
            if(cnt>1) sb.append(c);
            if(c==')') cnt--;
        }
        return sb.toString();
    }
}
