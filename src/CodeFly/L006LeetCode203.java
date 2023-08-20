package CodeFly;

/**
 * 移除链表元素-LeetCode:203-代码随想录
 * 2023.08.19/19:08
 * 问题:给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，
 * 并返回 新的头节点 。
 *样例:
 示例 1：
 输入：head = [1,2,6,3,4,5,6], val = 6
 输出：[1,2,3,4,5]
 示例 2：
 输入：head = [], val = 1
 输出：[]
 示例 3：
 输入：head = [7,7,7,7], val = 7
 输出：[]
 *
 * tips:
 * 虚拟头结点将这种题目的所有节点普遍化，不用单独处理head。
 * cur.next判断之前要先确定cur不能为空，否则空指针错误
 * 链表问题要注意当前循环的结点是要操作的结点的前一个结点。
 *   while(cur.next!=null){//因为要删除的是cur.next，是操作对象
 */

public class L006LeetCode203 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }

    /**
     * 很奇怪，LeetCode上的编译器必须保证所有变量已知(为空或者有值都是已知)，而IDEA里不为
     * 已知也能运行成功.
     * 不设置虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        while(head!=null&&head.val==val){
            head=head.next;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==val){//if(cur!=null&&cur.next!=null)-这是LC才能运行的
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

    /**
     * 借助虚拟头结点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode DummyHead=new ListNode();
        DummyHead.next=head;
        ListNode cur=DummyHead;
        while(cur.next!=null){//因为要删除的是cur.next，是操作对象
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return DummyHead.next;
    }

}
