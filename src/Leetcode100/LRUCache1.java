package Leetcode100;

import java.util.ArrayDeque;
import java.util.Deque;

//��Ŀ146 �Լ�д�ĳ�ʱ
//class LRUCache {
//    Deque<int[]> deque_1;
//    Deque<int[]> deque_2;
//    int capacity;
//    int size=0;
//    public LRUCache(int capacity) {
//        this.capacity=capacity;
//        deque_1=new ArrayDeque<>(capacity);
//        deque_2=new ArrayDeque<>(capacity);
//    }
//
//    public int get(int key) {
//        while(!deque_1.isEmpty()&&deque_1.peek()[0]!=key){
//            deque_2.push(deque_1.pop());
//        }
//        if(deque_1.isEmpty()){
//            while(!deque_2.isEmpty()){
//                deque_1.push(deque_2.pop());
//            }
//            return -1;
//        }
//        int[] temp=deque_1.pop();
//        while(!deque_1.isEmpty()){
//            deque_2.push(deque_1.pop());
//        }
//        while(!deque_2.isEmpty()){
//            deque_1.push(deque_2.pop());
//        }
//        int res=temp[1];
//        deque_1.push(temp);
//        return res;
//    }
//
//    public void put(int key, int value) {
//        int[] newtemp=new int[]{key,value};
//        if(size<capacity){
//            deque_1.push(newtemp);
//            size++;
//        }else{
//            while(!deque_1.isEmpty()){
//                deque_2.push(deque_1.pop());
//            }
//            deque_2.pop();
//            while(!deque_2.isEmpty()){
//                deque_1.push(deque_2.pop());
//            }
//            deque_1.push(newtemp);
//        }
//    }
//}
public class LRUCache1 {
    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.get(2); // ������ {1=1}
//        lRUCache.put(2, 6); // ������ {1=1, 2=2}
//        lRUCache.get(1);    // ���� 1
//        lRUCache.put(1, 5); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
//        lRUCache.put(1,2);    // ���� -1 (δ�ҵ�)
//        lRUCache.get(4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
//        lRUCache.get(2);    // ���� -1 (δ�ҵ�)
    }

}
