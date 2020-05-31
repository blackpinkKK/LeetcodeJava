/**
 * 双周赛27-2020-05-30 第3题 课程安排 IV
 */

package LeetcodeJava.Competition;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Array;
import java.util.*;

public class DW27_20053003 {
    public static void main(String[] args) {
        int n = 5;
//        int[][] prerequisites = {{1, 2}, {1, 0}, {2,0}};
//        int[][] queries = {{1, 0}, {1, 2},{3,0}};
        int[][] prerequisites = {{0, 1}, {1, 2}, {3, 4}, {2, 3}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};
//        int[][] prerequisites = {{1,0}, {2, 0}};
//        int[][] queries = {{0, 1}, {2, 0}};
        DW27_20053003 obj = new DW27_20053003();
        System.out.println(obj.checkIfPrerequisite(n, prerequisites, queries));
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] graph = new boolean[n][n];
        for (int[] p : prerequisites) {
            graph[p[0]][p[1]] = true;
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0;j<n;j++){
                if(graph[i][j]){
                    for(int k=0;k<n;k++){
                        if(graph[k][i]){
                            graph[k][j]=true;
                        }
                    }
                }
            }
        }
//        for(boolean[] g:graph){
//            System.out.println(Arrays.toString(g));
//        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q :queries){
            ans.add(graph[q[0]][q[1]]);
        }
        return  ans ;
    }


}
