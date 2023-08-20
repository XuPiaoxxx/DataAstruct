package CodeFly;

/**
 * �Ƴ�����Ԫ��-LeetCode:203-��������¼
 * 2023.08.19/19:08
 * ����:����һ�������ͷ�ڵ� head ��һ������ val ������ɾ���������������� Node.val == val �Ľڵ㣬
 * ������ �µ�ͷ�ڵ� ��
 *����:
 ʾ�� 1��
 ���룺head = [1,2,6,3,4,5,6], val = 6
 �����[1,2,3,4,5]
 ʾ�� 2��
 ���룺head = [], val = 1
 �����[]
 ʾ�� 3��
 ���룺head = [7,7,7,7], val = 7
 �����[]
 *
 * tips:
 * ����ͷ��㽫������Ŀ�����нڵ��ձ黯�����õ�������head��
 * cur.next�ж�֮ǰҪ��ȷ��cur����Ϊ�գ������ָ�����
 * ��������Ҫע�⵱ǰѭ���Ľ����Ҫ�����Ľ���ǰһ����㡣
 *   while(cur.next!=null){//��ΪҪɾ������cur.next���ǲ�������
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
     * ����֣�LeetCode�ϵı��������뱣֤���б�����֪(Ϊ�ջ�����ֵ������֪)����IDEA�ﲻΪ
     * ��֪Ҳ�����гɹ�.
     * ����������ͷ���
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
            if(cur.next.val==val){//if(cur!=null&&cur.next!=null)-����LC�������е�
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return head;
    }

    /**
     * ��������ͷ���
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode DummyHead=new ListNode();
        DummyHead.next=head;
        ListNode cur=DummyHead;
        while(cur.next!=null){//��ΪҪɾ������cur.next���ǲ�������
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return DummyHead.next;
    }

}
