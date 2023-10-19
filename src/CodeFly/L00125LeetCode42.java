package CodeFly;

import java.util.*;

/**
 *  ����ˮ--LeetCode:32-��������¼
 * 2023.10.19/12.57

 ��Ŀ:���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ�� */
//����ˮ�Ǿ����������Ŀ���ж��ֽⷨ������ÿ�ֶ�����
    //1.����ջ  2.˫ָ��(�����Ż�)3.��̬�滮
public class L00125LeetCode42 {
    public static void main(String[] args) {
        int[] arr={2,3,4,6};
    }
    //1.����ջ
    //ÿ��ѭ�����Ե�ǰ�߶Ⱥ�ջ��Ԫ�ص�ֵ���бȽ�
    //�����ǰԪ��С��ջ��Ԫ�أ�����ջ�����ֵ�����Ѱ���ұߵ�һ�����ڵ�ǰֵ����
    //�����ȣ����ջԭջ��Ԫ�أ�����ǰԪ����ջ����ͬ�ڶ���ͬ��Ԫ�ؽ����±���µĲ�������������������ʱ�����������(���Ϊ0��)
    //�����ǰԪ�ش���ջ��Ԫ�أ���Ԫ�س�ջ�ݴ棬��ʱ��ջ�ڵ�Ԫ�ؾ��ǸղŴ�����Ԫ�ص���ߵĵ�һ���������ֵ����ʱ���ٸ���ʵ�ʼ���
    //������ǽ��֮���ж��Ҫleft-right��-1���ų���һ���䵱ǽ�ڵ�����(����ֱ�Ӽ��ݴ���±꣬�п��ܻ����left��mid�ĺ����)
    public int trap(int[] height) {
        Deque<Integer> stack=new LinkedList();
        int res=0;
        stack.push(0);
        for(int i=1;i<height.length;i++){
            if(height[i]>height[stack.peek()]){
                while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                    int mid=stack.pop();
                    if(!stack.isEmpty()){
                        res+=(i-stack.peek()-1)*(Math.min(height[i],height[stack.peek()])-height[mid]);
                    }
                }
                stack.push(i);
            }else if(height[i]==height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                stack.push(i);
            }
        }
        return res;
    }
    //TODO 2.˫ָ�뼰���Ż�


    //TODO 3.��̬�滮
}
