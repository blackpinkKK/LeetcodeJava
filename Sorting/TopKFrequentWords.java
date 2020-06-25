/**
 * 692. 前K个高频单词
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        int k = 2;
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 4;
//        String[] arr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        TopKFrequentWords obj = new TopKFrequentWords();
        System.out.println(obj.topKFrequent(arr, k));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue()) ?
                o2.getKey().compareTo(o1.getKey()) : o1.getValue().compareTo(o2.getValue()));

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            heap.offer(e);
            while(heap.size()>k) heap.poll();
        }
        System.out.println(heap);
        List<String> ans = new ArrayList<>();
        while(!heap.isEmpty()){
            ans.add(0,heap.poll().getKey());
        }
        return ans;
    }

}
