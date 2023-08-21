package CodeFly;

/**
 * 设计链表-LeetCode:707-代码随想录
 * 2023.08.21/20.18

 题目:
    选择使用单链表或者双链表，设计并实现自己的链表。
 *样例:
 * 呼，写这个玩意这费劲，手写了一个双向链表，带头结点，确实具体实现更清晰了，
 * 我觉得比较难的是循环找对应位置的条件判断编写，可能这就是数学不好的后果把，唉
 * 长路漫漫，加油~
 *
 * tips:
 * 链表基本功，没什么好说的，太犹豫了~
 */
class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(){};
    ListNode(int val){
        this.val=val;
    }
}
public class L007LeetCode707 {

    public static void main(String[] args) {
        L007LeetCode707 myLinkedList = new L007LeetCode707();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        int i = myLinkedList.get(1);
    }
    int length;
    ListNode head;

    public L007LeetCode707() {
        length=0;
        head=new ListNode();
        head.next=head;
        head.prev=head;
    }

    public int get(int index) {
        if(index<0||index>length-1) return -1;
        ListNode cur=head;
        for(int i=0;i<=index;i++) cur=cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode Node=new ListNode(val);
        Node.next=head.next;
        Node.prev=head;
        head.next=Node;
        ListNode cur=head;
        this.length++;
        for(int i=0;i<length;i++)cur=cur.next;
        head.prev=cur;
    }

    public void addAtTail(int val) {
        ListNode Node=new ListNode(val);
        ListNode cur=head;
        Node.prev=head.prev;
        head.prev.next=Node;
        Node.next=head;
        head.prev=Node;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if(index<0||index>length)return;
        ListNode cur=head;
        for(int i=0;i<index;i++)cur=cur.next;
        ListNode Node=new ListNode(val);
        Node.prev=cur;
        Node.next=cur.next;
        cur.next.prev=Node;
        cur.next=Node;
        length++;
    }

    public void deleteAtIndex(int index) {
        if(index<0||index>length-1)return;
        ListNode cur=head;
        for(int i=0;i<index;i++)cur=cur.next;
        cur.next.next.prev=cur;
        cur.next=cur.next.next;
        length--;
    }
}
