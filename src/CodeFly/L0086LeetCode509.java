package CodeFly;

/**
 *  斐波那契数-LeetCode:509-代码随想录
 * 2023.10.3/13.33

 题目:斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

 F(0) = 0，F(1) = 1
 F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 给定 n ，请计算 F(n) 。
 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---第i个斐波那契数的值是dp[i]
 2分析出状态转移方程  dp[i]=dp[i-1]+dp[i-2]
 3确定dp数组的初始化赋值dp[0]=0,dp[1]=1
 4确定遍历顺序---一次遍历，从左往右
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0086LeetCode509 {
    public static void main(String[] args) {
    }
    public int fib(int n) {
        if(n<2) return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
