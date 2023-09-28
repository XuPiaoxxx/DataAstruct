package CodeFly;

/**
 *  跳跃游戏-LeetCode:55-代码随想录
 * 2023.09.28/18.19

 题目:给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。


 TIPS:
 贪心思路，
 提取出覆盖范围的概念，每次遍历数组中的元素，覆盖范围对于当前位置都能延伸到i+nums[i]
 ，而且cover应该保证最大值，即每次赋值前都判断，尽可能让cover更大，即覆盖更多。
 如果覆盖范围包含了最后一个位置，返回true；
 注意:默认以下标计数，即初始为0，最后一个位置为length-1



*/

public class L0073LeetCode55 {
    public static void main(String[] args) {
    }
    public boolean canJump(int[] nums) {
        int cover=0;
        for(int i=0;i<=cover;i++){
            cover=Math.max(nums[i]+i,cover);
            if(cover>=nums.length-1) return true;
        }
        return false;
    }

}
