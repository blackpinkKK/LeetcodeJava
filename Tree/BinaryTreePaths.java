/**
 * 257. 二叉树的所有路径
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

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
//        Integer[] nums = new Integer[]{-2,null,-3};
        Integer[] nums = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = new TreeNode(nums);
        BinaryTreePaths obj = new BinaryTreePaths();
        System.out.println(obj.binaryTreePaths(root));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root==null) return ans;
        StringBuilder curr = new StringBuilder();
        curr.append(root.val);
        dfs(root.left,curr,ans);
        dfs(root.right,curr,ans);
        if(ans.size()==0){
            ans.add(String.valueOf(root.val));
        }
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder curr,List<String> ans){
        if(root==null) {
            return;
        }
        curr.append("->");
        curr.append(root.val);
        if(root.left==null&&root.right==null) {
            ans.add(curr.toString());
        }else{
            dfs(root.left,curr,ans);
            dfs(root.right,curr,ans);
        }
        curr.delete(curr.length()-String.valueOf(root.val).length(),curr.length());
        curr.delete(curr.length()-2,curr.length());
    }

}
