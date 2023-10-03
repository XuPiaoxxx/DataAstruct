package CodeFly;

/**
 *  使用最小花费爬楼梯-LeetCode:746-代码随想录
 * 2023.10.3/15.23

 题目:给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 请你计算并返回达到楼梯顶部的最低花费。
 TIPS:

 到位置不消耗，跳这个动作才消耗
 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---第i个数组元素指当前台阶为楼顶，到当前位置的最小花费
 2分析出状态转移方程  dp[i]=Min(dp[i-1]+cost[i-1]，dp[i-2]+cost[i-2])
 3确定dp数组的初始化赋值dp[0]=0,dp[1]=0;
 4确定遍历顺序---一次遍历，从左往右
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0087LeetCode746 {
    public static void main(String[] args) {
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<2)return 0;
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }
}
