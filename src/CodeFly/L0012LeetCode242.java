package CodeFly;

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
 */

public class L0012LeetCode242 {
    public static void main(String[] args) {

    }
    public  static boolean isAnagram(String s, String t) {
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
}
