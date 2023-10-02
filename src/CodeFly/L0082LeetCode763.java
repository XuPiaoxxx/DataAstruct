package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  划分字母区间-LeetCode:763-代码随想录
 * 2023.10.2/10.27

 题目:给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。

 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。

 返回一个表示每个字符串片段的长度的列表。
 TIPS;
 学习代码随想录思想编码解题
 有限字母-考虑数组
 第一次遍历，统计字母对应的最远位置
 ASCII码进行对应字母下标确认
 用end来再遍历一遍，每次都更新end为当前字符最远长度和end间的最大值
 到达最大值则计入结果集
 */

public class L0082LeetCode763 {
    public static void main(String[] args) {
    }
    //自己按照思路编码--4ms
    public List<Integer> partitionLabels(String s) {
        int[] hash=new int[26];
        List<Integer> res=new ArrayList();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,hash[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
    //先将字符串转化为字符数组，再操作，会至少快1倍。
    public List<Integer> partitionLabels1(String s) {
        int[] hash=new int[26];
        List<Integer> res=new ArrayList();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,hash[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}
