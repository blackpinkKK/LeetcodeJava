/**
 * 104. 二叉树的最大深度
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;

public class MaxDepth {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
//        Integer[] nums = new Integer[]{1};
        Integer[] nums = new Integer[]{1,2,3,null,null,4,null,5};
        TreeNode root = new TreeNode(nums);
//        root.preOrder();
        MaxDepth obj = new MaxDepth();
        System.out.println("The minimum depth : " + obj.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        //DFS
        if (root == null) return 0;

        int leftMin = maxDepth(root.left);
        int rightMin = maxDepth(root.right);
        if(leftMin==0 || rightMin==0){
            return 1+leftMin+rightMin;
        }

        return 1+Math.max(leftMin,rightMin);
    }

}
