package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  子集 II-LeetCode:90-代码随想录
 * 2023.09.24/17.20

 题目:给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 TIPS:used数组的应用
 在当前值等于前一个值的情况下:
 若used【i】==true证明对应i位置的数用过，即以及统计到要收集的集合中，当前i+1是新的一个元素，所以不用去重。
 若used【i】==false证明对应位置的数没有统计在集合中，即出现重复使用相同元素在一个集合中的情况，需要去重。



*/

public class L0063LeetCode90 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums,0,used);
        return res;
    }
    void backTrack(int[] nums,int start,boolean[] used){
        res.add(new ArrayList(path));
        for(int i=start;i<nums.length;i++){
            if(i>0&&!used[i-1]&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums,i+1,used);
            used[i]=false;
            path.removeLast();
        }
    }

}
