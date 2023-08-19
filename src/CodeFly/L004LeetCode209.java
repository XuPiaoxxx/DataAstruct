package CodeFly;

/**
 * 二分查找-LeetCode:209-代码随想录
 * 2023.08.19/18:36
 * 问题:给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *样例:
 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * tips:
 * 可以直接暴力循环，O(n的平方)
    滑动窗口的精华是起始位置如何移动
 */
public class L004LeetCode209 {
    public static void main(String[] args) {

    }

    /**
     * 自己写的,滑动窗口，也就是双指针
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int i=0;
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            i+=nums[fast];
            while(i>=target){
                res=Math.min(res,fast-slow+1);
                i-=nums[slow++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
