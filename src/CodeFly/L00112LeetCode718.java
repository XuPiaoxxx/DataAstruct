package CodeFly;

import java.util.Arrays;

/**
 *  最长重复子数组--LeetCode:718-代码随想录
 * 2023.10.14/10.23

 题目:给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */

public class L00112LeetCode718 {
    public static void main(String[] args) {

    }
    //因为有两个数组，且要找二者的公共部分，所以需要二维的dp数组，来分别确定两个数组的子数组的最末的一个数。
    //如果当前遍历的两个数组中的数相同，则在两个数组中相对的以当前数的前一个为结尾的数的最长连续公共数组的长度+1
    //最后找出最大的长度
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是，以第一个数组中下标i和第二个数组下标j为结尾的最长连续公共子数组的长度为dp[i][j]
    //2.在nums[i]>nums[j]的条件下，dp[i][j]=dp[i-1][j-1]+1;
    //3.初始化,二维数组中多加一行，一列作为第一行和第一列，初始化为0，即数组长度为[nums1.length+1][nums2.length+1]
    //这样在状态转移时:dp[i-1][j-1]才代表数组下标i和下标j结尾的子数组
    //4.遍历顺序：对于二维数组来说，遍历顺序无要求，二维数组从左到右
    //5.打印
    public int findLength1(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    //滚动数组
    //以为动态转移方程，后一个数需要上一次的前者来推推导，如果第二层遍历从左到右，则会覆盖，所以后序遍历。
    //并且如果中途连续公共子数组中断，需要重新赋值为0
    //即数组对应值不相等
    //用一个res来存储最大的长度
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp=new int[nums2.length+1];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=nums2.length;j>0;j--){
                if(nums1[i-1]==nums2[j-1]) dp[j]=dp[j-1]+1;
                else dp[j]=0;
                res=Math.max(res,dp[j]);
            }
        }
        return res;
    }




}
