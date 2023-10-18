package CodeFly;

import java.util.*;

/**
 *  ��һ������Ԫ�� I--LeetCode:496-��������¼
 * 2023.10.18/17.35

 ��Ŀ:nums1 ������ x �� ��һ������Ԫ�� ��ָ x �� nums2 �ж�Ӧλ�� �Ҳ� �� ��һ�� �� x ���Ԫ�ء�
 �������� û���ظ�Ԫ�� ������ nums1 �� nums2 ���±�� 0 ��ʼ����������nums1 �� nums2 ���Ӽ���
 ����ÿ�� 0 <= i < nums1.length ���ҳ����� nums1[i] == nums2[j] ���±� j �������� nums2 ȷ�� nums2[j] �� ��һ������Ԫ�� �������������һ������Ԫ�أ���ô���β�ѯ�Ĵ��� -1 ��
 ����һ������Ϊ nums1.length ������ ans ��Ϊ�𰸣����� ans[i] ������������ ��һ������Ԫ�� �� */
//1.����  2.����ջ+��ϣӳ��


    //����ջֻ������ջ������ݽṹ��Ҫ��������������Ҫ����Ա�Լ�����ջʱ������жϣ�
    //�ܶ���֮������ֻ�����õ���ջ�������ص����⡣
    //��ջ����ջ�ͣ������򰴴����ұ������飬�ҵ����ұ߳��ֵĵ�һ�����ڵ�ǰԪ�ص�(������ջ��)ֵ
    //��֮����ջ���������ȳ��ֵ�С�ڵ�ǰԪ�ص�ֵ��
    //���������Ҫ����ջʱ����Ա�Լ��ж�
    //�����ڵ�ǰ����Ԫ����ջ��Ԫ�ؽ��бȽ�ʱҪ���ݲ�ͬ���������в�ͬ�����ݴ���
    //��Ҫ������ջ������ջ�յ�Ԥ��
    //����ջ�����þ��Ǵ洢֮ǰ��������Ԫ�أ���֮�����������ٸ���Ӧ��ֵ��

    //������Է�Ϊ����:1.������ĵ���ջ���ұߵ�һ�����Ԫ��2.�ڶ���������������жϹ�ϣӳ������
    //��Ӧ��ֵ
public class L00123LeetCode496 {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack=new LinkedList();
        Map<Integer,Integer> map=new HashMap();
        stack.push(nums2[0]);
        for(int i=1;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                res[i]=map.get(nums1[i]);
            }
        }
        return res;
    }
}
