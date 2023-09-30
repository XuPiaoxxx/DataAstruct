package CodeFly;

import java.util.Arrays;

/**
 *  ����վ-LeetCode:134-��������¼
 * 2023.09.30/12.56

 ��Ŀ:��һ����·���� n ������վ�����е� i ������վ������ gas[i] ����
 ����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�
 ���������������� gas �� cost ���������԰�˳���ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1 ��������ڽ⣬�� ��֤ ���� Ψһ �ġ�
 TIPS:
 ̰���㷨��
 ��ֵ�뵽�ˣ���ֵ��̰��û�뵽����������¼˼·��������
 ��start��¼��ʼλ�á�
 �������飬ÿ�ζ�����ֵ�ӵ�cursum��res
 res�����ж������ó̵ľ�ʣ������
 �������������cursumС��0����������λ�ü�֮ǰ��λ�ö���������ʼλ��
 �������ʼλ��ֻ�������λ�õĺ�һ��λ�ã�
 ���Ա��start+1
 ����ж�res��ֵ��
*/

public class L0076LeetCode134 {
    public static void main(String[] args) {
    }
    //�Լ�д�Ĵ��뱾���Ͼ��Ǳ���������Ĵ���ʱ�临�Ӷȸ��͡�
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cursum=0;
        int res=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            cursum+=gas[i]-cost[i];
            res+=gas[i]-cost[i];
            if(cursum<0){
                start=i+1;
                cursum=0;
            }
        }
        return res>=0?start:-1;
    }

}
