/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
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
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{3,9,20,null,null,15,7};
//        Integer[] nums = new Integer[]{1,2,3,4,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{1,null,3,4,5};
        Integer[] nums = new Integer[]{1, 3, 2};
        TreeNode root = new TreeNode(nums);
//        root.preOrder();
        AverageOfLevels obj = new AverageOfLevels();
        System.out.println("The minimum depth : " + obj.averageOfLevels(root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        //BFS
//        List<Double> ans = new ArrayList<>();
//        if (root == null){
//            ans.add((double) 0);
//            return ans;
//        }
//        Queue<Pair<TreeNode,Integer>> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(new Pair<>(root,1));
//
//        int depth=1;
//        double sum=0;
//        int num=0;
//        while (!treeNodeQueue.isEmpty()) {
//            Pair<TreeNode,Integer> topPair = treeNodeQueue.poll();
//            TreeNode top = topPair.getKey();
//            if (depth!=topPair.getValue()){
//                ans.add(sum/num);
//                sum=0;
//                num=0;
//            }
//            sum+=top.val;
//            num++;
//            depth = topPair.getValue();
//
//            if (top.left == null && top.right == null) {
//                continue;
//            }
//            if(top.left!=null){
//                treeNodeQueue.offer(new Pair<>(top.left,depth+1));
//            }
//            if(top.right!=null){
//                treeNodeQueue.offer(new Pair<>(top.right,depth+1));
//            }
//        }
//        ans.add(sum/num);
//        return ans;

        List<Double> ans = new ArrayList<>();
        if (root == null) {
            ans.add((double) 0);
            return ans;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        while (!treeNodeQueue.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<>();
            double sum = 0;
            int num = 0;
            while (!treeNodeQueue.isEmpty()) {
                TreeNode top = treeNodeQueue.poll();
                sum += top.val;
                num++;
                if (top.left != null) tmp.add(top.left);
                if (top.right != null) tmp.add(top.right);
            }
            ans.add(sum / num);
            treeNodeQueue = tmp;
        }
        return ans;

    }

}
