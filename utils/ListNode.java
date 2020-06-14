/**
 * 链表
 */

package LeetcodeJava.utils;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int[] nums) {
		if (nums == null || nums.length == 0){
			throw new IllegalArgumentException("Arr cannot be empty!");
		}
		this.val = nums[0];
		ListNode curr = this;
		for(int i = 1; i < nums.length; i++){
			curr.next = new ListNode(nums[i]);
			curr=curr.next;
		}
	}

//	public int getVal() {
//		return val;
//	}
//
//	public LeetcodeJava.ListNode getNext() {
//		return next;
//	}

	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		ListNode curr = this;
		while(curr != null){
			s.append(curr.val);
			s.append("->");
			curr=curr.next;
		}
		s.append("NULL");
		return s.toString();
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		ListNode node = new ListNode(nums);
		System.out.println(node.toString());
	}

}