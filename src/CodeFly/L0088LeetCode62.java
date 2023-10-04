package CodeFly;

/**
 *  不同路径--LeetCode:62-代码随想录
 * 2023.10.4/14.58

 题目:一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

 问总共有多少条不同的路径？
 TIPS:

 到位置不消耗，跳这个动作才消耗
 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---二维dp数组，每个元素指到下标为i,j的位置有多少种走法
 2分析出状态转移方程  dp[i][j]=dp[i-1][j]+dp[i][j-1]
 3确定dp数组的初始化赋值dp[0][j]=1,dp[i][0]=1;第一行和第一列的元素都只有1种走法
 4确定遍历顺序---从上到下，从左到右（一直到目标位置dp[m-1][n-1]）
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0088LeetCode62 {
    public static void main(String[] args) {
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
