package CodeFly;

import java.util.Arrays;

/**
 *  最长连续递增序列--LeetCode:674-代码随想录
 * 2023.10.13/14.20

 题目:给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r
 ，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ...,
 nums[r - 1], nums[r]] 就是连续递增子序列。 TIPS:
 */

public class L00111LeetCode674 {
    public static void main(String[] args) {

    }
    //主要的思路就是，遍历每一个数，因为要求是在数组中连续的递增子序列，所以每次只要比较两个连续的数即可，
    //如果后者大于前者，则在前面的长度基础上加1，最后找出最大的dp[i]
    //状态dp动态规划解法:
    //1.dp[i]的含义是，从下标为0到下标为i(以i结尾的子数组)，其中最长连续递增子序列的长度为dp[i]
    //2.在nums[i]>nums[i-1]的条件下，dp[i]=dp[i-1]+1;
    //3.初始化,因为最短的子序列长度为1，所以全部初始化为1
    //4.遍历顺序，由状态转移方程可知，每次进行状态转移需要前面的一个值来作为条件，所以要从左向右依次遍历。
    //5.打印
    public int findLengthOfLCIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])dp[i]=dp[i-1]+1;
        }
        int res=1;
        for(int i:dp){
            if(i>res)res=i;
        }
        return res;
    }
    //贪心算法，用一个值来记录最长的连续子序列，再用一个temp来计算当前遍历中的连续子序列的长度
    public int findLengthOfLCIS1(int[] nums) {
        int res=1;
        int temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])temp++;
            else{
                res=Math.max(res,temp);
                temp=1;
            }
        }
        res=Math.max(res,temp);
        return res;
    }




}
