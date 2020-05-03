/**
 * 双周赛25-2020-04-25 第1题 5384. 拥有最多糖果的孩子
 */

package LeetcodeJava.Competition;

import java.util.ArrayList;
import java.util.List;

public class DW25_20050201 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for(int c:candies){
            maxCandies=Math.max(maxCandies,c);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int c:candies){
            if(c+extraCandies<maxCandies){
                ans.add(false);
            }else{
                ans.add(true);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,3,5,1,3};
        int[] nums = new int[]{12,1,12};
        DW25_20050201 obj = new DW25_20050201();
        List<Boolean> solution= obj.kidsWithCandies(nums,10);
        System.out.println(solution.toString());
    }
}
