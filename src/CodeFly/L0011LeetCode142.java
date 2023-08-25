package CodeFly;

/**
 * 环形链表2-LeetCode:142-代码随想录
 * 2023.08.24/11.33

 题目:
 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *样例:
 输入：head = [3,2,0,-4], pos = 1
 输出：返回索引为 1 的链表节点
 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * tips:
 * 多学习解题方法,环形链表公式很重要
 */

public class L0011LeetCode142 {
    public static void main(String[] args) {
    }

    /**
     * 自己写的方法，和一般解题方法不同的是先进行两步next（提前判断不为空），如果没环返回null，
     * 快慢指针相等则有环，退出用while判断入环节点。不如题解的容易看懂。
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)return null;
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    /**
     * 另一个思路，不提前移动fast和slow
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                fast=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
