/**
 * 1290.将01二进制链表转换为十进制数
 */

package LeetcodeJava.ListNode;

import LeetcodeJava.utils.ListNode;

class GetDecimalValue {
    public int getDecimalValue(ListNode head) {
    	int num = 0;
    	ListNode curr = head;
    	while(curr != null){
    		if (curr.val == 1){
	    		num =  num * 2 + 1;
    		}
    		else{
    			num = num * 2;
    		}
    		curr=curr.next;
    	}
    	return num;
    }

    public static void main(String[] args) {
	int[] arr = new int[]{0,0};
	ListNode inputListNode = new ListNode(arr);
	GetDecimalValue g = new GetDecimalValue();
	int solution = g.getDecimalValue(inputListNode);
	System.out.println(solution);
	}
}