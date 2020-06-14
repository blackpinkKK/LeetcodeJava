/**
 * 225. 用队列实现栈
 */

package LeetcodeJava.utils;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
    	if(!popQueue.isEmpty()){
    		pushQueue.offer(popQueue.poll());
		}
        pushQueue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        this.top();
        return popQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!popQueue.isEmpty()) {
            return popQueue.peek();
        }
        while(pushQueue.size()>1) {
            popQueue.offer(pushQueue.poll());
        }
        Queue<Integer> tmp = pushQueue;
        pushQueue = popQueue;
        popQueue = tmp;

        return popQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (popQueue.isEmpty() && pushQueue.isEmpty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        MyStack obj = new MyStack();
        for (int n : nums) {
            obj.push(n);
        }
        System.out.println(obj.top());
        obj.push(3);
        System.out.println(obj.top());
//        System.out.println(obj.pop());
//		System.out.println(obj.pop());
//		System.out.println(obj.pop());
//		System.out.println(obj.empty());

    }

}