/**
 * 687. 最长同值路径
 * <p>
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.Tree;

import LeetcodeJava.DynamicProgramming.MaxProduct;
import LeetcodeJava.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestUnivaluePath {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5,4,5,1,1,5,5,6,6,7,5,5,5,5,5};
        Integer[] nums = new Integer[]{5,4,5,1,1,5,5,6,6,7,5,5,5,5};
//        Integer[] nums = new Integer[]{1, 4, 5, 4, 4, 5};
        TreeNode root = new TreeNode(nums);
        LongestUnivaluePath obj = new LongestUnivaluePath();
        System.out.println(obj.longestUnivaluePath(root));
    }

    int maxLen;

    public int longestUnivaluePath(TreeNode root) {
        maxLen = 0;
        dfs(root);
        return maxLen;
    }

    public int dfs(TreeNode root){
        if (root == null) return 0;
        int leftLen = 0;
        int rightLen = 0;
        int left =dfs(root.left);
        int right =dfs(root.right);
        if (root.left != null && root.val == root.left.val) {
            leftLen += left+1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightLen += right+1;
        }
        maxLen = Math.max(maxLen,leftLen+rightLen);
        return Math.max(leftLen,rightLen);
    }

}
