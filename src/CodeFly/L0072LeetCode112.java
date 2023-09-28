package CodeFly;

/**
 *  L0071LeetCode53-LeetCode:112-代码随想录
 * 2023.09.28/17.08

 题目:给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

 返回 你能获得的 最大 利润 。


 TIPS:
 思路理解到位就很简单
 本题没有限制条件，
 一遍循环，如果当前值大于前一个，可以直接加上差值，否则继续向后遍历.
 贪心思路，每天都拿最大利润，如果差值是负数，代表亏钱，不操作，也就不累加。
 只加正的差值。


*/

public class L0072LeetCode112 {
    public static void main(String[] args) {
    }
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=1;i<prices.length;++i){ if(prices[i]>prices[i-1]) sum += prices[i] - prices[i-1]; }
        return sum;
    }

}
