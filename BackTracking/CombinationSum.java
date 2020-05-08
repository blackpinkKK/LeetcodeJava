/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 */


package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //1.递归回溯法
    void backTracking(int last,int[] candidates,int target,List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
//            ans.add(curr);//Wrong
            ans.add(new ArrayList<>(curr));//Correct
            return;
        }else if(last==candidates.length-1){
            //找完 candidates 没有达到 target
            return;
        }
        //为避免重复，从上一个选取的数字后面开始
        for (int j = last+1; j < candidates.length; j++) {
            int sum = 0;
            // 依次选取当前数字一次，二次，三次直到超过target，没选一次进行下一次递归
            // 为免重复，下一次递归只能从当前数之后的元素选取
            while(sum+candidates[j]<=target){
                sum+=candidates[j];
                curr.add(candidates[j]);
                backTracking(j, candidates, target-sum, curr, ans);
            }
            //把包含的当前元素全部去除，进入下一个循环，之后的解都不会出现当前元素
            while(sum>0 && curr.size()>0){
                sum-=candidates[j];
                curr.remove(curr.size()-1);//循环内还是外
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(-1,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{9};
        int target = 8;
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(candidates,target));
    }
}
