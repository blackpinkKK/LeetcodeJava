/**
 * 988. 从叶结点开始的最小字符串
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

import java.util.*;

public class SmallestFromLeaf {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{0, 1, 2, 3, 4, 3, 4};
//        Integer[] nums = new Integer[]{25,1,3,1,3,0,2};
//        Integer[] nums = new Integer[]{2, 2, 1, null, 1, 0, null, 0};
//        Integer[] nums = new Integer[]{4, 0, 1, 1};
        Integer[] nums = new Integer[]{25,1,null,0,0,1,null,null,null,0};
        TreeNode root = new TreeNode(nums);
        SmallestFromLeaf obj = new SmallestFromLeaf();
        System.out.println(obj.smallestFromLeaf(root));
    }

    String ans = String.valueOf((char) ('z'+1));
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return ans;
    }

    void dfs(TreeNode root, StringBuilder curr) {
        if (root == null) return;
        curr.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            String tmp = curr.reverse().toString();
            curr.reverse();
            if(tmp.compareTo(ans)<0){
                ans = tmp;
            }
        }else{
            dfs(root.left, curr);
            dfs(root.right, curr);
        }
        curr.deleteCharAt(curr.length() - 1);
    }

}
