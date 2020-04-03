/**
 * 227.打家劫舍问题

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

package LeetcodeJava;

import LeetcodeJava.utils.TreeNode;




public class Rob3 {
    public int rob(TreeNode root) {
    	int[] result = robInternal(root);
    	return Math.max(result[0],result[1]);
    }

    public int[] robInternal(TreeNode root){

    	int[] res = new int[2];

    	if (root == null){
    		res[0] = 0;
    		res[1] = 0;
    		return res;
    	}
    	
    	int[] left = robInternal(root.left);
    	int[] right = robInternal(root.right);

    	
    	res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
    	res[1] = left[0] + right[0]+root.val;

    	return res;
    }
    

    public static void main(String[] args) {
    	// Integer[] nums = new Integer[] {3,2,3,null,3,null,1}; 
    	// Integer[] nums = new Integer[] {3,4,5,1,3,null,1}; 
    	 Integer[] nums = new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1};
//    	Integer[] nums = new Integer[] {null};

    	TreeNode t = new TreeNode(nums);
    	Rob3 r = new Rob3();
    	int ans = r.rob(t);
    	System.out.println(ans);

    }
}