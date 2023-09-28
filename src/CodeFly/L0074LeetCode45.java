package CodeFly;

/**
 *  ��Ծ��Ϸ II-LeetCode:45-��������¼
 * 2023.09.28/18.19

 ��Ŀ:����һ������Ϊ n �� 0 ������������ nums����ʼλ��Ϊ nums[0]��

 ÿ��Ԫ�� nums[i] ��ʾ������ i ��ǰ��ת����󳤶ȡ����仰˵��������� nums[i] �����������ת������ nums[i + j] ��:

 0 <= j <= nums[i]
 i + j < n
 ���ص��� nums[n - 1] ����С��Ծ���������ɵĲ����������Ե��� nums[n - 1]��



 TIPS:
 ̰���㷨��
 ���鳤��Ϊ1��������������0
 ����������ڵ���2����������1�Σ�res��ʼ��Ϊ1.
 ����һ��next�����´�����������Զλ�ã�ͬʱ�����ڵ�ǰ����������Զλ�ü������
 ���絽�˵�ǰ��Զλ�ã���û���յ㣬�򽫵�ǰ��Զλ������Ϊnext����Ծ����res++��
 �����ʱ���õ����յ㣬��ֱ����ֹѭ�������ؼ�����
 ����ѭ�����˻�û��ֹ���������Զλ�ô����յ㣬ĩβ����res



*/

public class L0074LeetCode45 {
    public static void main(String[] args) {
    }
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int res=1,next=0,cur=nums[0];
        for(int i=1;i<nums.length;i++){
            next=Math.max(next,nums[i]+i);
            if(i==cur){
                if(i==nums.length-1) break;
                cur=next;
                res++;
            }
        }
        return res;
    }

}
