/**
 * 1143. 最长公共子序列
 * 392. 判断子序列
 * 792. 匹配子序列的单词数
 * 115. 不同的子序列
 * 940. 不同的子序列 II
 */

package LeetcodeJava.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subsequence {
    /**
     *1143. 最长公共子序列
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(),n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        dp[0][0] = 0;
        for(int i = 1; i <= n1;i++) {
            for (int j = 1; j <= n2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n1][n2];
    }

    /**
     * 392. 判断子序列
     */
    public boolean isSubsequence(String s, String t) {
//        //普通版本
//        if(s==null) return false;
//        if(s.length()==0) return true;
//        int n1 = s.length(),n2 = t.length();
//        int i,j;
//        i=j=0;
//        while(i<n1 && j<n2){
//            if(s.charAt(i) == t.charAt(j)){
//                i++;
//                j++;
//            }else{
//                j++;
//            }
//        }
//        return i == n1 && s.charAt(i - 1) == t.charAt(j - 1);

        //t不长，大量短子串s需要进行判断时，高效版本
        if(s==null || t==null) return false;
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        int n1 = s.length(),n2 = t.length();
        //构建 n2x26 的矩阵来存放每个位置下一次出现对应字母的位置
        int[][] pos = new int[n2][26];
        for (char c='a'; c < 'z'; c++) {
            int nextPos = -1;
            for( int i = n2-1; i >= 0; i--) {
                pos[i][c - 'a'] = nextPos;
                if (t.charAt(i) == c) {
                    nextPos = i;
                }
            }
        }
        int next=0;
        if(s.charAt(0)==t.charAt(0))
            next = 1;
        for(int i = next; i<n1;i++){
           next = pos[next][s.charAt(i)-'a'];
           if (next == -1) return false;
        }

        return true;
    }

    /**
     * 792. 匹配子序列的单词数
     * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
     *
     * 所有在words和 S 里的单词都只由小写字母组成。
     * S 的长度在 [1, 50000]。
     * words 的长度在 [1, 5000]。
     * words[i]的长度在[1, 50]。
     */
    public int numMatchingSubseq(String S, String[] words) {
        //大量words，S很长，无法构建 ns x 26 的矩阵
        int ns = S.length();
        //构建 map 来存放每个字母在长串 t 中出现的所有位置
        Map<Character, List<Integer>> map = new HashMap<>() ;
        for(char c='a'; c <= 'z'; c++){
            List<Integer> list = new ArrayList<>();
            map.put(c,list);
        }

        for( int i = 0; i < ns; i++) {
            map.get(S.charAt(i)).add(i);
        }
        int count = words.length;
        for(String word:words){
            int lastPos = -1;
            int lastCount = count;
            for(char c:word.toCharArray()){
                List<Integer> l = map.get(c);
                //在 map 的 value（字母出现位置） 中寻找在lastPos后面出现的字母，如果最后找不到说明不匹配
//                int i=0;
//                while(i<l.size()){
//                    int pos = l.get(i);
//                    if (pos > lastPos){
//                        lastPos = pos;
//                        break;
//                    }
//                    i++;
//                }
//                if(i>=l.size()) {
//                    count--;
//                    break;
//                }
                //搜索的过程使用二分
                int begin = 0, end = l.size()-1;
                if(end<0){
                    count--;
                    break;
                }

                //寻找字符 c 的下一个位置
                while(begin <= end){
                    if(begin==end){
                        if(l.get(begin) > lastPos){
                            lastPos = l.get(begin);
                            break;
                        }
                        else{
                            count--;
                            break;
                        }
                    }
                    //只剩两个数时，直接与 lastPos 比较
                    if((end-begin)<2){
                        int pos = l.get(begin);
                        if(pos>lastPos){
                            lastPos = pos;
                            break;
                        }else{
                            pos = l.get(end);
                            if(pos>lastPos) {
                                lastPos = pos;
                                break;
                            }else{
                                count--;
                                break;
                            }
                        }
                    }

                    int mid = (begin+end)/2;
                    int pos = l.get(mid);
                    if (pos < lastPos){
                        //假如 pos 在 lastPos 之前，二分往后继续查找
                        begin = mid+1;
                    }else if(pos==lastPos){
                        // 假如找到的 pos 跟 lastPos 相等，说明这个单词跟上个单词一样，
                        // 并且在他之后的下一次出现位置是 l.get(mid+1)，检查 mid+1 是否合法位置
                        // 一定是合法的，因为 begin <= mid <end
                        lastPos = l.get(mid+1);
                        break;
                    }else{
                        // 假如pos > lastPos+1,那么可能要找的数在 pos 或者 pos 之前的位置
                        end = mid;
                    }
                }

                if(lastCount != count) {
                    break;
                }

            }
//            if(lastCount == count) System.out.println(word);

        }

        return count;
    }

    /**
     * 115. 不同的子序列
     * s 包含多少个等于 t 的子序列
     */
    public int numDistinct(String s, String t) {
        //二维dp
        int n1 = s.length(), n2 = t.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i<= n1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<= n2; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<= n1; i++){
            for(int j = 1; j<= n2; j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
//                System.out.printf("%d, %d: %d\n",i,j,dp[i][j]);
            }
        }
        return dp[n1][n2];

    }

    /**
     * 940. 不同的子序列 II
     * s 包含多少个不同子序列
     */
    public int distinctSubseqII(String S) {
        int n = S.length();
        int[] dp = new int[n+1];
        int mod = 1000000007;
        Map<Character,Integer> map = new HashMap<>();
        for(char c='a';c <= 'z';c++){
            map.put(c,-1);
        }
        //base状态

        //
        for(int i = 1; i <= n; i++){
            if(i==1){
                dp[1] = 1;
                map.put(S.charAt(i-1),i);
                continue;
            }
            if(map.get(S.charAt(i-1))<0){
                dp[i] = 2 * dp[i-1] + 1;
            }else{
                dp[i] = 2 * dp[i-1]  - dp[map.get(S.charAt(i-1))-1];
            }
//            System.out.printf("dp%d: %d\n",i,dp[i]);
            dp[i]%=mod;
            // 由于每轮有 取模 这个操作，可能导致 dp[i] = 2 * dp[i-1]  - dp[map.get(S.charAt(i-1))-1]
            // 求出来是负数，此时应该加上 mod
            if(dp[i]<0) {
                System.out.printf("Before-----dp%d: %d\n",i,dp[i]);
                dp[i]+= mod;
                System.out.printf("After-----dp%d: %d\n",i,dp[i]);

            }
            map.replace(S.charAt(i-1),i);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Subsequence obj = new Subsequence();
//        //1143. 最长公共子序列
//        String text1 = "a", text2 = "";
//        System.out.println(obj.longestCommonSubsequence(text1,text2));

        //392. 判断子序列
//        String s = "b", t = "c";
//        System.out.println(obj.isSubsequence(s,t));

//        //792. 匹配子序列的单词数
//        String S = "abcde";
//        String[] words = new String[]{"abcdee", "bbb", "acd", "ace"};//2
//        String S = "btovxbkumc";
//        String[] words = new String[]{"btovxbku","to","zueoxxxjme","yjkclbkbtl"};//2
//        System.out.println(obj.numMatchingSubseq(S,words));

        //115. 不同的子序列
//        String s = "rabbbit", t = "rabbit";
////        String s = "babgbag", t = "bag";
//        System.out.println(obj.numDistinct(s,t));

        //940. 不同的子序列 II
        String s = "zchmliaqdgvwncfatcfivphddpzjkgyygueikthqzyeeiebczqbqhdytkoawkehkbizdmcnilcjjlpoeoqqoqpswtqdpvszfaksn";
        System.out.println(obj.distinctSubseqII(s));

    }
}
