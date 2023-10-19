package CodeFly;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  柱状图中最大的矩形--LeetCode:84-代码随想录
 * 2023.10.19/16.47

 题目:给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

 求在该柱状图中，能够勾勒出来的矩形的最大面积。 */
//接雨水的逆题，接雨水是找左边第一个最大值，右边第一个最大值
    //这题是找两边的最小值，tips:在数组前后都加个0，防止出现忽略的包括首尾的结果统计
public class L00126LeetCode84 {
    public static void main(String[] args) {
        int[] arr={2,3,4,6};
    }
    //1.单调栈
    //每次循环都对当前高度和栈口元素的值进行比较
    //如果当前元素大于栈口元素，则入栈，保持递减，寻找右边第一个小于当前值的数
    //如果相等，则出栈原栈口元素，将当前元素入栈，等同于对相同的元素进行下标更新的操作，可以免除后面遍历时候的无用运算(结果为0的)
    //如果当前元素小于栈口元素，则将元素出栈暂存，这时候栈口的元素就是刚才存起来元素的左边的第一个比它小的值，这时候再根据实际计算
    //求左右墙壁之间有多宽，要left-right再-1，排除第一个充当墙壁的区域(不能直接减暂存的下标，有可能会出现left在mid的很左边)

    //本题运用技巧在前后都加个0!
    public int trap(int[] height) {
        Deque<Integer> stack=new LinkedList();
        int res=0;
        stack.push(0);
        for(int i=1;i<height.length;i++){
            if(height[i]>height[stack.peek()]){
                while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                    int mid=stack.pop();
                    if(!stack.isEmpty()){
                        res+=(i-stack.peek()-1)*(Math.min(height[i],height[stack.peek()])-height[mid]);
                    }
                }
                stack.push(i);
            }else if(height[i]==height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                stack.push(i);
            }
        }
        return res;
    }
    //TODO 2.双指针及其优化

    
    //TODO 3.动态规划
}
