package CodeFly;

/**
 *  买卖股票的最佳时机 II--LeetCode:1212-代码随想录
 * 2023.10.11/17.18

 题目:给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

 返回 你能获得的 最大 利润 。

 TIPS:
和前一题的区别是可以多次买卖股票，所以在计算持有股票的状态的时候需要前一天的不持有状态，然后进行price的减操作。
 本题是买卖股票类动态规划问题,但是直接使用贪心的思路执行速度和复杂度会更低，而且代码更简单易懂
 */

public class L00105LeetCode122 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]代表了第i天中选择状态j拥有的最大金额，j=0不持有股票，j=1持有股票
    //2.因为有两个状态，所以维护一个二维数组，每个一维数组长度为2存储状态，有n个一维数组。
    //需要对两种状态各自设计状态转移方程；
    //当今天不持股，即dp[i][0],则可由前一天的两种选择转移而来。1.前一天不持股，为dp[i-1][0] 2.前一天持股，今天卖出 dp[i-1][1]+price,dp[][]
    //含义是最大的金额，所以取二者中的最大值
    //若当天持股，即dp[i][1],则可由前一天的两种选择转移而来。1，前一天持股，dp[i-1][1]  2.前一天不持股，因为可以多次买卖股票，所以要在前一天
    // 不持有的基础上进行操作dp[i-1][0]-price
    //同样取两者中的最大值
    //3.初始化，dp[0][0]为第一天不持股，则为0(实际上会有初始资金，可以看成相对值为0，没变化)，dp[0][1]为第一天持股的金额，只能买第一天股票，为0-price[0]
    //4.因为状态转移中，后一天需要前一天的两种状态的信息，所以按照从左到右，按天进行遍历。

    //5.打印
    //常规动态规划思路
    public int maxProfit1(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
    //贪心的方法
    //一次遍历，从头到尾，拐点加上利润，每次比较两个值，也就是如果后面的值大于前面的值，加上他们的差
    //利润有正数就加
    public int maxProfit2(int[] prices) {
        int sum=0;
        for(int i=1;i<prices.length;++i){ if(prices[i]>prices[i-1]) sum += prices[i] - prices[i-1]; }
        return sum;
    }

}
