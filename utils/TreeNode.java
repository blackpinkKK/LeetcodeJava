/**
 * 二叉树
 * */

package LeetcodeJava.utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }

	public TreeNode(Integer[] nums){
		if (nums == null || nums.length == 0){
			throw new IllegalArgumentException("Arr cannot be empty!");
		}

		this.val = nums[0];

		if (nums.length == 1){
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root=this;
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty() && i < nums.length){
			root = queue.poll();

			if (nums[i] != null){
//				System.out.println(nums[i]);
				root.left = new TreeNode(nums[i]);
				queue.offer(root.left);
			}
			else{
//				System.out.println("Left is null");
				root.left=null;
			}

			if ((i+1<=nums.length-1) && nums[i+1] != null){
//				System.out.println(nums[i+1]);
				root.right = new TreeNode(nums[i+1]);
				queue.offer(root.right);
			}
			else{
//				System.out.println("Right is null");
				root.right=null;
			}
			i=i+2;
		}
	}

	// 树的打印方法，没写好=^=
	// @Override
	// public String toString(){
	// 	StringBuilder s = new StringBuilder();
	// 	LeetcodeJava.ListNode root = this;
	// 	while(root != null){
	// 		s.append(root.val);
	// 		s.append("->");
	// 		root=root.next;
	// 	}
	// 	s.append("NULL");
	// 	return s.toString();
	// }


	public int getVal() {
		return val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void preOrder() {
        System.out.print(val + " ");
        if(this.left!=null){
			this.left.preOrder();
		}
        if(this.right!=null){
        	this.right.preOrder();
		}
    }

    public static void main(String[] args) {
        // Integer[] nums = new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1};
//    	Integer[] nums = new Integer[] {3,2,3,null,3,null,1};
		Integer[] nums = new Integer[]{3,null,20,15,7};


		TreeNode root = new TreeNode(nums);
        root.preOrder();
    }
}
