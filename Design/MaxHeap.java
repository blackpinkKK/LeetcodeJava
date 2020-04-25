/**
 * 自己实现的最大堆
 */

package LeetcodeJava.Design;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap<E extends Comparable<E>> {
    private ArrayList<E> heap;

    //constructor
    public MaxHeap(int capacity){
        heap = new ArrayList<>(capacity);
    }
    public MaxHeap(E[] arr){
        heap = new ArrayList<E>(Arrays.asList(arr));

        int i = parent(heap.size()-1);
        while(i >= 0){
            siftDown(i);
            i--;
        }
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    //left_child
    public int leftChild(int i){
        return 2 * i + 1;
    }
    //right_child
    public int rightChild(int i){
        return 2 * i + 2;
    }
    //parent
    public int parent(int i){
        return (i-1)/2;
    }

    //swap
    public void swap(int i, int j){
        E tmp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,tmp);
    }
    //findMax

    //popMax
    public E popMax(){
        E ret = heap.get(0);

        swap(0,heap.size()-1);
        heap.remove(heap.size()-1);
        siftDown(0);
        return ret;
    }

    //push
    public void push(E element){
        heap.add(element);
        int i = heap.size()-1;
        while (i > 0){
            //找到它的parent
            int parentIndex = parent(i);
            //判断是否需要swap
            if(heap.get(i).compareTo(heap.get(parentIndex)) > 0){
                //如果i比parent大，则向上swap
                swap(i,parentIndex);
                //并且将i设为parentIndex，以方便下一轮上探
                i = parentIndex;
            }else {
                break;
            }
        }
    }
    //sift_down
    public void siftDown(int i){
        while(i < heap.size()){
            int leftIndex = leftChild(i);
            //先与左节点对比
            if (leftIndex < heap.size() && heap.get(i).compareTo(heap.get(leftIndex)) < 0){
                //若小于左结点，需要下移，判断与左还是右节点交换
                if(leftIndex+1 < heap.size() && heap.get(leftIndex).compareTo(heap.get(leftIndex+1)) < 0){
                    //若左节点小于右节点，则与右节点交换
                    swap(leftIndex+1,i);
                    i = leftIndex + 1;
                }else{
                    //否则与左结点交换
                    swap(leftIndex,i);
                    i = leftIndex;
                }
            }else{
                //若大于左结点，则与右节点比较
                if (leftIndex+1 < heap.size() && heap.get(i).compareTo(heap.get(leftIndex+1)) < 0){
                    //若i节点小于右节点，则与右节点交换
                    swap(leftIndex+1,i);
                    i = leftIndex + 1;
                }else{
                    //否则结束，停止下移
                    break;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "MaxHeap{" +
                "heap=" + heap +
                '}';
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{27,5,18,43,34};
//        for(int n:nums){
//            h.push(n);
//        }
        MaxHeap<Integer> h = new MaxHeap(new Integer[]{27,5,18,43,34});
        System.out.println(h.toString());

        System.out.println(h.popMax());
        System.out.println(h.popMax());
        System.out.println(h.popMax());

        int[] nums2 = new int[]{12,37,42,68,47,1,23};
        for(int n:nums2){
            h.push(n);
        }
        System.out.println(h.toString());
        System.out.println(h.popMax());
        System.out.println(h.popMax());
        System.out.println(h.popMax());
        System.out.println(h.toString());

    }
}
