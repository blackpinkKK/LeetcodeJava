/**
 * 23. 合并K个排序链表
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists){
        int length = lists.length;
        if(lists == null || length ==0) return null;
        if(length == 1) return lists[0];

        ListNode head;
        if(length == 2){
            head = mergeTwoLists(lists[0],lists[1]);
        }else {
            //2个以上的链表拆分成k组，递归
            int group = length/2;
            int rest = length%2;
            ListNode[] newList;
            if(rest ==1){
                newList = new ListNode[group+1];
            }else{
                newList = new ListNode[group];
            }

            for(int i=0;i < group;i++){
                newList[i]=mergeTwoLists(lists[2*i],lists[2*i+1]);
            }
            if(rest == 1){
                newList[group] = lists[length-1];
            }
            head = mergeKLists(newList);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        //2个链表合并
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
        int[][] arr = new int[][]{{1,4,5},{1,3,4},{2,6},{0,8}};
//        int[][] arr = new int[][]{{1,4,5},{1,3,4}};
        ListNode[] lists = new ListNode[arr.length];
        for(int i = 0; i < arr.length; i++){
            lists[i]=new ListNode(arr[i]);
        }
        MergeKLists m = new MergeKLists();
        ListNode solution = m.mergeKLists(lists);
        System.out.println(solution);
    }
}
