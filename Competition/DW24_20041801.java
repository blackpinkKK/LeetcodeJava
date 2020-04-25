/**
 * 双周赛24-2020-04-18 第1题 5372. 逐步求和得到正数的最小值
 */

package LeetcodeJava.Competition;

public class DW24_20041801 {
    public int minStartValue(int[] nums) {
        int minimun=1,sum=0;
        for (int num : nums) {
            sum += num;
            if (sum < 1) minimun = Math.min(sum, minimun);
        }
        return Math.max(-minimun+1,1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        DW24_20041801 cls = new DW24_20041801();
        int solution = cls.minStartValue(nums);
        System.out.println(solution);
    }
}
