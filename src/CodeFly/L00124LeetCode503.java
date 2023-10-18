package CodeFly;

import java.util.*;

/**
 *  下一个更大元素 II--LeetCode:503-代码随想录
 * 2023.10.18/18.06

 题目:给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 */
//1.暴力  2.单调栈+对数组下标取模来求环形数组


//单调栈只是利用栈这个数据结构，要做到单调，还需要程序员自己在入栈时候进行判断，
//总而言之，我们只是利用单调栈来解决相关的问题。
//从栈顶到栈低，升序，则按从左到右遍历数组，找的是右边出现的第一个大于当前元素的(保存在栈中)值
//反之降序栈则是找最先出现的小于当前元素的值。
//升序降序与否要在入栈时程序员自己判断
//并且在当前遍历元素与栈顶元素进行比较时要根据不同的条件进行不同的数据处理
//不要忘记入栈操作和栈空的预防
//单调栈的作用就是存储之前遍历过得元素，在之后条件满足再赋对应的值。

//本题不同之处为将数组看成一个首尾相接的环形，可以直接复制一份数组拼接在后面，也可以直接遍历2n-1次，取下标的时候用取模来实现。
public class L00124LeetCode503 {
    public static void main(String[] args) {

    }
    //官方优秀写法
    //提前用n来存储数组长度，多次使用
    //栈的初始赋值也在循环里，更简洁的代码
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
    //自己写的
    public int[] nextGreaterElements1(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> stack=new LinkedList();
        stack.push(0);
        for(int i=1;i<2*nums.length;i++){
            while(!stack.isEmpty()&&nums[i%nums.length]>nums[stack.peek()]){
                res[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return res;
    }
}
