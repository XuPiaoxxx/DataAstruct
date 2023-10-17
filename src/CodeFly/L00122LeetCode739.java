package CodeFly;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  每日温度--LeetCode:739-代码随想录
 * 2023.10.17/23.02

 题目:给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
//1.暴力  2.单调栈


    //单调栈只是利用栈这个数据结构，要做到单调，还需要程序员自己在入栈时候进行判断，
    //总而言之，我们只是利用单调栈来解决相关的问题。
    //从栈顶到栈低，升序，则按从左到右遍历数组，找的是右边出现的第一个大于当前元素的(保存在栈中)值
    //反之降序栈则是找最先出现的小于当前元素的值。
    //升序降序与否要在入栈时程序员自己判断
    //并且在当前遍历元素与栈顶元素进行比较时要根据不同的条件进行不同的数据处理
    //不要忘记入栈操作和栈空的预防
    //单调栈的作用就是存储之前遍历过得元素，在之后条件满足再赋对应的值。
public class L00122LeetCode739 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
