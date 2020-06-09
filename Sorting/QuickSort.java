package LeetcodeJava.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 1, 3, 4};
        QuickSort obj = new QuickSort();
        obj.quickSort(0, nums.length-1, nums);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int begin, int end, int[] nums) {

        if(begin<end){
            int i = partition(begin, end, nums);
            System.out.println("The partition point: "+i);
            quickSort(begin, i-1, nums);
            quickSort(i + 1, end, nums);
        }
    }

    public int partition(int begin, int end, int[] nums) {
        int pivot = nums[begin];
        int i = begin;
        int j = end;
        System.out.println(i+" "+j);
        while (i < j) {
            while (i < j && nums[j] >= pivot)
                j--;
            while (i < j && nums[i] <= pivot)
                i++;

            if (i != j) {
                swap(nums,i,j);

            }
        }
        swap(nums,begin,i);
        return i;
    }

    void swap(int[] nums,int i,int j ){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
