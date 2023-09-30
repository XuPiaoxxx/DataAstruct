package CodeFly;

import java.util.Arrays;

/**
 *  K ��ȡ������󻯵������-LeetCode:1005-��������¼
 * 2023.09.29/21.27

 ��Ŀ:����һ���������� nums ��һ������ k �������·����޸ĸ����飺

 ѡ��ĳ���±� i ���� nums[i] �滻Ϊ -nums[i] ��
 �ظ��������ǡ�� k �Ρ����Զ��ѡ��ͬһ���±� i ��

 �����ַ�ʽ�޸�����󣬷������� ���ܵ����� ��



 TIPS:
 ̰���㷨��
 ���ԱȽ���Ҫ
 1.̰��!
 �ȰѸ���ת��Ϊ����
 ���ȫ������Ϊ��������ֻ�����С��Ԫ�ؽ��в�������k�β���
 ȫ���������

 1���������򣬱����긺�����������ٶ���С�Ĳ���
 2���԰��վ���ֵ�Ĵ�С˳���������(Java�еıȽ������󣬲��ܱȽ�int��������)
 ����ת��ΪInteger��������Զ������򣬱���ֻ��Ը��������з�ת��������в�����k����
 ֻ�����С��ֵ��������Ϊ����ֵ��������ֻ������һ�Ρ�

 ע��:��������Сֵ���򣬿��Զ�ʣ��k%2,������ظ�ȡ���Ĳ���������



*/

public class L0075LeetCode1005 {
    public static void main(String[] args) {
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1&&nums[i]<0&&k>0){
            nums[i]=-nums[i];
            k--;
            i++;
        }
        Arrays.sort(nums);
        i=0;
        while(k>0){
            nums[i]=-nums[i];
            k--;
        }
        return Arrays.stream(nums).sum();
    }

}
