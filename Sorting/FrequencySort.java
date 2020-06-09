/**
 * 451. 根据字符出现频率排序
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        String s = "";
        FrequencySort obj = new FrequencySort();
        System.out.println(obj.frequencySort(s));
    }

    //优先队列
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        Queue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }

        StringBuilder ans = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            for (int i = 0; i < entry.getValue(); i++)
                ans.append(entry.getKey());
        }
        return ans.toString();
    }

    //使用Collection的排序
//    public String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }
//        }
//
//        List<Map.Entry<Character,Integer>> list = new ArrayList(map.entrySet());
//        System.out.println(list);
//        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
//                return o1.getValue() - o2.getValue();
//            }
//        });
//        System.out.println(list);
//        StringBuilder ans = new StringBuilder();
//        for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
//            for (int j = 0; j < characterIntegerEntry.getValue(); j++)
//                ans.insert(0, characterIntegerEntry.getKey());
//        }
//        return ans.toString();
//    }
//

    //自定义快排
//    public String frequencySort(String s) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            if (!map.containsKey(c)) {
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }
//        }
//
//        char[] chars = new char[map.keySet().size()];
//        int i=0;
//        for(Character c:map.keySet()){
//            chars[i] =c;
//            i++;
//        }
//        //按出现频率给字母进行排序
//        quickSort(chars, 0, chars.length - 1, map);
//
//        StringBuilder ans = new StringBuilder();
//        for(i=0;i<chars.length;i++){
//            for(int j =0;j<map.get(chars[i]);j++)
//                ans.insert(0,chars[i]);
//        }
//
//        return ans.toString();
//    }
//
//    public void quickSort(char[] chars, int begin, int end, Map<Character, Integer> map) {
//        if (begin < end) {
//            int i = partition(chars, begin, end, map);
//            quickSort(chars, begin, i - 1, map);
//            quickSort(chars, i + 1, end, map);
//        }
//    }
//
//    public int partition(char[] chars, int begin, int end, Map<Character, Integer> map) {
//        char pivot = chars[begin];
//        int i = begin, j = end;
//        while (i < j) {
//            while (i < j && map.get(chars[j]) >= map.get(pivot))
//                --j;
//            while (i < j && map.get(chars[i]) <= map.get(pivot))
//                ++i;
//            if (i != j) {
//                swap(chars, i, j);
//            }
//        }
//        swap(chars, i, begin);
//        return i;
//    }
//
//    public void swap(char[] chars, int i, int j) {
//        char tmp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = tmp;
//    }
}
