package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  组合总和-LeetCode:39-代码随想录
 * 2023.09.23/20.48

 题目:给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates
 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 TIPS:
 模板题回溯暴力解法，小剪枝操作:
 先把数组排序，如果当前和以及大于target，则数组后面的也不需要遍历，
 直接返回到上层即可。


*/

public class L0058LeetCode39 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> row=new LinkedList();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0);
        return res;
    }
    public void backTrack(int[] candidates,int target,int start){
        if(sum==target&&res.size()<150){
            res.add(new LinkedList(row));
            return;
        }else if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i]>target) break;
            row.add(candidates[i]);
            sum+=candidates[i];
            backTrack(candidates,target,i);
            sum-=candidates[i];
            row.removeLast();
        }
    }

}
