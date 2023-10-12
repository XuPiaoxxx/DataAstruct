package CodeFly;

/**
 *  买卖股票的最佳时机含冷冻期--LeetCode:309-代码随想录
 * 2023.10.12/18.31

 题目:给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。?
 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 TIPS:
本题中有冷冻期的概念，涉及的是状态的设计和状态的转移。
 */

public class L00108LeetCode309 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]代表了第i天结束时状态j拥有的最大金额,j=0是持有股票状态，j=1时是卖出股票状态(不持股)，j=2是冷冻期状态(不持股)，j=3是非冷冻不持股
    //2.为每个状态进行状态转移，具体:
    //            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][2]-prices[i],dp[i-1][3]-prices[i]));
    //            dp[i][1]=dp[i-1][0]+prices[i];
    //            dp[i][2]=dp[i-1][1];
    //            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]);
    //自己理解，3个状态和4个状态应该都能看明白
    //3.初始化，dp[0][0]为第一次持股，只能为-prices[0],dp[0][1]为卖出，为0，买完就卖，dp[0][2]为冷冻期，第1天买完就卖为0，dp[0][3]无意义
    //考虑初始化设置为0，无影响。
    //初始值的设定0,无影响。参考具体含义，如果无意义则看状态转移的情况，不能对状态转移方程造成影响。
    //4.因为状态转移中，后一天需要前一天的两种状态的信息，所以按照从左到右，按天进行遍历。

    //5.打印
    //三个状态，每个状态都是当天交易结束时候的状态
    public int maxProfit1(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][3];//0持有,1冷冻期未持有2非冷冻期未持有
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
    //四个状态，每个状态都是当天中任意时间的状态
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][4];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=0;
        dp[0][3]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][2]-prices[i],dp[i-1][3]-prices[i]));
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=dp[i-1][1];
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]);
        }
        return Math.max(dp[n-1][1],Math.max(dp[n-1][2],dp[n-1][3]));
    }




}
