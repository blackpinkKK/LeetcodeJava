/**
 * 328. 奇偶链表
 * 把奇数节点和偶数节点分别排在一起。奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 用原地算法完成。空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 应当保持奇数节点和偶数节点的相对顺序。
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = new ListNode(0);
        ListNode oddCurr = odd;
        ListNode even = new ListNode(0);
        ListNode evenCurr = even;
        while (head!=null&&head.next!= null) {
            oddCurr.next = head;
            oddCurr=oddCurr.next;
            evenCurr.next = head.next;
            evenCurr=evenCurr.next;
            head=head.next.next;
        }
        if(head!=null){
            oddCurr.next = head;
            oddCurr=oddCurr.next;
            evenCurr.next=null;
        }
        oddCurr.next=even.next;
        return odd.next;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{  1, 2, 3, 4, 5};
        int[] arr = new int[]{  2, 1, 3, 5, 6,4,7};
        ListNode inputListNode = new ListNode(arr);
        OddEvenList obj = new OddEvenList();
        System.out.println(obj.oddEvenList(inputListNode));
    }
}
