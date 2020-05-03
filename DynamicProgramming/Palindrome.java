package LeetcodeJava.DynamicProgramming;

public class Palindrome {
    /**
     * 516. 最长回文子序列
     * dp二维画表
     * */
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.length()==0) return 0;

        int n =s.length();
        int[][] dp = new int[n][n];

        for(int j = 0; j < n; j++){
            dp[j][j] = 1;
            for(int i = j-1; i>=0;i--){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    /**
     * 647. 回文子串
     *
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
     * */
    public int countSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length() == 1) return 1;

        int n =s.length();
        int count = 0;
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++){
            dp[j][j] = true;
            count++;

            for (int i = j-1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || (j - i) < 2)) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 5. 最长回文子串
     *
     */
    public String longestPalindrome(String s) {if(s==null || s.length()==0) return "";
        //二维 dp
        if(s==null || s.length()==0) return "";
        if(s.length() == 1) return s;

        int n =s.length();
        int maxLen = 0;
        boolean[][] dp = new boolean[n][n];
        int begin=0,end=0;

        for (int j = 0; j < n; j++){
            dp[j][j] = true;

            for (int i = j-1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || (j - i) < 2)) {
                    dp[i][j] = true;
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(begin,end+1);

    }


    public static void main(String[] args) {
        Palindrome obj = new Palindrome();

//        String s = "cbbd";
//        System.out.println(obj.longestPalindromeSubseq(s));

//        String s = "abc";
//        String s = "abcbd";
//        String s = "bbccaacacdbdbcbcbbbcbadcbdddbabaddbcadb";
//        System.out.println(obj.countSubstrings(s));

//        String s="ababad";
        String s="cbbddddbb";
//      String s="0123456789";
        System.out.println(obj.longestPalindrome(s));




    }
}
