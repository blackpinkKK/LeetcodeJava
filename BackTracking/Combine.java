/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */


package LeetcodeJava.BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Combine {
    //1.递归回溯法
    void backTracking(int last,int n, int k, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k) {
//            ans.add(curr);//Wrong
            ans.add(new ArrayList<>(curr));//Correct
            return;
        }
        //为避免重复，从上一个选取的数字后面开始
        for (int j = last+1; j < n; j++) {
            curr.add(j+1);
            backTracking(j, n, k, curr, ans);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(-1, n,k, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 5,k=3;
        Combine obj = new Combine();
        System.out.println(obj.combine(n,k));
    }
}
