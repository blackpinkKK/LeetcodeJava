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

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        /**
         * Iterate
         */
//        if (head == null || head.next == null){
//            return head;
//        }
//        //交换第一对
//        LeetcodeJava.ListNode tmp =head.next;
//        head.next = head.next.next;
//        tmp.next = head;
//        head = tmp;
//        //定位下一对 or 结束
//        LeetcodeJava.ListNode prev = head.next;
//        LeetcodeJava.ListNode curr;
//        if (prev != null){
//            curr = prev.next;
//        }
//        else{
//            return head;
//        }
//        while(curr != null && curr.next != null){
//            tmp = curr.next;
//            curr.next = curr.next.next;
//            tmp.next = curr;
//            prev.next = tmp;
//            //定位下一对
//            prev = curr;
//            curr = prev.next;
//        }
//        return head;

        /**
         * Recursion
         */
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;

        //交换当前两个
        first.next = swapPairs(second.next);
        second.next = first;

        return second;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        ListNode inputListNode = new ListNode(arr);
        SwapPairs r = new SwapPairs();
        ListNode solution = r.swapPairs(inputListNode);
        System.out.println(solution);

    }
}
