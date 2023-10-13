package CodeFly;

import java.util.Arrays;

/**
 *  最长递增子序列--LeetCode:300-代码随想录
 * 2023.10.13/13.47

 题目:给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 TIPS:
本题中有手续费的概念，涉及的是每次买入都有额外的花费，可以看成是购入价格的一部分。
 */

public class L00110LeetCode300 {
    public static void main(String[] args) {

    }
    //主要的思路就是，循环数组中的每一个数，找出在这个数之前的最长的，结尾小于当前数，并且严格递增的子序列，再加1就是当前数的最长子序列长度。
    //状态dp动态规划解法:
    //1.dp[i]的含义是，从下标为0到下标为i(以i结尾的子数组)，其中最长递增子序列的长度为dp[i]
    //2.在nums[i]>nums[j]的条件下，dp[i]=max(dp[i],dp[j]+1)
    //3.初始化,因为最短的子序列长度为1，所以全部初始化为1
    //4.遍历顺序，由状态转移方程可知，前面的数是后面的数的状态转移的条件，所以第一层循环从左到右i
    //  第2层循环目的主要是找出0~j中的最大的长度，所以遍历顺序无影响
    //5.打印
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int res=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[j]+1,dp[i]);
            }
            if(dp[i]>res)res=dp[i];
        }
        return res;
    }




}
