package CodeFly;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  ÿ���¶�--LeetCode:739-��������¼
 * 2023.10.17/23.02

 ��Ŀ:����һ���������� temperatures ����ʾÿ����¶ȣ�����һ������ answer ��
 ���� answer[i] ��ָ���ڵ� i �죬��һ�������¶ȳ����ڼ���������������֮�󶼲������ߣ����ڸ�λ���� 0 �����档
 */
//1.����  2.����ջ


    //����ջֻ������ջ������ݽṹ��Ҫ��������������Ҫ����Ա�Լ�����ջʱ������жϣ�
    //�ܶ���֮������ֻ�����õ���ջ�������ص����⡣
    //��ջ����ջ�ͣ������򰴴����ұ������飬�ҵ����ұ߳��ֵĵ�һ�����ڵ�ǰԪ�ص�(������ջ��)ֵ
    //��֮����ջ���������ȳ��ֵ�С�ڵ�ǰԪ�ص�ֵ��
    //���������Ҫ����ջʱ����Ա�Լ��ж�
    //�����ڵ�ǰ����Ԫ����ջ��Ԫ�ؽ��бȽ�ʱҪ���ݲ�ͬ���������в�ͬ�����ݴ���
    //��Ҫ������ջ������ջ�յ�Ԥ��
    //����ջ�����þ��Ǵ洢֮ǰ��������Ԫ�أ���֮�����������ٸ���Ӧ��ֵ��
public class L00122LeetCode739 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
