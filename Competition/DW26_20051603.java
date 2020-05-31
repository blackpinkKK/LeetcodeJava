/**
 * 双周赛26-2020-05-16 第3题 1448. 统计二叉树中好节点的数目
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

package LeetcodeJava.Competition;

import LeetcodeJava.utils.TreeNode;

import java.util.List;

public class DW26_20051603 {

    public int goodNodes(TreeNode root) {
        return dfs(root,-10001);
    }

    public int dfs(TreeNode root,int max){
        if(root==null) return 0;
        int count=0;
        if (root.val>=max){
            count++;
            System.out.println(max);
            max=Math.max(root.val,max);
        }
        count+=dfs(root.left,max);
        count+=dfs(root.right,max);
        return count;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]
                {-1,5,-2,4,4,2,-2,null,null,-4,null,
                        -2,3,null,-2,
                        0,null,-1,null,-3,null,-4,-3,
                        3,null,null,null,null,null,null,null,3,-3};
//        Integer[] nums = new Integer[]{3,3,null,4,2};
        TreeNode root = new TreeNode(nums);
        DW26_20051603 obj = new DW26_20051603();
        System.out.println(obj.goodNodes(root));
    }
}
