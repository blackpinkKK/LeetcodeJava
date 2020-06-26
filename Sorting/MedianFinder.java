/**
 * 295. 数据流的中位数
 */

package LeetcodeJava.Sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(4);
        System.out.println(obj.maxHeap);
        System.out.println(obj.minHeap);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.maxHeap);
        System.out.println(obj.minHeap);
        System.out.println(obj.findMedian());

    }

    //大顶堆用来存放 小于等于 中位数的数，小顶堆用来存放 大于等于 中位数的数
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) maxHeap.offer(num);

        else {
            if (num <= findMedian()) {
                maxHeap.offer(num);
                if (maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(num);
                if (minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(maxHeap.size() == 0 && minHeap.size()==0) return -1;
        if(maxHeap.size()== minHeap.size()) return (double)(maxHeap.peek()+ minHeap.peek())/2;
        else if(minHeap.size()> maxHeap.size()) return minHeap.peek();
        else return maxHeap.peek();
    }

}
