package CodeFly;

import java.util.Arrays;

/**
 *  摆动序列-LeetCode:376-代码随想录
 * 2023.09.27/21.25

 题目:如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。
 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 TIPS:
 这题首先要读懂题目的要求，这很重要，数组会出现三种相关情况。
 1.上下坡有平坡--差值为0(判断条件加上等于0的条件，删左删右代码不同，看前dif
 或者后dif)
 2.首尾元素--假设数组前还有个数，与第一个相等，所以predif初始化为0
 3.单调平坡--每次有摆动才记忆，不然一直记忆predif会产生，dif=0，curdif!=0
 的条件，会多记录res。
 还有动态规划做法:以后再学。




*/

public class L0070LeetCode376 {
    public static void main(String[] args) {

    }
    //自己缝缝补补写的
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int res=1;
        int dif=nums[0]-nums[1];
        for(int i=1;i<nums.length;i++){
            if(dif==0&&nums[i]-nums[i-1]!=0){
                dif=nums[i]-nums[i-1];
                res++;
            }else if((nums[i]-nums[i-1])*dif<0){
                res++;
                dif=nums[i]-nums[i-1];
            }
        }
        return res;
    }
    //学习代码随想录写的，思路清晰一点
    public int wiggleMaxLength1(int[] nums) {
        if(nums.length==1) return 1;
        int res=1;
        int preDif=0;
        int curDif=0;
        for(int i=1;i<nums.length;i++){
            curDif=nums[i]-nums[i-1];
            if((preDif>=0&&curDif<0)||(preDif<=0&&curDif>0)){
                res++;
                preDif=curDif;
            }
        }
        return res;
    }

}
