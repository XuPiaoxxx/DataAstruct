package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  子集-LeetCode:78-代码随想录
 * 2023.09.24/13.28

 题目:给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 TIPS:
    进行一般暴力回溯进行搜索，每次都将集合添加到结果集中。


*/

public class L0062LeetCode78 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return res;
    }
    public void backTrack(int[] nums,int start){
        res.add(new ArrayList(path));
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }
}
