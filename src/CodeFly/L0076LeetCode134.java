package CodeFly;

import java.util.Arrays;

/**
 *  加油站-LeetCode:134-代码随想录
 * 2023.09.30/12.56

 题目:在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 TIPS:
 贪心算法，
 差值想到了，差值的贪心没想到，代码随想录思路，很巧妙
 用start记录起始位置。
 遍历数组，每次都将差值加到cursum和res
 res用来判断整个旅程的净剩油量。
 如果遍历过程中cursum小于0，则代表这个位置及之前的位置都不能做起始位置
 如果有起始位置只能是这个位置的后一个位置，
 所以标记start+1
 最后判断res的值。
*/

public class L0076LeetCode134 {
    public static void main(String[] args) {
    }
    //自己写的代码本质上就是暴力，下面的代码时间复杂度更低。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum=0;
        int res=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            cursum+=gas[i]-cost[i];
            res+=gas[i]-cost[i];
            if(cursum<0){
                start=i+1;
                cursum=0;
            }
        }
        return res>=0?start:-1;
    }

}
