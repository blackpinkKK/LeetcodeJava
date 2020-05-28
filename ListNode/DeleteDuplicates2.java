/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class DeleteDuplicates2 {
    //哑结点+双指针
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null && curr.next.next!=null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode tmp = curr.next;
                while(tmp.next!=null && tmp.next.val==curr.next.val){
                    tmp=tmp.next;
                }
                curr.next = tmp.next;
            } else {
                curr=curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{ 0,0,0, 1, 2, 3, 4, 5, 5, 5, 5, 6, 6};
        int[] arr = new int[]{1, 1, 1, 2, 3};
        ListNode inputListNode = new ListNode(arr);
        DeleteDuplicates2 obj = new DeleteDuplicates2();
        System.out.println(obj.deleteDuplicates(inputListNode));
    }
}
