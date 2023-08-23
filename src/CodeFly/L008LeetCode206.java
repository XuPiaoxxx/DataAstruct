package CodeFly;

/**
 * ��ת����-LeetCode:206-��������¼
 * 2023.08.23/22.18

 ��Ŀ:
 ���㵥�����ͷ�ڵ� head �����㷴ת���������ط�ת�������
 *����:

 *
 * tips:

 */

public class L008LeetCode206 {
    public static void main(String[] args) {
    }

    /**
     * �Լ�д�ķ�ת����
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
     * �ݹ�д���ĺ���
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
