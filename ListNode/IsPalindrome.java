/**
 * 234. 回文链表
 *
 * public class LeetcodeJava.ListNode {
 * int val;
 * LeetcodeJava.ListNode next;
 * LeetcodeJava.ListNode(int x) { val = x; }
 * }
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

import java.util.Stack;


public class IsPalindrome {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1,1, 1};
        ListNode inputListNode = new ListNode(arr);
        IsPalindrome obj = new IsPalindrome();
        System.out.println(obj.isPalindrome(inputListNode));
    }

    //1. 用栈将前半段链表存起来
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) return true;
//        if(head.next.next==null){
//            return (head.val == head.next.val);
//        }
//
//        Stack<ListNode> listNodeStack = new Stack<>();
//        ListNode fast = head;
//        ListNode slow = head;
//        listNodeStack.push(slow);
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//            listNodeStack.push(slow);
//        }
//        //slow 是中点
//        if (fast.next == null) {
//            // 如果节点数为 奇数， 需要先把中点 pop 出去
//            listNodeStack.pop();
//        }
//        while (slow.next != null) {
//            if (slow.next.val != listNodeStack.pop().val) return false;
//            slow = slow.next;
//        }
//        return true;
//    }

    //将前半段链表进行翻转
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) {
            return (head.val == head.next.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode middle = null;
        while (fast!= null && fast.next!= null) {
            fast = fast.next.next;
            ListNode tmp = slow;
            slow =slow.next;
            tmp.next = middle;
            middle = tmp;
        }
        System.out.println(slow + " "+middle);
        //middle 是左半段的起点, slow 是右半段的起点
        if (fast != null) {
            // 如果节点数为 奇数，则 fast 指向链表最后一个节点，此时 slow 指向中点
            // 需要先把右半段第一个节点跳过
            slow = slow.next;
        }
        while (slow != null && middle!=null) {
            if (slow.val != middle.val) return false;
            slow = slow.next;
            middle = middle.next;
        }
        return true;
    }
}