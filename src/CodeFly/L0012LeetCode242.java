package CodeFly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效字母异位-LeetCode:242-代码随想录
 * 2023.08.25/11.21

 题目:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
*样例:
 示例 1:
 输入: s = "anagram", t = "nagaram"
 输出: true
 示例 2:
 输入: s = "rat", t = "car"
 输出: false
 *
 * tips:题目数据范围小的哈希法可以用数组来解决，下标充当key，对应值为value。
 * 本题想法巧妙，用数组对应位置统计两字符串中各字母的出现次数是否相等.
 *
 * 后面有大佬的多种解法:字符排序比较，Map哈希表对比，两个数组比较，直接返回方法的比较
 *
 */

public class L0012LeetCode242 {
    public static void main(String[] args) {
    }
    /**
     * 用一个数组哈希法，是否26个位置都为0
     * @param s
     * @param t
     * @return
     */
    public  static boolean isAnagram0(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
    public boolean isAnagram3(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram4(String s, String t) {
        int[] counts = new int[26];
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }

}
