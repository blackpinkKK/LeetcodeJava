/**
 * 232. 用栈实现队列
 */

package LeetcodeJava.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    Deque<Integer> pushStack;
    Deque<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (popStack.isEmpty() && pushStack.isEmpty())
            return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        MyQueue obj = new MyQueue();
        for (int n : nums) {
            obj.push(n);
        }
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.empty());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
//        System.out.println(obj.pop());
//		System.out.println(obj.pop());
//		System.out.println(obj.pop());
//		System.out.println(obj.empty());

    }

}