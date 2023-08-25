package CodeFly;

/**
 * ��������2-LeetCode:142-��������¼
 * 2023.08.24/11.33

 ��Ŀ:
 ����һ�������ͷ�ڵ�  head ����������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
 *����:
 ���룺head = [3,2,0,-4], pos = 1
 �������������Ϊ 1 ������ڵ�
 ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 * tips:
 * ��ѧϰ���ⷽ��,��������ʽ����Ҫ
 */

public class L0011LeetCode142 {
    public static void main(String[] args) {
    }

    /**
     * �Լ�д�ķ�������һ����ⷽ����ͬ�����Ƚ�������next����ǰ�жϲ�Ϊ�գ������û������null��
     * ����ָ��������л����˳���while�ж��뻷�ڵ㡣�����������׿�����
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
     * ��һ��˼·������ǰ�ƶ�fast��slow
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
