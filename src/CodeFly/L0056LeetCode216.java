package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  组合总和 III-LeetCode:216-代码随想录
 * 2023.09.22/21.14

 题目:找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

 只使用数字1到9
 每个数字 最多使用一次
 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 TIPS:
 回溯暴力解组合问题，树形结构，用一个LinkedList数组进行尾部的弹出方法操作
 这题还需对total总和进行回溯弹出
 ，剪枝方法，舍弃不满足组合数目的枝叶


*/

public class L0056LeetCode216 {
    static List<List<Integer>> res=new ArrayList();
    static LinkedList<Integer> row=new LinkedList();
    static int total=0;
    public static void main(String[] args) {
        backTrack(3,7,1);
    }
    //未进行剪枝操作
//    public static void backTrack(int k,int n,int start){
//        if(row.size()==k&&total==n){
//            res.add(new ArrayList(row));
//            return;
//        }
//        for(int i=start;i<=9;i++){
//            row.add(i);
//            total+=i;
//            backTrack(k,n,i+1);
//            total-=i;
//            row.removeLast();
//        }
//    }
    //1.对深度进行剪枝，如果sum>n,就直接返回，后面怎么加都大于n
    //2.对宽度进行剪枝，如果后面遍历的个数不满足k个，直接返回剪枝。
    public static void backTrack(int k,int n,int start){
        if(row.size()==k&&total==n){
            res.add(new ArrayList(row));
            return;
        }
        //宽度剪枝，避免多余的分支
        for(int i=start;i<=9-(k-row.size())+1;i++){
            row.add(i);
            total+=i;
            //深度剪枝，避免多余的递归
            if(total>n){
                total-=i;
                row.removeLast();
                return;
            }
            backTrack(k,n,i+1);
            total-=i;
            row.removeLast();
        }
    }

}
