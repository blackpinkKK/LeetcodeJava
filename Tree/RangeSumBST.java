/**
 * 111. 二叉树的最小深度
 * 说明: 叶子节点是指没有子节点的节点。
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

public class RangeSumBST {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
//        Integer[] nums = new Integer[]{1};


//        root.preOrder();
        Integer[] nums = new Integer[]{10, 5, 15, 3, 7, null, 18};
        int L = 7, R = 15;
//        Integer[] nums = new Integer[]{10,5,15,3,7,13,18,1,null,6};
//        int L = 6, R = 10;

        TreeNode root = new TreeNode(nums);
        RangeSumBST obj = new RangeSumBST();

        System.out.println("The sum is : " + obj.rangeSumBST(root, L, R));
    }

    //1.DFS
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) {
            return rangeSumBST(root.right,L,R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left,L,R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    //2.BFS
//    public int rangeSumBST(TreeNode root, int L, int R) {
//        int ans = 0;
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(root);
//        while (!treeNodeQueue.isEmpty()) {
//            TreeNode front = treeNodeQueue.poll();
//            if (front.val >= L && front.val <= R) {
//                ans += front.val;
//                System.out.println(ans);
//                if (front.left != null) {
//                    treeNodeQueue.offer(front.left);
//                }
//                if (front.right != null) {
//                    treeNodeQueue.offer(front.right);
//                }
//            }else{
//                if(front.val < L ){
//                    if (front.right != null) {
//                        treeNodeQueue.offer(front.right);
//                    }
//                }else{
//                    if (front.left != null) {
//                        treeNodeQueue.offer(front.left);
//                    }
//                }
//            }
//        }
//        return ans;
//    }

}
