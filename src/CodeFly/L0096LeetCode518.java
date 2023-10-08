package CodeFly;

/**
 *  零钱兑换 II--LeetCode:518-代码随想录
 * 2023.10.8/21.25

 题目:给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 假设每一种面额的硬币有无限个。
 题目数据保证结果符合 32 位带符号整数。

完全背包问题!!!!!!
 转化思路:
 按照题目，完全背包可以由01背包演化而来，01背包每个物品只有一个，只能用一次，而完全背包的物品有无数个，可以用
 无数次。
 本题amount为背包容量。硬币的面值为对应的重量。

 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义--从数组中选择下标从0~i的硬币面额考虑加入背包中，dp[j]为背包容量为j时，加入背包中硬币的
 组合数

 2分析出状态转移方程--因为是求组合数，即求放入硬币的方法数(求组合)像之前的那道题一样:dp[j]=dp[j]+dp[j-nums[i]]
 照着之前的题思考，当前硬币面额为2，找dp[j-2]的方法数

 3确定dp数组的初始化赋值--dp[0]=1,将物品放入背包容量为0的背包，什么都不能放-也是一种方法(如果不为1，则不能往后推)
 其他位置初始化为0

 4确定遍历顺序--完全背包在一维滚动数组中第一层遍历和01背包一样，第二层遍历也需要从左到右，这样才有可能重复使用同一个物品
 (后序只能使用一次)
 在纯完全背包问题中（指求满足背包容量的的最大价值），先遍历背包还是先遍历背包容量没有影响，因为不管是组合还是排列，对于
 最大价值没影响，不同排列都是固定的最大价值。
 而此题是求放入硬币的方式，1,2,1和2,1,1都拿了1枚2硬币和2枚1硬币，这两种排列实质上是相同的取硬币方法，题目求的组合数。
 所以求组合要先遍历物品再遍历背包(物品i只能在物品i-1之后加入组合中，不会出现i-1在前，i在后的重复方法)
 而先遍历背包容量再遍历物品，会出现遍历物品i时，会有已经加入了物品i-1的情况，所以求的是排列方法数。
 例如：
 【1,2,5】---5
 先遍历背包再遍历物品：
 当容量为2时，{1,1}，{2}两种方法
 所以遍历到容量为3时，
 选硬币1：找dp[3-1]=dp[2]=2--{1,1,1},{2,1}
 选硬币2：找dp[3-2]=dp[1]=1---{1,2}
 硬币5：5>3,放不了不走这个代码
 所以dp[3]=上面全部情况=3--会出现{1，1,1}，{2,1}，{1,2}

 先遍历物品再遍历背包:
 物品1：容量1，2,3---dp[1]{1}dp[2]{1,1}dp[3]{1,1，1}都为1
 物品2：容量1,2,3---dp[1]{1}-1,dp[2]{1,1}{2找dp[2-2]=dp[0]=1}-2,dp[3]{1,1,1}{这里找dp[3-2]--{1,2}}
 物品3:不会再找物品1,2，逐步向后，求的是组合
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0096LeetCode518 {
    public static void main(String[] args) {

    }
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
