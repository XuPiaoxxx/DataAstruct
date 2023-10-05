package CodeFly;

/**
 *  整数拆分--LeetCode:343-代码随想录
 * 2023.10.5/12.01

 题目:给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 返回 你可以获得的最大乘积 。
 TIPS:

 到位置不消耗，跳这个动作才消耗
 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---dp[i]对应拆分i的最大乘积
 2分析出状态转移方程  dp[i]=Max(j*(i-j),j*dp[i-j],dp[i])
 3确定dp数组的初始化赋值dp[0]=0,dp[1]=0无意义，i>=2才能开始拆，dp[2]=1,只有1+1的拆分方法
 4确定遍历顺序---先确定拆分i,一层循环，再从j=1开始进行拆分，二层循环，最差的预期是拆2个，值为i/2*i/2(大概),所以遍历到（i-j）就可以停止内层循环
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0090LeetCode343 {
    public static void main(String[] args) {

    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<n+1;i++){
            for(int j=1;j<=i-j;j++){
                dp[i]=Math.max(j*(i-j),Math.max(j*dp[i-j],dp[i]));
            }
        }
        return dp[n];
    }
}
