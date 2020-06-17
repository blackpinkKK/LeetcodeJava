/**
 * 20. 有效的括号
 */

package LeetcodeJava.Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IsValid {
    public static void main(String[] args) {
        String s = "]";
        IsValid obj = new IsValid();
        boolean solution = obj.isValid(s);
        System.out.println(solution);
    }

    public boolean isValid(String s) {


//        if(s==null || s.length()==0) return true;
////        Map<Character,Character> map = new HashMap<>();
////        map.put('{','}');
////        map.put('(',')');
////        map.put('[',']');
////
////        Deque<Character> stack = new ArrayDeque<>();
////        for (char c : s.toCharArray()) {
////            if(map.containsKey(c))
////                stack.push(c);
////            else if(map.containsValue(c)){
////                if (stack.isEmpty() && c!=map.get(stack.pop()))
////                    return false;
////            }
////        }
////        return stack.isEmpty();

        if(s==null || s.length()==0) return true;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else
                if (stack.isEmpty() || c!=stack.pop())
                    return false;
        }
        return stack.isEmpty();
    }
}
