package CodeFly;

/**
 *  打家劫舍II--LeetCode:213-代码随想录
 * 2023.10.10/12.28

 题目:你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的
 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之
 内能够偷窃到的最高金额。
 TIPS:
 开始打家劫舍系列问题!
 如何解决环的问题是本道题目的关键
 之前的思路:
 一题分为两道题:
 1.偷首元素，下标0~i-1
 2.不偷首元素 下标1~i
 //可以偷一手，重复利用元素，记录第一种方法的值
 最后返回两种方法中较大的元素
 */

public class L00102LeetCode213 {
    public static void main(String[] args) {

    }
    //朴素动态规划解法:
    //1.dp[i]代表到第i个房屋能得到的最大金额为dp[i]
    //2.例如正在偷第三个，此时可以偷第三个，但是不能偷第二个，所以为dp[3-2]+nums[2]
                      //不偷第三个，为dp[3-1]=dp[2]和dp【2】的价格一致
    //此时选择其中的最大金额数目
    //3.初始化,dp[0]=0,没房子可偷的最大金额,dp[1]=nums[0]只有一间房子可以偷
    //4.遍历顺序为从左到右，按顺序偷即可，无特殊要求

    //如果采用前后数，则开始下标为0，是数组中的第一个元素(房屋)，cur为前一个dp，为0，pre为前两个为0
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int pre=0;
        int cur=0;
        for(int i=0;i<nums.length-1;i++){
            int temp=Math.max(cur,pre+nums[i]);
            pre=cur;
            cur=temp;
        }
        int max1=cur;

        cur=0;
        pre=0;
        for(int i=1;i<nums.length;i++){
            int temp=Math.max(cur,pre+nums[i]);
            pre=cur;
            cur=temp;
        }
        return Math.max(max1,cur);
    }

}
