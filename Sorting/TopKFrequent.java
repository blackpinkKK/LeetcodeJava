/**
 * 347. 前 K 个高频元素
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {1,1,1,2,2,3,7,7,7,7,7,7,7,7,7,7,5,5,5,5,5};
        TopKFrequent obj = new TopKFrequent();
        System.out.println(Arrays.toString(obj.topKFrequent(arr, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
//        System.out.println("map:"+map);
        Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(k, (o1, o2) -> o1.getValue()-o2.getValue());

        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            heap.offer(e);
            if(heap.size()>k) heap.poll();
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = heap.poll().getKey();
        }

        return ans;
    }

}
