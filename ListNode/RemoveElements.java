/**
 * 203. 移除链表元素
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
//        int[] arr = {4,2,6,3,4,5,6,7,3,4,4,4,4};
        ListNode inputListNode = new ListNode(arr);
        RemoveElements obj = new RemoveElements();
        System.out.println(obj.removeElements(inputListNode, 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node.next!= null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }else{
                node=node.next;
            }
        }
        return dummy.next;
    }
}
