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

public class MinDepth {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
        Integer[] nums = new Integer[]{1};
        TreeNode root = new TreeNode(nums);
//        root.preOrder();
        MinDepth obj = new MinDepth();
        System.out.println("The minimum depth : " + obj.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        //BFS
//        if (root == null) return 0;
//        Queue<Pair<TreeNode,Integer>> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(new Pair<>(root,1));
//
//        int depth = 0;
//        while (!treeNodeQueue.isEmpty()) {
//            Pair<TreeNode,Integer> topPair = treeNodeQueue.poll();
////            System.out.println(topPair.getKey().val);
//            TreeNode top = topPair.getKey();
//            depth = topPair.getValue();
//            if (top.left == null && top.right == null) {
//                break;
//            }
//            if(top.left!=null){
//                treeNodeQueue.offer(new Pair<>(top.left,depth+1));
//            }
//            if(top.right!=null){
//                treeNodeQueue.offer(new Pair<>(top.right,depth+1));
//            }
//
//        }
//        return depth;

        //DFS
        if (root == null) return 0;

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if(leftMin==0 || rightMin==0){
            return 1+leftMin+rightMin;
        }

        return 1+Math.min(leftMin,rightMin);
    }

}
