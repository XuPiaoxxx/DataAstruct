package Leetcode100;

import java.util.HashMap;

class Node{
    public int key,val;
    public Node next,prev;
    public Node(int k,int v){
        this.key=k;
        this.val=v;
    }
}
class DoubleList{
    private Node head,tail;
    private int size;

    public DoubleList(){
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    public void addLast(Node x){
        x.prev=tail.prev;
        x.next=tail;
        tail.prev.next=x;
        tail.prev=x;
        size++;
    }
    //ǰ�����Ѿ��ж�x����
    public void remove(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
        size--;
    }

    public Node removeFirst(){
        if(head.next==tail){
            return null;
        }
        Node first=head.next;
        remove(first);
        return first;
    }

    public int size(){return size;}
}


class LRUCache {
    //map�е�key��Ӧ˫�������еĽڵ㣬���ڲ�ѯ
    private HashMap<Integer,Node> map;
    //˫��������Ϊ���ɽṹ
    private DoubleList cache;
    private int cap;

    //�ṩһ��API��ͳһʵ��map��DoubleList����ֹ��LRUCache��
    //��ĳ��key���������ʹ��(Map��˫������ͬʱ����)
    private void UpRecently(int key){
        Node x=map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    //����һ�����µ�Ԫ��
    private void addNew(int key,int val){
        Node x=new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }
    //����ɾ��һ��key
    private void deleteKey(int key){
        Node x=map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    //��Ȼɾ��(����ﵽ��������»�Ҫ����Ԫ��)
    private void removeLeastUse(){
        //����ͷ���ľ���
        Node deleteNode=cache.removeFirst();
        int toDeleteKey=deleteNode.key;
        map.remove(toDeleteKey);
    }

    public LRUCache(int capacity) {
        this.cap=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        UpRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteKey(key);
            addNew(key,value);
            return;
        }
        if(cache.size()==cap){
            removeLeastUse();
        }
        addNew(key,value);
    }
}
public class LRUCacheCrot {
    public static void main(String[] args) {

    }
}
