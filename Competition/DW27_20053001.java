/**
 * 双周赛27-2020-05-30 第1题 1460. 通过翻转子数组使两个数组相等
 */

package LeetcodeJava.Competition;

import java.util.Arrays;

public class DW27_20053001 {
    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
//        int[] target = {3,7,9};
//        int[] arr = {3,7,11};
        DW27_20053001 obj = new DW27_20053001();
        System.out.println(obj.canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for(int i=0;i<target.length;i++){
            if(target[i]!=arr[i]) return false;
        }

        return true;
    }

}
