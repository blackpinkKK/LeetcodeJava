

package LeetcodeJava.DynamicProgramming;

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

        //大量短子串s需要进行判断时，高效版本
        if(s==null || t==null) return false;
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        int n1 = s.length(),n2 = t.length();
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

    public static void main(String[] args) {
        Subsequence obj = new Subsequence();
//        String text1 = "a", text2 = "";
//        System.out.println(obj.longestCommonSubsequence(text1,text2));
        String s = "b", t = "c";
        System.out.println(obj.isSubsequence(s,t));
    }
}
