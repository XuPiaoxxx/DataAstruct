public class day5 {

    static class Node{
        int val;
        Node next;
        Node(){
        };
        Node(int value){
            val=value;
        }
        Node(int value,Node n){
            val=value;
            next=n;
        }
    }
    //找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        //初始条件是不能相等的
        Node n1=head.next;
        Node n2=head.next.next;
        while(n1!=null){
            if(n2.next==null||n2.next.next==null){
                return null;
            }
            n2=n2.next.next;
            n1=n1.next;
        }
        //快指针移动到头部
        n2=head;
        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }
        return n1;
    }
    //如果两个链表都无环，找到第一个相交节点，如果不相交，返回null
    public static Node noLoop(Node head1,Node head2){
        if(head1==null||head2==null){
            return null;
        }
        int n=0;
        Node cur1=head1;
        Node cur2=head2;
        while(cur1!=null){
            n++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            n--;
            cur2=cur2.next;
        }
        if(cur1!=cur2){
            return null;
        }
        cur1=n>0?head1:head2;//cur1变成长链表的头
        cur2=cur1==head1?head2:head1;//cur2变成短链表的头
        n=Math.abs(n);
        while(n!=0){
            n--;
            cur1=cur1.next;
        }
        while(cur1!=null){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    //两个有环链表，返回第一个相交节点，如果不相交返回null
    public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1=null;
        Node cur2=null;
        if(loop1==loop2){
            cur1=head1;
            cur2=head2;
            int n=0;
            while(cur1!=loop1){
                n++;
                cur1=cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?head1:head2;
            cur2=cur1==head1?head2:head1;
            n=Math.abs(n);
            while(n!=0){
                n--;
                cur1=cur1.next;
            }
            return cur1;
        }else {
            cur1=loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2){
                    return loop1;
                }
                cur1= cur1.next;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
