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
    //前提是已经判断x存在
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
    //map中的key对应双向链表中的节点，便于查询
    private HashMap<Integer,Node> map;
    //双向链表作为主干结构
    private DoubleList cache;
    private int cap;

    //提供一层API来统一实现map和DoubleList，防止在LRUCache中
    //将某个key提升至最近使用(Map和双向链表同时操作)
    private void UpRecently(int key){
        Node x=map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }
    //新增一个船新的元素
    private void addNew(int key,int val){
        Node x=new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }
    //任意删除一个key
    private void deleteKey(int key){
        Node x=map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    //自然删除(缓存达到上限情况下还要新增元素)
    private void removeLeastUse(){
        //链表头部的就是
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
