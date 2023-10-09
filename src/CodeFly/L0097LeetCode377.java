package CodeFly;

/**
 *  组合总和 Ⅳ--LeetCode:377-代码随想录
 * 2023.10.9/13.5

 题目:给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums
 中找出并返回总和为 target 的元素组合的个数。
 题目数据保证答案符合 32 位整数范围。

完全背包问题!!!!!!
 转化思路:
 本总结的硬币面额转换为对应数字，背包容量为target
 按照题目，完全背包可以由01背包演化而来，01背包每个物品只有一个，只能用一次，而完全背包的物品有无数个，可以用
 无数次。
 本题target为背包容量。硬币的面值为对应的重量。

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
    按照题目，本题求排列数，所以先遍历背包容量再遍历物品
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

public class L0097LeetCode377 {
    public static void main(String[] args) {

    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<target+1;i++){
            for(int j:nums){
                if(i>=j)dp[i]+=dp[i-j];
            }
        }
        return dp[target];
    }
}
