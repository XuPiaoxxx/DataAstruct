package CodeFly;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * L0028LeetCode1047-LeetCode:347-��������¼
 * 2023.09.06/10.49

 ��Ŀ:����һ���������� nums ��һ������ k �����㷵�����г���Ƶ��ǰ k �ߵ�Ԫ�ء�����԰� ����˳�� ���ش𰸡�
*����:
 *
 * tips:���ȶ��е�Ӧ�ã��Զ�������Ķ��У�--�ײ��Ǵ󶥶Ѻ�С���ѣ����ȶ��еĳ��÷��������÷�Χ��Ҫ���գ�
 *
*/

public class L0028LeetCode327 {
    public static void main(String[] args) {
    }
    //�ο��˴𰸣��Ժ��Լ���ջʵ�֣����һ�¡�
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
