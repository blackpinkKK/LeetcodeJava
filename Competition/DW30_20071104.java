/**
 * 双周赛30-2020-07-11 第4题 1510. 石子游戏 IV
 */

package LeetcodeJava.Competition;

import java.util.ArrayList;
import java.util.List;

public class DW30_20071104 {
    public static void main(String[] args) {
        int n = 8359;
        DW30_20071104 obj = new DW30_20071104();
        System.out.println(obj.winnerSquareGame(n));
    }

    //    public boolean winnerSquareGame(int n) {
//        int ceil = (int) Math.sqrt(n);
//        int sub = n - ceil * ceil;
//        if (sub == 0) return true;
//        boolean canWin = false;
//        while (!canWin && ceil > 0) {
//            canWin = !winnerSquareGame(sub);
//            ceil--;
//            sub = n - ceil * ceil;
//        }
//        return ceil > 0 || canWin;
//    }
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j * j + i <= n; j++) {
                if(!dp[i]){
                    dp[j*j+i] = true;
                }
            }
        }

        return dp[n];
    }
}
