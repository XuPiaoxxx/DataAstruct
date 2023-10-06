package CodeFly;

import java.util.Arrays;

/**
 *  分割等和子集--LeetCode:416-代码随想录
 * 2023.10.6/17.36
01背包问题!!!!!!
 转化思路:
 数组中的元素代表价值与重量都等于这个元素值的物品,装入容量为目标值的背包中。

 如果最终结果，最大价值与目标值相等，则返回true。

 题目:给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---一维滚动数组，01背包模板，从下标为0到下标为i的数之间进行选择装入容量为目标值的背包中，即：下标为0~i小于目标值的最大价值
 2分析出状态转移方程-背包问题:01背包问题一维滚动数组--dp[j]=max(dp[j],dp[j-重量]+价值)
 3确定dp数组的初始化赋值-当容量为0时，dp[0]=0,不能放任何数字，大小为0，其他初始值随意设置，但是不能影响后面的max判断，所以全部设为0.
 4确定遍历顺序--第一层遍历物品从左到右，第二层遍历背包容量从右到左，必须先遍历物品，再遍历背包容量
 (原因:背包容量从右到左是因为，如果从左到右会覆盖上一层i-1的值，导致i-1层的值被第i层覆盖，这时后面的递归公式会用i层的值，但这是不符合预期的，脑子里时刻有一张二维表格，会导致1个数取用多次。
        第二个原因是:如果先遍历背包容量，内层遍历数字，那么倒序会导致只存入一个最大的数字(因为除了最后一列其他都是0))
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0092LeetCode416 {
    public static void main(String[] args) {

    }
    public boolean canPartition(int[] nums) {
        if(Arrays.stream(nums).sum()%2==1) return false;
        int target=Arrays.stream(nums).sum()/2;
        int[] dp=new int[target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
}
