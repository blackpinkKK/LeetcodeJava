/**
 * 147. 对链表进行插入排序
 * <p>
 * Definition for singly-linked list.
 * public class LeetcodeJava.ListNode {
 * int val;
 * LeetcodeJava.ListNode next;
 * LeetcodeJava.ListNode(int x) { val = x; }
 * }
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;


public class InsertionSortList {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 3};
//        int[] arr = new int[]{-1, 5, 3, 4, 0};
        ListNode inputListNode = new ListNode(arr);
        InsertionSortList mNode = new InsertionSortList();
        ListNode solution = mNode.insertionSortList(inputListNode);
        System.out.println(solution);
    }

    public ListNode insertionSortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode tmp;
//        tmp = new ListNode(0);
//        tmp.next=head;
//        head = tmp;
//        ListNode prev;
//        ListNode node = head.next;
//        boolean inserted;
//
//        while (node!= null) {
//            prev = head;
//            inserted =false;
//            while (node.next!=null && prev.next != node.next) {
//                if (prev.next.val > node.next.val) {
//                    //将 node.next 插入到 prev.next 之前的位置
//                    tmp = prev.next;
//                    prev.next = node.next;
//
//                    node.next = node.next.next;
//                    prev.next.next = tmp;
//                    inserted = true;
//                    break;
//                }
//                prev = prev.next;
//            }
//            if(!inserted){
//                node = node.next;
//            }
//        }
//
//        return head.next;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int lastVal=Integer.MIN_VALUE;
        while(head!=null){
            if(lastVal!=Integer.MIN_VALUE){
                if (head.val<lastVal){
                    curr = dummy;
                }
            }
            if(curr.next==null||head.val<curr.next.val){
                ListNode tmp = head.next;
                head.next = curr.next;
                curr.next= head;
                lastVal = head.val;
                head = tmp;
            }else {
                lastVal=Integer.MIN_VALUE;
            }
            curr= curr.next;

        }
        return dummy.next;
    }
}