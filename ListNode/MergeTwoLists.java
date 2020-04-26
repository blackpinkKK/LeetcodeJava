/**
 * 21. 合并2个排序链表
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head, curr;
        if(l1.val <= l2.val){
            curr = l1;
            l1 = l1.next;
        }else{
            curr = l2;
            l2 = l2.next;
        }
        head = curr;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 == null){
            curr.next = l2;
        }
        if(l2 == null){
            curr.next = l1;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{0,1,2,4,7,9});
        ListNode l2 = new ListNode(new int[]{1,3,4,7});

        MergeTwoLists m = new MergeTwoLists();
        ListNode solution = m.mergeTwoLists(l1, l2);
        System.out.println(solution.toString());
    }
}
