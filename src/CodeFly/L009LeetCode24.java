package CodeFly;

/**
 * �������������еĽڵ�-LeetCode:24-��������¼
 * 2023.08.24/10.56

 ��Ŀ:
 ����һ���������������������ڵĽڵ㣬�����ؽ����������ͷ�ڵ㡣
 ������ڲ��޸Ľڵ��ڲ���ֵ���������ɱ��⣨����ֻ�ܽ��нڵ㽻������
 *����:
 ���룺head = [1,2,3,4]
 �����[2,1,4,3]
 ʾ�� 2��

 ���룺head = []
 �����[]
 *
 * tips:��ͼ�ܺ����ѭ���Ľⷨ�����ǵݹ�ⷨ�е�����⣬��Ҫ
 * ��head.next=��һ��Ŀ�ʼ��next.next=head,���ڵ㽻��
 * ����ͼ���ݹ飬�Լ�������е�����
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

        //�ݹ�д��
        if(head==null||head.next==null)return head;
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next=head;
        return next;
    }
}
