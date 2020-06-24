/**
 * 215. 数组中的第K个最大元素
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class FindKthLargest {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {3,2,3,1,2,4,5,5,6};
        FindKthLargest obj = new FindKthLargest();
        System.out.println(obj.findKthLargest(arr, k));
    }


//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> minHeap = new PriorityQueue<>(k);
//        for (int i : nums) {
//            minHeap.offer(i);
//        }
//        System.out.println(minHeap);
//        while (minHeap.size() > k) minHeap.poll();
//        return minHeap.peek();
//    }

    List<Integer> heap;

    public int findKthLargest(int[] nums, int k) {
        heap = new ArrayList<>();
        for (int i : nums) {
            heap.add(i);
        }
        int index = (nums.length - 1) / 2;
        for (int i = index; i >= 0; i--) {
            siftdown(i);
        }
        while (heap.size() > k) pop();
        return heap.get(0);
    }

    public int pop() {
        int minVal = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size()-1);
        siftdown(0);
        return minVal;
    }

    public void siftdown(int i) {
        //判断是否小于子节点，是的话要下移
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < heap.size() && heap.get(i) > heap.get(left)) {
            if (right < heap.size() &&heap.get(left) > heap.get(right)) {
                swap(i, right);
                siftdown(right);
            } else {
                swap(i, left);
                siftdown(left);
            }
        } else if (right < heap.size() &&heap.get(i) > heap.get(right)) {
            swap(i, right);
            siftdown(right);
        }
    }

    public void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
