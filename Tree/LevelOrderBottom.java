/**
 * 107. 二叉树的层次遍历 II
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
//        Integer[] nums = new Integer[]{1};
        Integer[] nums = new Integer[]{1,2,3,null,null,4,null,5};
        TreeNode root = new TreeNode(nums);
//        root.preOrder();
        LevelOrderBottom obj = new LevelOrderBottom();
        System.out.println("The minimum depth : " + obj.levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //queue+BFS
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while(!treeNodeQueue.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while(!treeNodeQueue.isEmpty()){
                TreeNode front = treeNodeQueue.poll();
                level.add(front.val);
                if (front.left!=null)tmp.add(front.left);
                if (front.right!=null)tmp.add(front.right);
            }
            ans.add(0,level);
            treeNodeQueue=tmp;
        }

        return ans;
    }

}
