package CodeFly;

/**
 *  买卖股票的最佳时机 IV--LeetCode:188-代码随想录
 * 2023.10.12/12.02

 题目:给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 TIPS:
本题限制交易最多能有k次，与三相比，2次和k次有很多相同的地方，延伸思路，很简单
 */

public class L00107LeetCode188 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]代表了第i天中选择状态j拥有的最大金额，j=0第一次持有股票，j=1第一次不持有持有股票，j=3第二次持有股票,j=4第二次不持有股票，以此类推。。。j=k-1第k次持有股票，j=k第k次不持有股票
    //2.因为有2*k个状态，所以维护一个二维数组，每个一维数组长度为2*k.(实际上还有一个刚开始未持有的状态，但是其取值都是0，可以直接省略，第一次持有直接在0的基础上进行减)
    //需要对2*k种状态各自设计状态转移方程；
    //第一次持股 ，两种选择
    //第一次不持股,以下同理
    //第二次持股
    //第二次不持股
    //.....
    //第k次持股
    //第k次不持股
    //同样取两者中的最大值
    //3.初始化，dp[0][0]为第一次持股，只能为-prices[0],dp[0][1]为第一次不持股，为0，买完就卖，dp[0][2]第二次持股，第一天时可以买完卖再买为-price[0]
    //dp[0][3]为第二次不持有股票，第一天来说就是又卖出了，为0
    //......以此同理，循环赋初值
    //最后返回值本来是取，第一次不持有和第二次不持有的最大值，但是如果第一次不持有利润最高，可以将第二次不持有看成买完又卖，所以相等，总得来说直接返回第二次未持有就可..
    //同理直接返回最后第k次不持有即可
    //4.因为状态转移中，后一天需要前一天的两种状态的信息，所以按照从左到右，按天进行遍历。

    //5.打印
    //常规动态规划思路
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2*k];
        for(int i=0;i<2*k;i+=2){
            dp[0][i]=-prices[0];
            dp[0][i+1]=0;
        }
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            for(int j=2;j<2*k;j+=2){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                dp[i][j+1]=Math.max(dp[i-1][j+1],dp[i-1][j]+prices[i]);
            }
        }
        return dp[n-1][2*k-1];
    }
    //空间优化
    //dp[2]利用的是当天的dp[1]。 但结果也是对的。
    //简单解释一下：
    //dp[1] = max(dp[1], dp[0] - prices[i]); 如果dp[1]取dp[1]，即保持买入股票的状态，那么 dp[2] = max(dp[2], dp[1] + prices[i]);中dp[1] + prices[i] 就是今天卖出。
    //如果dp[1]取dp[0] - prices[i]，今天买入股票，那么dp[2] = max(dp[2], dp[1] + prices[i]);中的dp[1] + prices[i]相当于是今天再卖出股票，一买一卖收益为0，对所得现金没有影响。相当于今天买入股票又卖出股票，等于没有操作，保持昨天卖出股票的状态了。
    //这种写法看上去简单，其实思路很绕，不建议大家这么写，这么思考，很容易把自己绕进去！
    //同理空间优化
    public int maxProfit1(int k, int[] prices) {
        int n=prices.length;
        int[] dp=new int[2*k];
        for(int i=0;i<2*k;i+=2){
            dp[i]=-prices[0];
            dp[i+1]=0;
        }
        for(int i=1;i<n;i++){
            dp[0]=Math.max(dp[0],-prices[i]);
            dp[1]=Math.max(dp[1],dp[0]+prices[i]);
            for(int j=2;j<2*k;j+=2){
                dp[j]=Math.max(dp[j],dp[j-1]-prices[i]);
                dp[j+1]=Math.max(dp[j+1],dp[j]+prices[i]);
            }
        }
        return dp[2*k-1];
    }




}
