package CodeFly;

/**
 *  最大子数组和--LeetCode:53-代码随想录
 * 2023.10.14/12.54

 题目:给你一个整数数组 nums ，
 请你找出一个具有最大和的连续子数
 组（子数组最少包含一个元素），返回
 其最大和。
 子数组 是数组中的一个连续部分。
 */

public class L00115LeetCode53 {
    public static void main(String[] args) {

    }
    //贪心的思路，动态规划的解法
    //状态dp动态规划解法:
    //1.dp[i]的含义是以数组下标i结尾的数的子数组最大和是dp[i]
    //2.dp[i]=max(dp[[i-1]+nums[i],nums[i])
    //3.初始化:dp[0]的含义是以dp[0]结尾的子数组最大长度，当前只有1个数，所以dp[0]=nums[0]
    //4.遍历顺序：状态转移方程可以得出当前dp值需要前一个来作为条件，所以从左到右
    //5.打印
    public int maxSubArray0(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    //贪心解法
    //一个遍历res统计最大子数组和，一个count统计当前遍历中最大子数组和
    //一旦count<0则代表这部分数组对后面没有相加变大的特性，所以置位0，重新统计
    public int maxSubArray1(int[] nums) {
        int res=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            if(count>res) res=count;
            if(count<0) count=0;
        }
        return res;
    }




}
