package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��ջ��ʵ�ֶ���-LeetCode:232-��������¼
 * 2023.08.29/18.04

 ��Ŀ:�����ʹ����������ʵ��һ�������ȳ���LIFO����ջ��
 ��֧����ͨջ��ȫ�����ֲ�����push��top��pop �� empty����
*����:
 *
 * tips:
 ��������ʵ��һ��ջ(�ؼ���Ҫ������ջ����������ջ��Ԫ��һ���ǵ�һ����
 ÿ����ջ���ø������������¹滮ջ��Ԫ�ص�˳��)

 һ������ʵ��ջ�����������в�ͬ���ǲ��ø������飬��������ջ������ÿ�η���
 ��Ԫ�غ󶼳�ջ����ջ��ѭ��i�Σ�ֱ����Ԫ�س�Ϊ����ͷ(i=������Ԫ��֮ǰջ
 Ԫ�ظ���)
 *
*/

public class L0023LeetCode225 {
    public static void main(String[] args) {

    }

    //һ������ʵ��
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

    //��������ʵ��
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
