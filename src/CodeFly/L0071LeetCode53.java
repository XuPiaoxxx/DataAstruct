package CodeFly;

import java.util.Arrays;

/**
 *  最大子数组和-LeetCode:53-代码随想录
 * 2023.09.28/12.01

 题目:给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 子数组 是数组中的一个连续部分。
 TIPS:
 思路理解到位就很简单
 res用来存储最大值，每次遍历，大于res就更新
 count用来存储连续子数组的合，当count>0时证明这一段和对于后面的数还有机会
 比该数组大 因为正数是增加作用
 当count<0时证明，当前子数组和对于后面的数只有减小的作用，所以将count
 赋值为0，重新开始计数。
 因为题目要求返回最大的子数组和，所以直接返回res，不用关心开始结束位置啥的

 //本题做法是贪心!!!
 还有动态规划做法!!!记住以后再来理解
 !
 TODO
 动态规划

*/

public class L0071LeetCode53 {
    public static void main(String[] args) {
    }
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            if(count>res) res=count;
            if(count<0) count=0;
        }
        return res;
    }

}
