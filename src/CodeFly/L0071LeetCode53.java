package CodeFly;

import java.util.Arrays;

/**
 *  ����������-LeetCode:53-��������¼
 * 2023.09.28/12.01

 ��Ŀ:����һ���������� nums �������ҳ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

 ������ �������е�һ���������֡�
 TIPS:
 ˼·��⵽λ�ͺܼ�
 res�����洢���ֵ��ÿ�α���������res�͸���
 count�����洢����������ĺϣ���count>0ʱ֤����һ�κͶ��ں���������л���
 �ȸ������ ��Ϊ��������������
 ��count<0ʱ֤������ǰ������Ͷ��ں������ֻ�м�С�����ã����Խ�count
 ��ֵΪ0�����¿�ʼ������
 ��Ϊ��ĿҪ�󷵻�����������ͣ�����ֱ�ӷ���res�����ù��Ŀ�ʼ����λ��ɶ��

 //����������̰��!!!
 ���ж�̬�滮����!!!��ס�Ժ��������
 !
 TODO
 ��̬�滮

*/

public class L0071LeetCode53 {
    public static void main(String[] args) {
    }
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            if(count>res) res=count;
            if(count<0) count=0;
        }
        return res;
    }

}
