package CodeFly;

/**
 * 删除链表中倒数第n个结点-LeetCode:19-代码随想录
 * 2023.08.24/11.29

 题目:
 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *样例:
 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]
 示例 2：

 输入：head = [1], n = 1
 输出：[]
 *
 * tips:经典快慢指针，需要注意删除链表操作要定位到要操作的节点前一个。
 * 题目中规定 节点数量大于等于传入的倒数数量 n的值，否则要进行判断。
 *
 * 不用双指针需要遍历两次，第一次求出链表长度，第二次定位要删除节点的前一个
 */

public class L0010LeetCode19 {
    public static void main(String[] args) {
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode DummyHead=new ListNode(0,head);
        ListNode cur=DummyHead;
        ListNode tail=DummyHead.next;
        for(int i=0;i<n;i++){
            tail=tail.next;
        }
        while(tail!=null){
            cur=cur.next;
            tail=tail.next;
        }
        cur.next=cur.next.next;
        return DummyHead.next;
    }
}
