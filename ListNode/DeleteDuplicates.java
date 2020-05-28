/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val==prev.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                prev = curr;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 0,0,0, 1, 2, 3, 4, 5, 5, 5, 5, 6, 6};
        ListNode inputListNode = new ListNode(arr);
        DeleteDuplicates obj = new DeleteDuplicates();
        System.out.println(obj.deleteDuplicates(inputListNode));
    }
}
