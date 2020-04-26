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

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        /**
         * Iterate
         */
        if (head == null || head.next == null || m==n){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        //移动到第m位
        int i = 1;
        while (i < m){
            prev = curr;
            curr = curr.next;
            i++;
        }
        ListNode mPrev = prev;
        ListNode mCurr = curr;
        //中间段反转
        while(curr != null && i < n+1){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            i++;
        }
        //拼接头尾
        mCurr.next = curr;
        if(m>1){
            mPrev.next = prev;
        }
        else{
            head = prev;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode inputListNode = new ListNode(arr);
        ReverseBetween r = new ReverseBetween();
        ListNode solution = r.reverseBetween(inputListNode,1,3);
        System.out.println(solution);
    }
}
