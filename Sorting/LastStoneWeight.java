/**
 * 1046. 最后一块石头的重量
 */

package LeetcodeJava.Sorting;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums = {2};
        LastStoneWeight obj = new LastStoneWeight();
        System.out.println(obj.lastStoneWeight(nums));
    }

    public int lastStoneWeight(int[] stones) {
        if(stones==null || stones.length==0) return 0;
        Queue<Integer> maxHeap = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int s : stones) {
            maxHeap.add(s);
        }
        while(maxHeap.size()>=2){
            int tmp = maxHeap.poll() - maxHeap.poll();
            if(tmp!=0){
                maxHeap.offer(tmp);
            }
        }
       return maxHeap.isEmpty()?0:maxHeap.poll();
    }

}
