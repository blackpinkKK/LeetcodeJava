/***
 * 739. 每日温度
 */

package LeetcodeJava.Array;

import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        DailyTemperatures obj = new DailyTemperatures();
        System.out.println(Arrays.toString(obj.dailyTemperatures(temperatures)));
        //[8,1,5,4,3,2,1,1,0,0]
    }

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = T.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && T[i]>=T[stack.peek()]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?0:(stack.peek()-i);
            stack.push(i);
        }
        System.out.println(stack);
        return ans;
    }
}
