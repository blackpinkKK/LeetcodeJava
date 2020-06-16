package LeetcodeJava.Array;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nums = {1, 8, -1, -100, -1, 222, 1111111, -111111};
        NextGreaterElement obj = new NextGreaterElement();
//        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
//        System.out.println(Arrays.toString(obj.nextGreaterElement2(nums)));
        System.out.println(obj.nextGreaterElement3(13));
    }

    /***
     * 496. 下一个更大元素 I
     * nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * 如果不存在，对应位置输出 -1
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int[] ans = new int[nums1.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            if (map.containsKey(nums2[i])) {
                ans[map.get(nums2[i])] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums2[i]);
        }
        return ans;
    }

    /***
     * 503. 下一个更大元素 II
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素）
     */
    public int[] nextGreaterElement2(int[] nums) {
        int[] ans = new int[nums.length];
        int maxNum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            maxNum = Math.max(maxNum, nums[i]);
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek();
            stack.push(nums[i]);
        }
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MIN_VALUE) {
                if (nums[i] == maxNum) {
                    ans[i] = -1;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break;
                    }
                }
                if (ans[i] == Integer.MIN_VALUE) {
                    ans[i] = -1;
                }
            }
        }
        return ans;
    }

    /***
     * 556. 下一个更大元素 III
     * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
     */
    public int nextGreaterElement3(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] < chars[i + 1]) {
                resort(chars, i);
                String ans = String.valueOf(chars);
                String maxValue = String.valueOf(Integer.MAX_VALUE);
                if (ans.length() < maxValue.length() || ans.compareTo(maxValue)<0){
//                    System.out.println(ans);
                    return Integer.parseInt(ans);
                }
            }
        }
        return -1;
    }

    public void resort(char[] chars, int index) {
        int ind = chars.length - 1;
        while (chars[ind] <= chars[index]) ind--;
        char tmp = chars[index];
        chars[index] = chars[ind];
        chars[ind] = tmp;
//        System.out.println(Arrays.toString(chars));
        Arrays.sort(chars, index + 1, chars.length);
    }
}
