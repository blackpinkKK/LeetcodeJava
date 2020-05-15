/**
 * 109. 有序链表转换二叉搜索树
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; } *
 */

package LeetcodeJava.Tree;

import LeetcodeJava.utils.ListNode;
import LeetcodeJava.utils.TreeNode;

public class Flatten {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 5, 3, 4, null, 6};
        TreeNode root = new TreeNode(nums);
        Flatten obj = new Flatten();
        obj.flatten(root);
        root.preOrder();
    }

    private  TreeNode pre =null;
    public void flatten(TreeNode root) {
//        if(root==null) return;
//        if(root.left==null&&root.right==null) return;
//        if(root.left==null) {
//            flatten(root.right);
//            return;
//        }
//        if (root.right==null) {
//            root.right=root.left;
//            root.left=null;
//            flatten(root.right);
//            return;
//        }
//        else{
//            flatten(root.left);
//            flatten(root.right);
//            TreeNode tmp = root.right;
//            root.right=root.left;
//            root.left=null;
//            while (root.right!=null){
//                root=root.right;
//            }
//            root.right =tmp;
//        }
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right= pre;//此时pre已指向root.left

        root.left=null;
        pre=root;
    }
}
