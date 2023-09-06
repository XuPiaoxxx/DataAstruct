package CodeFly;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * L0028LeetCode1047-LeetCode:347-代码随想录
 * 2023.09.06/10.49

 题目:给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
*样例:
 *
 * tips:优先队列的应用（自定义排序的队列）--底层是大顶堆和小顶堆，优先队列的常用方法和适用范围需要掌握，
 *
*/

public class L0028LeetCode327 {
    public static void main(String[] args) {
    }
    //参考了答案，以后自己用栈实现，理解一下。
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int []> minHeap=new PriorityQueue<int []>((o1, o2)->o1[1]-o2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num=entry.getKey();
            int count=entry.getValue();
            if(minHeap.size()==k){
                if(minHeap.peek()[1]<count){
                    minHeap.poll();
                    minHeap.offer(new int[]{num,count});
                }
            }else{
                minHeap.offer(new int[]{num,count});
            }
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=minHeap.poll()[0];
        }
        return res;

    }
}
