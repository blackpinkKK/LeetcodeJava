package LeetcodeJava.Tree;

import LeetcodeJava.utils.TreeNode;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        SortedArrayToBST obj = new SortedArrayToBST();
        TreeNode solution = obj.sortedArrayToBST(nums);
        solution.preOrder();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        //1.Recursion
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode ans;
        if (nums.length == 2) {
            ans = new TreeNode(nums[0]);
            ans.right = new TreeNode(nums[1]);
            return ans;
        }
//        System.out.println(Arrays.toString(nums));
        int mid = nums.length / 2;
        ans = new TreeNode(nums[mid]);

        int[] numsLeft = new int[mid];
        System.arraycopy(nums, 0, numsLeft, 0, mid);
        ans.left = sortedArrayToBST(numsLeft);

        int[] numsRight = new int[nums.length - 1 - mid];
        System.arraycopy(nums, mid + 1, numsRight, 0, nums.length - 1 - mid);
        ans.right = sortedArrayToBST(numsRight);

        return ans;

        //2.Iteration
    }
}
