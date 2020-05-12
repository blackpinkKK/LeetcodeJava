package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{1,null,2,3};
//        Integer[] nums = new Integer[]{1,2,3,4,null,null,5};
//        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
//        Integer[] nums = new Integer[]{2,3,null,1};
        Integer[] nums = new Integer[]{3,1,null,null,2};

        TreeNode root = new TreeNode(nums);
        Traversal obj = new Traversal();
//        System.out.println(obj.traversal(root));
//        System.out.println(obj.preorderTraversal(root));
//        System.out.println(obj.inorderTraversal(root));
        System.out.println(obj.postorderTraversal(root));
    }


    List<Integer> ans = new ArrayList<>();

    /**
     * 144. 二叉树的前序遍历, 94. 二叉树的中序遍历, 145. 二叉树的后序遍历
     */
    //1.Recursion
    public List<Integer> traversal(TreeNode root) {
        if (root==null) return ans;
        ans.add(root.val);//PreOrder 前序
        if(root.left!=null){
            traversal(root.left);
        }
//        ans.add(root.val);//InOrder 中序
        if(root.right!=null){
            traversal(root.right);
        }
//        ans.add(root.val);//PostOrder 后序
        return ans;
    }

    //2.Iteration
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) return ans;
        Stack<TreeNode> treeNodeStack = new Stack<>();

        while(!treeNodeStack.isEmpty() || root!=null){
            ans.add(root.val);
            if(root.right!=null){
                treeNodeStack.push(root.right);
            }
            if(root.left!=null){
                root=root.left;
            }else{
                if(treeNodeStack.isEmpty()) break;
                root = treeNodeStack.pop();
            }
        }
       return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return ans;
        Stack<Pair<Integer,TreeNode>> pairStack = new Stack<>();
        while(true){
            if(root==null){
                if(!pairStack.isEmpty()){
                    Pair<Integer,TreeNode> topPair = pairStack.pop();
                    ans.add(topPair.getKey());
                    root=topPair.getValue();
                    continue;
                }else{
                    break;
                }
            }
            if(root.left==null){
                ans.add(root.val);
                root=root.right;
            }else{
                pairStack.push(new Pair<>(root.val,root.right));
                root=root.left;
            }
        }
        return ans;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root==null) return ans;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while(!treeNodeStack.isEmpty()){
            root = treeNodeStack.pop();
            if(root==null){
                continue;
            }
            ans.add(0,root.val);
            if(root.left!=null || root.right!=null){
                treeNodeStack.push(root.left);
                treeNodeStack.push(root.right);
            }
        }
        return ans;
    }
}
