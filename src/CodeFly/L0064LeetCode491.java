package CodeFly;

import java.util.*;

/**
 *  递增子序列-LeetCode:491-代码随想录
 * 2023.09.24/19.14

 题目:给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。

 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 TIPS:
 自己的想法+代码随想录去重方法，+思考
 回溯暴力递归解法，每次回溯都传入前一个值pre用来判断是否是递增序列。
 如果不递增，更新pre为当前值时，加入的集合会忽略当前值，错误。
 判断去重的逻辑采用Set集合，每一层开辟一个新的set集合，所以不用进行回溯弹出的操作。
 一层中遇到用过的元素，以及当  当前num【i】<pre时，直接当前值，对下一个nums【i+1】进行判断


*/

public class L0064LeetCode491 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0,Integer.MIN_VALUE);
        return res;
    }
    void backTrack(int[] nums,int start,int pre){
        if(path.size()>=2){
            res.add(new ArrayList(path));
        }
        Set<Integer> set=new HashSet();
        for(int i=start;i<nums.length;i++){
            if(nums[i]<pre||set.contains(nums[i])){
                pre=nums[i];
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backTrack(nums,i+1,nums[i]);
            path.removeLast();
        }
    }

}
