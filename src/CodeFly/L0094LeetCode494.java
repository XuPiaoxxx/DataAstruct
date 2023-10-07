package CodeFly;

/**
 *  目标和--LeetCode:494-代码随想录
 * 2023.10.7/20.28

 题目:给你一个非负整数数组 nums 和一个整数 target 。
 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 01背包问题!!!!!!
 转化思路:
 按照题目，将前面放+的元素和前面放-的元素分成两个部分，要求的target="+部分"的-去"-部分"
 同时两部分的和为sum=+部分加上-部分
 //+部分和-部分
 //pos+neg=sum
 //pos-neg=target
 //->neg=pos-target
 //->pos+pos-target=sum
 //->pos=(sum+target)>1

 //转换为装容量为pos的背包的方法的问题,其中重量和价值都是对应元素的值(这题不需要价值的概念)


 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义---一维滚动数组，01背包模板，从下标为0到下标为i的数之间进行选择装入容量为目标值的背包中，求装满对应j容量背包的方法数为dp[j]。
 2分析出状态转移方程-背包问题:01背包问题一维滚动数组--dp[j]+=dp[j-nums[j]]--将0~i元素装入大小为j的
 背包中,能正好装满j的方法数，有放当前i(dp[j-nums[j]])和不放当前i(dp[j])两种方法(当j<当前元素值时放不进去，没有足够大小)
 3确定dp数组的初始化赋值-当容量为0，没有可选数时(或不满足)，什么都不装正好装满容量0，有一种方法，所以dp[0]=1;
 4确定遍历顺序--第一层遍历物品从左到右，第二层遍历背包容量从右到左，必须先遍历物品，再遍历背包容量
 (原因:背包容量从右到左是因为，如果从左到右会覆盖上一层i-1的值，导致i-1层的值被第i层覆盖，这时后面的递归公式会用i层的值，但这是不符合预期的，脑子里时刻有一张二维表格，会导致1个数取用多次。
        第二个原因是:如果先遍历背包容量，内层遍历数字，那么倒序会导致只存入一个最大的数字(因为除了最后一列其他都是0))
        转移会用到前面的数，所以倒序遍历数组
 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L0094LeetCode494 {
    public static void main(String[] args) {

    }
    public int findTargetSumWays(int[] nums, int target) {
        //+部分和-部分
        //pos+neg=sum
        //pos-neg=target
        //->neg=pos-target
        //->pos+pos-target=sum
        //->pos=(sum+target)>1
        //转换为装容量为pos的背包的方法的问题
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if((sum+target)%2!=0||sum+target<0)return 0;
        int bagSize=(sum+target)>>1;
        int[] dp=new int[bagSize+1];
        dp[0]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=bagSize;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[bagSize];
    }
}
