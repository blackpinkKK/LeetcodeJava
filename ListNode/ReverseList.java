/**
 * 206.反转链表
 * Definition for singly-linked list.
 * public class LeetcodeJava.ListNode {
 *     int val;
 *     LeetcodeJava.ListNode next;
 *     LeetcodeJava.ListNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        /**
         * Iterate
         */

//        if (head == null || head.next == null){
//            return head;
//        }
//
//        LeetcodeJava.ListNode prev = null;
//        LeetcodeJava.ListNode curr = head;
//
//        while( curr != null){
//            LeetcodeJava.ListNode tmp =curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = tmp;
//        }
//
//        return prev;

        /**
         * Recursion
         */

        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode inputListNode = new ListNode(arr);
        ReverseList r = new ReverseList();
        ListNode solution = r.reverseList(inputListNode);
        System.out.println(solution);
    }
}
