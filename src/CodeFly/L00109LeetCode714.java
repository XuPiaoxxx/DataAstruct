package CodeFly;

/**
 *  买卖股票的最佳时机含手续费--LeetCode:714-代码随想录
 * 2023.10.13/12.16

 题目:给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 返回获得利润的最大值。
 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

 TIPS:
本题中有手续费的概念，涉及的是每次买入都有额外的花费，可以看成是购入价格的一部分。
 */

public class L00109LeetCode714 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //参考股票2，可以无限次地买，不过每次买都有加上手续费
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp0=-prices[0]-fee,dp1=0;
        for(int i=1;i<n;i++){
            dp0=Math.max(dp0,dp1-prices[i]-fee);
            dp1=Math.max(dp1,dp0+prices[i]);
        }
        return dp1;
    }




}
