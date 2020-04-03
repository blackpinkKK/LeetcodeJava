/**
  876.寻找链表的中间节点

  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 */

package LeetcodeJava;

import LeetcodeJava.utils.ListNode;


public class MiddleNode {
    public ListNode middleNode(ListNode head) {
    	if (head == null){
    		return null;
    	}

    	ListNode p1=head;
    	ListNode p2=head;

    	while (p1 != null && p1.next != null){
    		p1=p1.next.next;
    		p2=p2.next;
    	}
    	return p2;
    }	

    public static void main(String[] args) {
    	int[] arr = new int[]{1,2,3,4,5};
    	ListNode inputListNode = new ListNode(arr);
    	MiddleNode mNode = new MiddleNode();
    	ListNode solution = mNode.middleNode(inputListNode);
    	System.out.println(solution);
    }
}