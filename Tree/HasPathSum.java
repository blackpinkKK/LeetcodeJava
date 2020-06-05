/**
 * 112. 路径总和
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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HasPathSum {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
//        Integer[] nums = new Integer[]{-2,null,-3};
        Integer[] nums = new Integer[]{1,-2,-3,1,3,-2,null,-1};
        TreeNode root = new TreeNode(nums);
        int sum = -1;
        HasPathSum obj = new HasPathSum();
        System.out.println(obj.hasPathSum(root,sum));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val==sum) {
            if(root.left==null&&root.right==null) return true;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }

}
