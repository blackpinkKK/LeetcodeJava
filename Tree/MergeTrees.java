/**
 * 617. 合并二叉树
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

import java.util.LinkedList;
import java.util.Queue;

public class MergeTrees {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
//        Integer[] nums = new Integer[]{1};
        Integer[] nums = new Integer[]{1,2,3,null,null,4,null,5};
        TreeNode root = new TreeNode(nums);
//        root.preOrder();
        TreeNode treeNode1 = new TreeNode(new Integer[]{1,3,2,5});
        TreeNode treeNode2 = new TreeNode(new Integer[]{2,1,8,null,4,null,7});

        MergeTrees obj = new MergeTrees();
        TreeNode solution = obj.mergeTrees(treeNode1,treeNode2);
        solution.preOrder();
    }

    //1.Recursion
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if(t1==null) return t2;
//        if(t2==null) return t1;
//
//        TreeNode node = new TreeNode(t1.val + t2.val);
//        node.left = mergeTrees(t1.left,t2.left);
//        node.right = mergeTrees(t1.right,t2.right);
//        return node;
//    }

    //Iteration
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(t1);
        q2.offer(t2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode front1 = q1.poll();
            TreeNode front2 = q2.poll();
            front1.val += front2.val;
            if (front1.left != null && front2.left != null) {
                q1.offer(front1.left);
                q2.offer(front2.left);
            } else {
                if (front2.left != null) {
                    front1.left = front2.left;
                }
            }
            if (front1.right != null && front2.right != null) {
                q1.offer(front1.right);
                q2.offer(front2.right);
            } else {
                if (front2.right != null) {
                    front1.right = front2.right;
                }
            }
        }

        return t1;
    }

}
