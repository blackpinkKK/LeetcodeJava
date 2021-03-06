/**
 * 237.删除链表中的节点(给定的参数就是要删除的节点)
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next=node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1};
        ListNode inputListNode = new ListNode(arr);
        DeleteNode obj = new DeleteNode();
        obj.deleteNode(inputListNode);
        System.out.println(inputListNode);
    }
}
