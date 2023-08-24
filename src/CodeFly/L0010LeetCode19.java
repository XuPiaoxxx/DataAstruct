package CodeFly;

/**
 * ɾ�������е�����n�����-LeetCode:19-��������¼
 * 2023.08.24/11.29

 ��Ŀ:
 ����һ������ɾ������ĵ����� n ����㣬���ҷ��������ͷ��㡣
 *����:
 ���룺head = [1,2,3,4,5], n = 2
 �����[1,2,3,5]
 ʾ�� 2��

 ���룺head = [1], n = 1
 �����[]
 *
 * tips:�������ָ�룬��Ҫע��ɾ���������Ҫ��λ��Ҫ�����Ľڵ�ǰһ����
 * ��Ŀ�й涨 �ڵ��������ڵ��ڴ���ĵ������� n��ֵ������Ҫ�����жϡ�
 *
 * ����˫ָ����Ҫ�������Σ���һ����������ȣ��ڶ��ζ�λҪɾ���ڵ��ǰһ��
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
