package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用栈来实现队列-LeetCode:232-代码随想录
 * 2023.08.29/18.04

 题目:请你仅使用两个队列实现一个后入先出（LIFO）的栈，
 并支持普通栈的全部四种操作（push、top、pop 和 empty）。
*样例:
 *
 * tips:
 两个队列实现一个栈(关键是要保持入栈操作中新入栈的元素一定是第一个，
 每次入栈都用辅助数组来重新规划栈中元素的顺序。)

 一个队列实现栈，和两个队列不同的是不用辅助数组，而是在入栈操作中每次放入
 新元素后都出栈再入栈，循环i次，直到新元素成为队列头(i=放入新元素之前栈
 元素个数)
 *
*/

public class L0023LeetCode225 {
    public static void main(String[] args) {

    }

    //一个队列实现
    class MyStack1 {

        Queue<Integer> queue;

        public MyStack1() {
            queue=new LinkedList();
        }

        public void push(int x) {
            queue.offer(x);
            for(int i=0;i<queue.size()-1;i++){
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    //两个队列实现
    class MyStack2 {

        Queue<Integer> queue;
        Queue<Integer> InStack;

        public MyStack2() {
            queue=new LinkedList();
            InStack=new LinkedList();
        }

        public void push(int x) {
            InStack.offer(x);
            while(!queue.isEmpty()) InStack.offer(queue.poll());
            Queue<Integer> temp=queue;
            queue=InStack;
            InStack=temp;
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
