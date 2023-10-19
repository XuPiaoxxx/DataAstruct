package CodeFly;

import java.util.*;

/**
 *  接雨水--LeetCode:32-代码随想录
 * 2023.10.19/12.57

 题目:给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 */
//接雨水是经典的面试题目，有多种解法，尽量每种都掌握
    //1.单调栈  2.双指针(暴力优化)3.动态规划
public class L00125LeetCode42 {
    public static void main(String[] args) {
        int[] arr={2,3,4,6};
    }
    //1.单调栈
    //每次循环都对当前高度和栈口元素的值进行比较
    //如果当前元素小于栈口元素，则入栈，保持递增，寻找右边第一个大于当前值的数
    //如果相等，则出栈原栈口元素，将当前元素入栈，等同于对相同的元素进行下标更新的操作，可以免除后面遍历时候的无用运算(结果为0的)
    //如果当前元素大于栈口元素，则将元素出栈暂存，这时候栈口的元素就是刚才存起来元素的左边的第一个比它大的值，这时候再根据实际计算
    //求左右墙壁之间有多宽，要left-right再-1，排除第一个充当墙壁的区域(不能直接减暂存的下标，有可能会出现left在mid的很左边)
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
