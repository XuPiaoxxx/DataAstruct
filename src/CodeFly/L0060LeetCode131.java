package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  分割回文串-LeetCode:131-代码随想录
 * 2023.09.24/10.48

 题目:给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 回文串 是正着读和反着读都一样的字符串。
 注意：解集不能包含重复的组合。
 TIPS:
 分割问题的关键，难度，我认为是转化为回溯解决。
 用下标的起始位置表示子串的结束位置(也就是分割线的位置)，
 其余涉及到substring方法的使用.
 判断回文串单独拉一个功能。
 转化为回溯来解决



*/

public class L0060LeetCode131 {
    public static void main(String[] args) {

    }
    List<List<String>> res=new ArrayList();
    LinkedList<String> row=new LinkedList();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return res;
    }
    public void backTrack(String s,int start){
        if(start>=s.length()){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isP(s,start,i)){
                row.add(s.substring(start,i+1));
            }else{
                continue;
            }
            backTrack(s,i+1);
            row.removeLast();
        }
    }

    public boolean isP(String s,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
