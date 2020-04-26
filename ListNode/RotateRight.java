/**
 * 61.旋转链表
 * Definition for singly-linked list.
 * public class LeetcodeJava.ListNode {
 *     int val;
 *     LeetcodeJava.ListNode next;
 *     LeetcodeJava.ListNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * 双指针
         */
        if (head == null || head.next == null || k==0){
            return head;
        }
        ListNode pFront = head;
        ListNode pBehind = head;

        int i = 0;
        while (i < k && pFront.next!=null){
            pFront = pFront.next;
            i++;
        }
        //如果链表长度小于 k， 先将 k 对链表长度 (i+1) 取模得到 pos；
        if (i<k){
            int pos = k%(i+1);
            pFront=head;
            i = 0;
            //然后再将pFront移到第 pos 个节点
            while(i < pos){
                pFront = pFront.next;
                i++;
            }
        }
        //双指针一起移动，直到 pFront 到达末尾
        while (pFront.next != null){
            pFront = pFront.next;
            pBehind = pBehind.next;
        }
        //将末尾段移到head
        pFront.next = head;
        head = pBehind.next;
        pBehind.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        ListNode inputListNode = new ListNode(arr);
        RotateRight r = new RotateRight();
        ListNode solution = r.rotateRight(inputListNode,8);
        System.out.println(solution);
    }
}
