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

    Queue<Integer> maxHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
        for (int i : nums) {
            maxHeap.offer(i);
        }
        while (maxHeap.size() > this.k) maxHeap.poll();
    }

    public int add(int val) {
        if(maxHeap.size()<this.k) maxHeap.offer(val);
        else if (val > maxHeap.peek()) {
            maxHeap.offer(val);
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}
