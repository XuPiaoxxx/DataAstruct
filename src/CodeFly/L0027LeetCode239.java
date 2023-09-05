package CodeFly;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * L0026滑动窗口中的最大值-LeetCode:239-代码随想录
 * 2023.09.05/11.17

 题目:给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的
 最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回 滑
 动窗口中的最大值 。
*样例:
 *TIPS:
 * 单调队列的思想，维护一个队列，只用遍历一遍(暴力解法超时)
 *
*/
class MyQueue{
    Deque<Integer> deque=new LinkedList();
    void poll(int val){
        if(!deque.isEmpty()&&val==deque.peek()){
            deque.poll();
        }
    }
    void add(int val){
        while(!deque.isEmpty()&&val>deque.getLast()){
            deque.removeLast();
        }
        deque.add(val);
    }
    int peek(){
        return deque.peek();
    }
}

public class L0027LeetCode239 {
    public static void main(String[] args) {
    }
    //单调队列，学习了
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res=new int[nums.length-k+1];
        int num=0;
        MyQueue queue=new MyQueue();
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        res[num++]=queue.peek();
        for(int i=k;i<nums.length;i++){
            queue.poll(nums[i-k]);
            queue.add(nums[i]);
            res[num++]=queue.peek();
        }
        return res;
    }
}
