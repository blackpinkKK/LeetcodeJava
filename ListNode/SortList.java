/**
 * 148. 排序链表
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

import java.util.*;


public class SortList {
    public static void main(String[] args) {
//        int[] arr = new int[]{4, 2, 1, 3};
        int[] arr = new int[]{-1, 5, 3, 4, 0};
        ListNode inputListNode = new ListNode(arr);
        SortList mNode = new SortList();
        ListNode solution = mNode.sortList(inputListNode);
        System.out.println(solution);
    }
    //效率较低，勉强通过 --------- 708 ms	43.6 MB
//    public ListNode sortList(ListNode head) {
//    	if (head == null || head.next == null){
//    		return head;
//    	}
//    	ListNode smallerList = null;
//    	ListNode smallerListHead = null;
//    	ListNode biggerList =null;
//    	ListNode biggerListHead =null;
//
//		ListNode root=head;
//
//    	//对于比root小的节点，加入第一个链表,对于比root大的节点，加入第二个队列
//		while (head.next!=null){
//			ListNode tmp = head.next;
//			head.next=head.next.next;
//			if(tmp.val<root.val){
//				if(smallerList==null){
//					smallerList=tmp;
//					smallerListHead = smallerList;
//				}else{
//					smallerList.next=tmp;
//					smallerList = smallerList.next;
//				}
//			}else{
//				if(biggerList==null){
//					biggerList = tmp;
//					biggerListHead = biggerList;
//				}else{
//					biggerList.next=tmp;
//					biggerList = biggerList.next;
//				}
//			}
//		}
//
//		//收尾，防止两个链表末端相连
//		if (smallerList!=null) smallerList.next=null;
//		if (biggerList!=null) biggerList.next=null;
//
//		//将第一个链表里的节点进行排序
//		smallerListHead=sortList(smallerListHead);
//		if (smallerList==null) {
//			root.next=sortList(biggerListHead);
//			return root;
//		}
//
//		//保存smallerListHead头结点
//		head = smallerListHead;
//
//		//获取第一个链表的最后一个节点，连接到root
//		while(smallerListHead.next!=null){
//			smallerListHead=smallerListHead.next;
//		}
//		smallerListHead.next=root;
//
//		//将第二个链表里的节点进行排序，将root连接到第二个链表
//		biggerListHead=sortList(biggerListHead);
//		root.next=biggerListHead;
//
//    	return head;
//    }


    //ArrayList.sort() --------- 11 ms	42 MB
//    public ListNode sortList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == null) {
//            return head;
//        }
//
//        List<ListNode> list = new ArrayList<>();
//        while (head != null) {
//            ListNode tmp = head;
//			head = head.next;
//			tmp.next = null;
//			list.add(tmp);
//        }
//        list.sort(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//		head = list.get(0);
//		ListNode aNode = head;
//		for (int i =1;i<list.size();i++) {
//			aNode.next = list.get(i);
//			aNode = aNode.next;
//		}
//
//        return head;
//    }

    //快慢指针+归并，最快 --------------- 4 ms	42.5 MB
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) break;
            slow = slow.next;
            fast = fast.next;
        }
        //中点是slow

        //如果只剩两个节点
        if (slow == head) {
            if (slow.val > fast.val) {
                slow.next = null;
                fast.next = slow;
                return fast;
            } else {
                fast.next = null;
                slow.next = fast;
                return slow;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        if (left.val < right.val) {
			tmp = left;
            left = left.next;
        } else {
			tmp = right;
            right = right.next;
        }
        head = tmp;

        while (left != null && right != null) {
            if (left.val < right.val) {
				tmp.next = left;
				left = left.next;
            }else {
            	tmp.next =right;
            	right = right.next;
			}
            tmp = tmp.next;
        }
        if(left!=null){
        	tmp.next = left;
		}else{
        	tmp.next=right;
		}

		return head;
    }
}