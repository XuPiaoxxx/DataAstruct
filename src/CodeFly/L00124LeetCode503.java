package CodeFly;

import java.util.*;

/**
 *  ��һ������Ԫ�� II--LeetCode:503-��������¼
 * 2023.10.18/18.06

 ��Ŀ:����һ��ѭ������ nums �� nums[nums.length - 1] ����һ��Ԫ���� nums[0] �������� nums ��ÿ��Ԫ�ص� ��һ������Ԫ�� ��

 ���� x �� ��һ�������Ԫ�� �ǰ��������˳���������֮��ĵ�һ�������������������ζ����Ӧ��ѭ��������������һ�������������������ڣ������ -1 ��
 */
//1.����  2.����ջ+�������±�ȡģ����������


//����ջֻ������ջ������ݽṹ��Ҫ��������������Ҫ����Ա�Լ�����ջʱ������жϣ�
//�ܶ���֮������ֻ�����õ���ջ�������ص����⡣
//��ջ����ջ�ͣ������򰴴����ұ������飬�ҵ����ұ߳��ֵĵ�һ�����ڵ�ǰԪ�ص�(������ջ��)ֵ
//��֮����ջ���������ȳ��ֵ�С�ڵ�ǰԪ�ص�ֵ��
//���������Ҫ����ջʱ����Ա�Լ��ж�
//�����ڵ�ǰ����Ԫ����ջ��Ԫ�ؽ��бȽ�ʱҪ���ݲ�ͬ���������в�ͬ�����ݴ���
//��Ҫ������ջ������ջ�յ�Ԥ��
//����ջ�����þ��Ǵ洢֮ǰ��������Ԫ�أ���֮�����������ٸ���Ӧ��ֵ��

//���ⲻ֮ͬ��Ϊ�����鿴��һ����β��ӵĻ��Σ�����ֱ�Ӹ���һ������ƴ���ں��棬Ҳ����ֱ�ӱ���2n-1�Σ�ȡ�±��ʱ����ȡģ��ʵ�֡�
public class L00124LeetCode503 {
    public static void main(String[] args) {

    }
    //�ٷ�����д��
    //��ǰ��n���洢���鳤�ȣ����ʹ��
    //ջ�ĳ�ʼ��ֵҲ��ѭ��������Ĵ���
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
    //�Լ�д��
    public int[] nextGreaterElements1(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> stack=new LinkedList();
        stack.push(0);
        for(int i=1;i<2*nums.length;i++){
            while(!stack.isEmpty()&&nums[i%nums.length]>nums[stack.peek()]){
                res[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return res;
    }
}
