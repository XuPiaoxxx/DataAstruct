package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和-LeetCode:18-代码随想录
 * 2023.08.26/17.54

 题目:给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足
 下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四
 元组元素一一对应，则认为两个四元组重复）：0 <= a, b, c, d < na、b、c 和 d 互不相
 同nums[a] + nums[b] + nums[c] + nums[d] == target
 你可以按 任意顺序 返回答案 。

*样例:示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]
 * tips:
 * 算法可以一次一次得优化，比较，优化。
 * 问题:马虎，还是得多做多熟悉。
 * debug能力上来了，但是用处不大
 * 小心极限数据，提前剪枝(剪枝要慎重慎重考虑清楚)
*/

public class L0017LeetCode18 {
    public static void main(String[] args) {
        fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            if(nums[k]>target&&nums[k]>0) break;
            if(k>0&&nums[k-1]==nums[k]) continue;
            for(int i=k+1;i<nums.length;i++){
                if(nums[k]+nums[i]>target&&nums[k]+nums[i]>0) break;
                if(i>k+1&&nums[i-1]==nums[i]) continue;
                int L=i+1;
                int R=nums.length-1;
                while(L<R){
                    int sum=nums[k]+nums[i]+nums[L]+nums[R];
                    if(sum>target){
                        R--;
                    }else if(sum<target){
                        L++;
                    }else{
                        res.add(Arrays.asList(nums[k],nums[i],nums[L],nums[R]));
                        R--;
                        L++;
                        while(L<R&&nums[R]==nums[R-1]) R--;
                        while(L<R&&nums[L]==nums[L+1]) L++;
                    }
                }
            }
        }
        return res;
    }
}
