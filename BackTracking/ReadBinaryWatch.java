/**
 * 401. 二进制手表
 */


package LeetcodeJava.BackTracking;

import com.sun.xml.internal.ws.api.server.AbstractInstanceResolver;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
    //1.递归回溯法
    //对10个位置进行 选 或 不选 的尝试，过程中进行预剪枝。
    //剪枝包含2种情况：
    //(1)数据不合法 (2)亮灯数大于剩下可选位置数
    //当使用完亮灯数时，即可将结果添加到列表里。
    void backTracking(int i, int num, int hour, int minute, List<String> ans) {
        if (hour > 11 || minute > 59) return;
        if (num > 10 - i) return;//亮灯数大于剩下的位置数
        if (num == 0) {//使用完亮灯数，进行添加
            String minStr = String.valueOf(minute);
            if (minute < 10) {
                minStr = "0" + minStr;
            }
            ans.add(String.valueOf(hour) + ":" + minStr);
            return;
        }
        ;
        //不选当前位置
        backTracking(i + 1, num, hour, minute, ans);
        //选取当前位置
        if (i < 4) {//在hour范围内
            hour += (1 << i);
        } else {
            minute += (1 << (i - 4));
        }
        backTracking(i + 1, num - 1, hour, minute, ans);
    }

    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        backTracking(0, num, 0, 0, ans);
        return ans;
    }

    //2.记录法
    public List<String> readBinaryWatch2(int num) {
        if (num > 8) return new ArrayList<>();
        //将数字0-59的二进制中包含1位数保存起来
        int[] binaryCount = new int[60];
        for (int i = 0; i < 60; i++) {
            int n = i, res = 0;
            while (n != 0) {
                n = n & (n - 1);
                res++;
            }
            binaryCount[i] = res;
        }

        List<String> ans = new ArrayList<>();
        //遍历00:00到11:59之间的所有时间点,
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                //检查该时间点二进制中含1个数是否等于亮灯数
                if (binaryCount[i] + binaryCount[j] == num) {
                    String minStr = String.valueOf(j);
                    if (j < 10) {
                        minStr = "0" + minStr;
                    }
                    ans.add(String.valueOf(i) + ":" + minStr);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        ReadBinaryWatch obj = new ReadBinaryWatch();
        System.out.println(obj.readBinaryWatch2(n));
    }
}
