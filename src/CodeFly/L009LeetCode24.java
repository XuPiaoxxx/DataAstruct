package CodeFly;

/**
 * 两两交换链表中的节点-LeetCode:24-代码随想录
 * 2023.08.24/10.56

 题目:
 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *样例:
 输入：head = [1,2,3,4]
 输出：[2,1,4,3]
 示例 2：

 输入：head = []
 输出：[]
 *
 * tips:画图很好理解循环的解法，但是递归解法有点难理解，主要
 * 是head.next=下一层的开始，next.next=head,两节点交换
 * 照着图理解递归，自己想出来有点困难
 */

public class L009LeetCode24 {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head) {
        // if(head==null){
        //     return null;
        // }
        // ListNode DummyHead=new ListNode();
        // DummyHead.next=head;
        // ListNode cur=DummyHead;
        // while(cur.next!=null&&cur.next.next!=null){
        //     ListNode temp1=cur.next.next;
        //     cur.next.next=cur.next.next.next;
        //     temp1.next=cur.next;
        //     cur.next=temp1;
        //     cur=cur.next.next;
        // }
        // return DummyHead.next;

        //递归写法
        if(head==null||head.next==null)return head;
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }
}
