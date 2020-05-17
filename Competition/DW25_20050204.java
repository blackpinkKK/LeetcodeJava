/**
 * 双周赛25-2020-05-02 第4题 1434. 每个人戴不同帽子的方案数
 * 人数 1 <= n <= 10
 */

package LeetcodeJava.Competition;

import java.util.ArrayList;
import java.util.List;

public class DW25_20050204 {
    /*
    //DFS+BackTrace 不mod会超时
    //好吧 mod 了也超时QAQ
    int max_K = 40;
    boolean[] used = new boolean[max_K];
    int count = 0;
    int mod = (int)1e9+7;

    void backTrace(int p, List<List<Integer>> hats){
        if(p==hats.size()-1){
            //最后一人，判断是否可行方案
            for (int l:hats.get(p)){
                if(used[l-1]){
                    count++;
                    count%=mod;
                }
            }
            return;
        }

        for (int l:hats.get(p)){
            if(used[l-1]){
                used[l-1] = false;
            }else{
                continue;
            }
            backTrace(p+1,hats);
            used[l-1] = true;
        }
    }

    int numberWays(List<List<Integer>> hats) {
        for (int i = 0; i < max_K; i++){
            used[i] = true;
        }
        backTrace(0,hats);
        return count;
    }
*/
    //dp状态压缩，把一个状态压缩成一个符号（例如n位的二进制数）
    //由于人数 1 <= n <= 10 ，而帽子数 1 <= hats[i].length <= 40，所以 人数 维度较小
    //对人进行状态压缩，需要把 每个人可以戴的帽子 转换为 每个帽子可以匹配的人
    int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int max_K = 40;
        int status = 1<<n;
        int[] dp = new int[status];
        dp[0] = 1;
        int mod = (int)1e9+7;

//        List<List<Integer>> persons = new ArrayList<>();
        ArrayList<Integer>[] htp = new ArrayList[max_K];
        for (int i = 0; i < max_K; i++){
            htp[i] = new ArrayList<>();
        }
        //把 每个人可以戴的帽子 转换为 每个帽子可以匹配的人
        for(int i = 0; i < n; i++){
            for (int h:hats.get(i)){
                htp[h-1].add(i);
            }
        }

        for (int k = 0; k < max_K; ++k){ // 遍历每个帽子
            for (int i = status - 1; i >= 0; i--) { // 熟悉的0-1背包循环
                for (Integer person: htp[k]) {
                    // 遍历当前帽子可以分配的人，如果他头上有帽子，那么我们可以把他的帽子取下来，相当于将物品从背包里拿出
                    int personbit = (1 << person); //personbit代表person戴帽子这一种情况，如"1000"代表第四个人戴帽子
                    //检查当前状态下person是否可以持有帽子，若可以的话 (i & personbit) > 0
                    if ((i & personbit)!=0) {
                        //当前状态下，person已有戴帽子，应该再加上他在没有帽子状态下的方案数
                        dp[i] += dp[i - personbit];
                        dp[i] %= mod;
                    }
                }
            }
        }
        return dp[status-1];


    }

    public static void main(String[] args) {
        String hatsStr = "[3,4],[4,5],[5]";
//        String hatsStr = "[3,5,1],[3,5]";
//        String hatsStr = "[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]";
//        String hatsStr = "[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]";
//        String hatsStr = "[1,2,4,6,7,8,9,11,12,13,14,15,16,18,19,20,23,24,25],[2,5,16],[1,4,5,6,7,8,9,12,15,16,17,19,21,22,24,25],[1,3,6,8,11,12,13,16,17,19,20,22,24,25],[11,12,14,16,18,24],[2,3,4,5,7,8,13,14,15,17,18,21,24],[1,2,6,7,10,11,13,14,16,18,19,21,23],[1,3,6,7,8,9,10,11,12,14,15,16,18,20,21,22,23,24,25],[2,3,4,6,7,10,12,14,15,16,17,21,22,23,24,25]";
        List<List<Integer>> hats = new ArrayList<>();
        List<Integer> l = null;
        int last = 0;
        for(char c:hatsStr.toCharArray()){
            if(c=='['){
                l = new ArrayList<>();
                last = 0;
                continue;
            }
            if(c==','){
                if(last>0){
                    l.add(last);
                    last = 0;
                }
                continue;
            }
            if (c==']'){
                assert l != null;
                l.add(last);
                last = 0;
                hats.add(l);
                continue;
            }
            if(l!=null){
                last=last*10+(c-'0');
            }
        }

        for(List li:hats){
            System.out.println(li);
        }
        DW25_20050204 obj = new DW25_20050204();
        int solution = obj.numberWays(hats);
        System.out.println(solution);
    }
}
