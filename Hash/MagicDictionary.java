/**
 * 676. 实现一个魔法字典
 * */

package LeetcodeJava.Hash;

public class MagicDictionary {
    /** Initialize your data structure here. */
    public MagicDictionary() {

    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return false;
    }

    public static void main(String[] args) {
        String[] dict = new String[] {"hello","leetcode"};
        String word = "hhllo";
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(dict);
        boolean param_2 = obj.search(word);

        System.out.println(param_2);
    }
}
