/**
 * 718. 最长重复子数组
 * */

package LeetcodeJava.DynamicProgramming;

public class FindLength {
    public int findLength(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        if (lengthA == 0 || lengthB == 0) return 0;

        int[][] dp = new int[lengthA][lengthB];
        int maxLength = 0;

        for (int i = 0; i < lengthA; i++){
            if(A[i] == B[0]) dp[i][0] = 1;
        }
        for (int j = 0; j < lengthB; j++){
            if(A[0] == B[j]) dp[0][j] = 1;
        }

        for (int i = 1; i < lengthA; i++){
            for (int j = 1; j < lengthB; j++){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLength) maxLength = dp[i][j];
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2,1,1,2};
        int[] A = new int[]{0,0,0,0,0};
        int[] B = new int[]{0,0,0,0,0};

        FindLength solution = new FindLength();
        int ans = solution.findLength(A,B);
        System.out.println(ans);
    }
}
