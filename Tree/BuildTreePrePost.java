/**
 * 889. 根据前序和后序遍历构造二叉树
 * 假设树中没有重复的元素,答案不唯一，返回一个答案即可
 */

package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePrePost {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        BuildTreePrePost obj = new BuildTreePrePost();
        TreeNode solution = obj.buildTree(preorder, inorder);
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

    private int preIndex = 0;
    private int[] preorder,inorder;
    Map<Integer, Integer> numberIndex;

    public TreeNode helper(int inleft,int inright) {
        if(inleft>=inright) return null;
        int rootVal = preorder[preIndex];
        TreeNode ans = new TreeNode(rootVal);
        int i = numberIndex.get(this.preorder[preIndex]);

        preIndex++;
        ans.left = helper(inleft,i);
        ans.right = helper(i+1, inright);

        return ans;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        numberIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numberIndex.put(inorder[i], i);
        }
        return helper(0,inorder.length);
    }
}
