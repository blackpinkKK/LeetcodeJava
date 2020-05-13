/**
 * 700. 二叉搜索树中的搜索
 */

package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(val==root.val){
                return root;
            }else{
                if(val < root.val){
                    root=root.left;
                }else {
                    root=root.right;
                }
            }
        }
        return null;
    }
}
