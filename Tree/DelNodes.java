/**
 * 1110. 删点成林
 * 把一些节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
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

public class DelNodes {

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = new TreeNode(nums);
        int[] to_delete = {3, 5};
        DelNodes obj = new DelNodes();
        List<TreeNode> solution = obj.delNodes(root, to_delete);
        for (TreeNode t : solution) {
            t.preOrder();
            System.out.println("---------");
        }
    }

//    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        Set<Integer> delSet = new HashSet<>();
//        for(int num:to_delete){
//            delSet.add(num);
//        }
//        List<TreeNode> ans = new ArrayList<>();
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        TreeNode dummy = new TreeNode(0);
//        dummy.left=root;
//        treeNodeQueue.offer(dummy);
//
//        while (!treeNodeQueue.isEmpty()){
//            TreeNode front = treeNodeQueue.poll();
//            if(front==null) continue;
//            if(front.left!=null){
//                if(!delSet.contains(front.left.val)){
//                    ans.add(front.left);
//                    treeNodeQueue.offer(front.left.left);
//                    treeNodeQueue.offer(front.left.right);
//                }else{
//                    treeNodeQueue.offer(front.left.left);
//                    treeNodeQueue.offer(front.left.right);
//                    front.left = null;
//                }
//            }
//
//            if(front.right!=null){
//                if(!delSet.contains(front.right.val)){
//                    ans.add(front.right);
//                    treeNodeQueue.offer(front.right.left);
//                    treeNodeQueue.offer(front.right.right);
//                }else{
//                    treeNodeQueue.offer(front.right.left);
//                    treeNodeQueue.offer(front.right.right);
//                    front.right = null;
//                }
//            }
//        }
//        ans.set(0,ans.get(0).left);
//        return ans;
//    }

    List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delSet = new HashSet<>();
        for (int num : to_delete) {
            delSet.add(num);
        }
        dfs(root, delSet, true);
        return list;
    }

    public void dfs(TreeNode root, Set<Integer> delSet, boolean isNew) {
        if (root == null) return;
        if (delSet.contains(root.val)) {
            dfs(root.left, delSet, true);
            dfs(root.right, delSet, true);
            root.left = null;
            root.right = null;
        } else {
            if (isNew) {
                list.add(root);
            }
            if (root.left != null && delSet.contains(root.left.val)) {
                dfs(root.left, delSet, false);
                root.left = null;
            }
            if (root.right != null && delSet.contains(root.right.val)) {
                dfs(root.right, delSet, false);
                root.right = null;
            }
            dfs(root.left, delSet, false);
            dfs(root.right, delSet, false);
        }
    }
}
