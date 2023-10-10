package CodeFly;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  打家劫舍--LeetCode:198-代码随想录
 * 2023.10.10/12.05

 题目:你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的
 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之
 内能够偷窃到的最高金额。
 TIPS:
 开始打家劫舍系列问题!
 */

public class L00101LeetCode198 {
    public static void main(String[] args) {

    }
    //朴素动态规划解法:
    //1.dp[i]代表到第i个房屋能得到的最大金额为dp[i]
    //2.例如正在偷第三个，此时可以偷第三个，但是不能偷第二个，所以为dp[3-2]+nums[2]
                      //不偷第三个，为dp[3-1]=dp[2]和dp【2】的价格一致
    //此时选择其中的最大金额数目
    //3.初始化,dp[0]=0,没房子可偷的最大金额,dp[1]=nums[0]只有一间房子可以偷
    //4.遍历顺序为从左到右，按顺序偷即可，无特殊要求
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

}
