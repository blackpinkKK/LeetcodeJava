/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 假设树中没有重复的元素
 */

package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeInPost {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9,15,7,20,3};
        BuildTreeInPost obj = new BuildTreeInPost();
        TreeNode solution = obj.buildTree(inorder,postorder);
        solution.preOrder();
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0) return null;
//        TreeNode ans = new TreeNode(preorder[0]);
//        if (preorder.length == 1) return ans;
//
//        int i = 0;
//        while (inorder[i] != preorder[0]) {
//            i++;
//        }
//
//        int[] preorderLeft = Arrays.copyOfRange(preorder,1,i+1);
//        int[] inorderLeft = Arrays.copyOfRange(inorder,0,i);
//        ans.left = buildTree(preorderLeft, inorderLeft);
//
//        int[] preorderRight = Arrays.copyOfRange(preorder,i+1,preorder.length);
//        int[] inorderRight = Arrays.copyOfRange(inorder,i+1,preorder.length);
//        ans.right = buildTree(preorderRight, inorderRight);
//
//        return ans;
//    }

    private int postIndex;
    private int[] inorder,postorder;
    Map<Integer, Integer> numberIndex;

    public TreeNode helper(int inleft,int inright) {
        if(inleft>=inright) return null;
        int rootVal = postorder[postIndex];
        TreeNode ans = new TreeNode(rootVal);
        int i = numberIndex.get(this.postorder[postIndex]);

        postIndex--;
        ans.right = helper(i+1, inright);
        ans.left = helper(inleft,i);

        return ans;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) return null;
        this.postorder = postorder;
        this.inorder = inorder;
        this.postIndex = postorder.length-1;
        numberIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numberIndex.put(inorder[i], i);
        }
        return helper(0,inorder.length);
    }
}
