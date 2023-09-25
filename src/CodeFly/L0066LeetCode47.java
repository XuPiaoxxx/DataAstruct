package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  全排列二-LeetCode:47-代码随想录
 * 2023.09.25/12.29

 题目:给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 TIPS:
 排序+树枝去重(为了排列)+树层去重(为了去除之前用过的相同元素)
 等于是重复组合问题+排列问题
*/

public class L0066LeetCode47 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums);
        return res;
    }
    void backTrack(int[] nums){
        if(path.size()==nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums);
            used[i]=false;
            path.removeLast();
        }
    }

}
