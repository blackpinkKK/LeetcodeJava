/**
 * 112. 路径总和 2
 * 输出路径和为sum的所有路径
 * <p>
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        Integer[] nums = new Integer[]{-2,null,-3};
//        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = new TreeNode(nums);
        int sum = -5;
        PathSum obj = new PathSum();
        System.out.println(obj.pathSum(root,sum));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,sum,new ArrayList<>(),ans);
        return ans;
    }

    public void dfs(TreeNode root, int sum,List<Integer> curr,List<List<Integer>> ans){
        if(root==null) return;
        curr.add(root.val);
        if(root.val==sum && root.left==null&&root.right==null) {
            List<Integer> path = new ArrayList<>(curr);
            ans.add(path);
        }else{
            dfs(root.left,sum-root.val,curr,ans);
            dfs(root.right,sum-root.val,curr,ans);
        }
        curr.remove(curr.size()-1);
    }

}
