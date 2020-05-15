/**
 * 109. 有序链表转换二叉搜索树
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; } *
 */

package LeetcodeJava.Tree;

import LeetcodeJava.utils.ListNode;
import LeetcodeJava.utils.TreeNode;

import java.util.List;

public class SortedListToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        ListNode head = new ListNode(nums);
        SortedListToBST obj = new SortedListToBST();
        TreeNode solution = obj.sortedListToBST(head);
        solution.preOrder();
    }

    public TreeNode sortedListToBST(ListNode head) {
        //1.Recursion
        if (head == null ) return null;
        if (head.next==null) return new TreeNode(head.val);
        TreeNode ans;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev=null;

        while(fast.next!=null){
            fast = fast.next.next;
            if (fast==null) break;
            prev=slow;
            slow=slow.next;
        }

        ListNode rightList = slow.next;
        ans = new TreeNode(slow.val);
        if(prev==null){
            ans = new TreeNode(head.val);
            ans.right = new TreeNode(head.next.val);
            return ans;
        }

        prev.next=null;
        ans.left = sortedListToBST(head);
        ans.right = sortedListToBST(rightList);
        return ans;

        //2.Iteration
    }
}
