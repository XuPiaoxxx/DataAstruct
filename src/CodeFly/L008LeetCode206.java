package CodeFly;

/**
 * 反转链表-LeetCode:206-代码随想录
 * 2023.08.23/22.18

 题目:
 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *样例:

 *
 * tips:

 */

public class L008LeetCode206 {
    public static void main(String[] args) {
    }

    /**
     * 自己写的反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    /**
     * 递归写法的函数
     * @param cur
     * @param pre
     * @return
     */
    public static ListNode reverse(ListNode cur,ListNode pre){
        if(cur==null) return pre;
        ListNode temp=cur;
        pre=cur.next;
        return reverse(temp,pre);
    }
}
