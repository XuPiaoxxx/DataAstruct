package CodeFly;

/**
 *  爬楼梯-LeetCode:70-代码随想录
 * 2023.10.3/14.28

 题目:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---第i个数组元素是到当前台阶的所有方法
 2分析出状态转移方程  dp[i]=dp[i-1]+dp[i-2]
 3确定dp数组的初始化赋值dp[0]=0,dp[1]=1，dp[2]=2;
 4确定遍历顺序---一次遍历，从左往右
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0086LeetCode509 {
    public static void main(String[] args) {
    }
    public int climbStairs(int n) {
        if(n<3) return n;
        // int[] dp=new int[n+1];
        // dp[0]=0;
        // dp[1]=1;
        // dp[2]=2;
        int a=1;
        int b=2;
        for(int i=3;i<n+1;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }
}
