package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  组合总和 II-LeetCode:40-代码随想录
 * 2023.09.23/21.18

 题目:给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用 一次 。

 注意：解集不能包含重复的组合。
 TIPS:
 本题中涉及重复数，按照题目要求，提出树层重复和树枝重复的概念，
 对树层重复进行去重，借助used数组，
 （也可以按照自己想的方法，如果在当前数组区间内（同一层）
 重复就continue）


*/

public class L0059LeetCode40 {
    public static void main(String[] args) {

    }
    //自己想的去重方法(弹幕提示)
//    List<List<Integer>> res=new ArrayList();
//    LinkedList<Integer> row=new LinkedList();
//    int sum=0;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        backTrack(candidates,target,0);
//        return res;
//    }
//    public void backTrack(int[] candidates,int target,int start){
//        if(sum==target){
//            res.add(new ArrayList(row));
//            return;
//        }
//        for(int i=start;i<candidates.length;i++){
//            if(sum+candidates[i]>target) return;
    //去重逻辑关键
//            if(i>start&&candidates[i]==candidates[i-1]) continue;
//            sum+=candidates[i];
//            row.add(candidates[i]);
//            backTrack(candidates,target,i+1);
//            row.removeLast();
//            sum-=candidates[i];
//        }
//    }
    //运用used数组,下次遇见这种题尝试自己写出来!
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
