package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合-LeetCode:77-代码随想录
 * 2023.09.21/21.57

 题目:给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 你可以按 任何顺序 返回答案。
 TIPS:
 回溯暴力解组合问题，树形结构，用一个LinkedList数组进行尾部的弹出方法操作
 ，剪枝方法，舍弃不满足组合数目的枝叶


*/

public class L0055LeetCode77 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> list=new LinkedList();
        List<List<Integer>> res=new ArrayList();
        backTrack(n,k,1,list,res);
        return res;

    }
    public void backTrack(int n,int k,int startindex,LinkedList<Integer> list,List<List<Integer>> res){
        if(list.size()==k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=startindex;i<=n-(k-list.size())+1;i++){
            list.add(i);
            backTrack(n,k,i+1,list,res);
            list.removeLast();
        }

    }

}
