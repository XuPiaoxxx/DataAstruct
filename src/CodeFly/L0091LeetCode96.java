package CodeFly;

import java.util.Arrays;

/**
 *  不同的二叉搜索树--LeetCode:96-代码随想录
 * 2023.10.5/15.59

 题目:给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---dp[i]对应以i个结点所构成的搜素二叉树数量
 2分析出状态转移方程  dp[i]+=dp[j-1]*dp[i-j]----以1-----i-1为头结点个数的树的总和为以i为头结点的树的个数
 3确定dp数组的初始化赋值dp[0]=1，空二叉树也是1个二叉树。符合后面的乘法原则
 4确定遍历顺序---一层遍历1-i,确定i个结点的树的数量，二层遍历从1开始，小于等于i,进行累加计算，
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0091LeetCode96 {
    public static void main(String[] args) {

    }
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
