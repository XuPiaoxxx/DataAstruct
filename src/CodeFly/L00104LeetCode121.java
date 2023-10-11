package CodeFly;

/**
 *  买卖股票的最佳时机--LeetCode:121-代码随想录
 * 2023.10.11/16.50

 题目:给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

 TIPS:

 本题是买卖股票类动态规划问题,但是直接使用贪心的思路执行速度和复杂度会更低
 */

public class L00104LeetCode121 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]代表了第i天中选择状态j拥有的最大金额，j=0不持有股票，j=1持有股票
    //2.因为有两个状态，所以维护一个二维数组，每个一维数组长度为2存储状态，有n个一维数组。
    //需要对两种状态各自设计状态转移方程；
    //当今天不持股，即dp[i][0],则可由前一天的两种选择转移而来。1.前一天不持股，为dp[i-1][0] 2.前一天持股，今天卖出 dp[i-1][1]+price,dp[][]
    //含义是最大的金额，所以取二者中的最大值
    //若当天持股，即dp[i][1],则可由前一天的两种选择转移而来。1，前一天持股，dp[i-1][1]  2.前一天不持股，-price
    //同样取两者中的最大值
    //3.初始化，dp[0][0]为第一天不持股，则为0(实际上会有初始资金，可以看成相对值为0，没变化)，dp[0][1]为第一天持股的金额，只能买第一天股票，为-price[0]
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
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[n-1][0];
    }
    //贪心的方法
    //一次遍历，从头到尾，每次都比较该价格是否是最小值，更新记录，同时
    //记录profit利润，每次都求max(profit,i-最小值)
    //保证是cost后面是最大值
    public int maxProfit2(int[] prices) {
        int cost=Integer.MAX_VALUE;
        int profit=0;
        for(int i:prices){
            if(i<cost) cost=i;
            else profit=Math.max(profit,i-cost);
        }
        return profit;
    }

}
