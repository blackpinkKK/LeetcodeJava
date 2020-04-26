/**
 * 1171. 从链表中删去总和值为零的连续节点
 * Definition for singly-linked list.
 * public class LeetcodeJava.ListNode {
 *     int val;
 *     LeetcodeJava.ListNode next;
 *     LeetcodeJava.ListNode(int x) { val = x; }
 * }
 */


package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

import java.util.HashMap;

public class RemoveZeroSumSublists {
    public ListNode removeZeroSumSublists(ListNode head) {
//        if (head == null){
//            return head;
//        }
//
//        HashMap<Integer,LeetcodeJava.ListNode> map = new HashMap<>();
//
//        LeetcodeJava.ListNode curr = head;
//        Integer sum = 0;
//        //先遍历一次记录所有前缀和，后面的覆盖前面的
//        while( curr != null){
//            sum += curr.val;
//            map.put(sum,curr);
////            System.out.println(sum);
//            curr = curr.next;
//            if(sum==0){
//                head = curr;
//                map.clear();
//                continue;
//            }
//        }
//
//        //再次遍历除了最后一个，将前面所有重复项之间的去掉
//        curr = head;
//        sum = 0;
//        while(curr != null){
//            sum += curr.val;
//            if (map.containsKey(sum)){
//                //删除下一个节点到记录的该节点之间
//                LeetcodeJava.ListNode last = map.get(sum);
//                if (!last.equals(curr)){
//                    curr.next = last.next;
//                    System.out.println(curr.val);
//                }
//            }
//            curr = curr.next;
//
//        }
//
//        return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();

        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点
        int sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{0};
        ListNode inputListNode = new ListNode(arr);
        RemoveZeroSumSublists r = new RemoveZeroSumSublists();
        ListNode solution = r.removeZeroSumSublists(inputListNode);
        System.out.println(solution);
    }
}
