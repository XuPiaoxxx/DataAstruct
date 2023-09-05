package CodeFly;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * L0026���������е����ֵ-LeetCode:239-��������¼
 * 2023.09.05/11.17

 ��Ŀ:����һ���������� nums����һ����СΪ k �Ļ������ڴ������������ƶ��������
 ���Ҳࡣ��ֻ���Կ����ڻ��������ڵ� k �����֡���������ÿ��ֻ�����ƶ�һλ������ ��
 �������е����ֵ ��
*����:
 *TIPS:
 * �������е�˼�룬ά��һ�����У�ֻ�ñ���һ��(�����ⷨ��ʱ)
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
    //�������У�ѧϰ��
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
