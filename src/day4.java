import java.util.HashMap;

public class day4 {

    static class Node{
        int value;
        Node next;
        Node rand;
        Node(int val){
            value=val;
            rand=null;
            next=null;
        }
    }
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //Coding练习
    //1.反转单链表
    public static Node reverseList(Node head) {
        Node cur=head;
        Node pre=null;
        Node temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    //2.反转链表2，给定范围反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode DummyNode=new ListNode(-1,head);
        ListNode pre=DummyNode;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        ListNode rightNode=pre;
        for(int i=0;i<right-left+1;i++){
            rightNode=rightNode.next;
        }
        ListNode leftNode=pre.next;
        ListNode curr=rightNode.next;

        pre.next=null;
        rightNode.next=null;

        ListNode repre=null;
        ListNode recur=leftNode;
        while(recur!=null){
            ListNode temp=recur.next;
            recur.next=repre;
            repre=recur;
            recur=temp;
        }
        pre.next=rightNode;
        leftNode.next=curr;
        return DummyNode.next;
    }
    //3.

    //开辟空间复制带随机指针的链表
    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map=new HashMap<Node,Node>();
        Node cur=head;
        while(cur!=null){
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;
        }
        return map.get(head);
    }
    //面试空间复杂度O(1)
    public static Node copyListWithRand2(Node head){
        if(head==null){
            return null;
        }
        Node cur=head;
        Node next=null;
        //1->1'->2->2'.....
        while(cur!=null){
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=next;
            cur=next;
        }
        cur=head;
        Node curCopy=null;
        //set copy and rand
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.next:null;
            cur=next;
        }
        Node res=head.next;
        cur=head;
        while(cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            cur.next=next;
            curCopy.next=next!=null?next.next:null;
            cur=next;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
