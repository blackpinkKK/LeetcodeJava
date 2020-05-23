/**
 * 1329. 将矩阵按对角线排序
 */

package LeetcodeJava.Sorting;

import java.util.*;

public class DiagonalSort {
    public static void main(String[] args) {
        int[][] mat = {{3, 3, 1, 1}
                     , {2, 2, 1, 2}
                     , {1, 1, 1, 2}};
        DiagonalSort obj = new DiagonalSort();
        int[][] solution = obj.diagonalSort(mat);
        for(int i=0;i<solution.length;i++){
            System.out.println(Arrays.toString(solution[i]));
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        List<Integer>[] d = new ArrayList[m+n-1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int index = i-j+(n-1);
                if(d[index]==null) d[index]=new ArrayList<>();
                d[index].add(mat[i][j]);
            }
        }

        for (List<Integer> integers : d) {
            Collections.sort(integers);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int index = i-j+(n-1);
                mat[i][j]=d[index].get(0);
                d[index].remove(0);
            }
        }

        return mat;
    }

}
