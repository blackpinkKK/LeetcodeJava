/**
 * 703. 数据流中的第K大元素
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(3);// returns 4
        kthLargest.add(5);// returns 5
        kthLargest.add(10); // returns 5
        kthLargest.add(9);// returns 8
        kthLargest.add(4);// returns 8
    }

    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        for (int i : nums) {
            minHeap.offer(i);
        }
        while (minHeap.size() > this.k) minHeap.poll();
    }

    public int add(int val) {
        if(minHeap.size()<this.k) minHeap.offer(val);
        else if (val > minHeap.peek()) {
            minHeap.offer(val);
            minHeap.poll();
        }
        return minHeap.peek();
    }

}
