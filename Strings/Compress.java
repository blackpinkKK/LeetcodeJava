/**
 * 443. 压缩字符串
 */

package LeetcodeJava.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compress {
    public static void main(String[] args) {
        char[] chars = {'a'};
//        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
//        char[] chars = {"a","a","b","b","c","c","c"};
        Compress i = new Compress();
        System.out.println(i.compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public int compress(char[] chars) {
        int ans = 1;
        char last = chars[0];
        int repeat = 1;
        for (int i = 1; i < chars.length; i++) {
            while (i < chars.length && chars[i] == last) {
                i++;
                repeat++;
            }

            if (i < chars.length) {
                last = chars[i];

                String str = String.valueOf(repeat);
                if(!str.equals("1")){
                    for(char c:str.toCharArray()){
                        chars[ans++] = c;
                    }
                }

                repeat = 1;
                chars[ans++] = last;
            }else{
                String str = String.valueOf(repeat);
                if(!str.equals("1")){
                    for(char c:str.toCharArray()){
                        chars[ans++] = c;
                    }
                }
            }
        }
        return ans;
    }

}
