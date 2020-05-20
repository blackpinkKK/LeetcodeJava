/**
 * 双周赛26-2020-05-16 第1题  连续字符
 */

package LeetcodeJava.Competition;

public class DW26_20051601 {

    public int maxPower(String s) {
        int count = 0;
        int maxCount = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else count = 0;
        }
        return maxCount + 1;
    }

    public static void main(String[] args) {
        String s = "triplepillooooow";
        DW26_20051601 obj = new DW26_20051601();
        System.out.println(obj.maxPower(s));
    }
}
