/**
 * 1370. 上升下降字符串
 */

package LeetcodeJava.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortString {
    public static void main(String[] args) {
//        int[] nums = {4,4,7,6,7};
//        String s = "aaaabbbbcccc";
        String s = "spo";
//        int[] nums = {4,3,10,9,8};
        SortString obj = new SortString();
        System.out.println(obj.sortString(s));
    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<Character> characterList = new ArrayList<>();
        for (char aChar : chars) {
            characterList.add(aChar);
        }
        int i=0,j;
        while(characterList.size()>0){
            chars[i++] = characterList.get(0);
            characterList.remove(0);
            j=0;

            while (j<characterList.size()){
//                System.out.println(i);
                if(characterList.get(j)>chars[i-1]){
                    chars[i++] = characterList.get(j);
                    characterList.remove(j);
                }else if(characterList.get(j)==chars[i-1]){
                    j++;
                }
            }
            if(characterList.size()>0){
                chars[i++] = characterList.get(characterList.size()-1);
                characterList.remove(characterList.size()-1);
                j=characterList.size()-1;
            }else break;

            while(j>=0){
                if(characterList.get(j)<chars[i-1]){
                    chars[i++] = characterList.get(j);
                    characterList.remove(j);
                }
                j--;
            }

        }

        return String.valueOf(chars);
    }

}
