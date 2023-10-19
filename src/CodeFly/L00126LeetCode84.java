package CodeFly;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  ��״ͼ�����ľ���--LeetCode:84-��������¼
 * 2023.10.19/16.47

 ��Ŀ:���� n ���Ǹ�������������ʾ��״ͼ�и������ӵĸ߶ȡ�ÿ�����ӱ˴����ڣ��ҿ��Ϊ 1 ��

 ���ڸ���״ͼ�У��ܹ����ճ����ľ��ε��������� */
//����ˮ�����⣬����ˮ������ߵ�һ�����ֵ���ұߵ�һ�����ֵ
    //�����������ߵ���Сֵ��tips:������ǰ�󶼼Ӹ�0����ֹ���ֺ��Եİ�����β�Ľ��ͳ��
public class L00126LeetCode84 {
    public static void main(String[] args) {
        int[] arr={1};
        largestRectangleArea(arr);
    }
    //1.����ջ
    //ÿ��ѭ�����Ե�ǰ�߶Ⱥ�ջ��Ԫ�ص�ֵ���бȽ�
    //�����ǰԪ�ش���ջ��Ԫ�أ�����ջ�����ֵݼ���Ѱ���ұߵ�һ��С�ڵ�ǰֵ����
    //�����ȣ����ջԭջ��Ԫ�أ�����ǰԪ����ջ����ͬ�ڶ���ͬ��Ԫ�ؽ����±���µĲ�������������������ʱ�����������(���Ϊ0��)
    //�����ǰԪ��С��ջ��Ԫ�أ���Ԫ�س�ջ�ݴ棬��ʱ��ջ�ڵ�Ԫ�ؾ��ǸղŴ�����Ԫ�ص���ߵĵ�һ������С��ֵ����ʱ���ٸ���ʵ�ʼ���
    //������ǽ��֮���ж��Ҫleft-right��-1���ų���һ���䵱ǽ�ڵ�����(����ֱ�Ӽ��ݴ���±꣬�п��ܻ����left��mid�ĺ����)

    //�������ü�����ǰ�󶼼Ӹ�0!
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new LinkedList();
        int res=0;
        int[] arr=new int[heights.length+2];
        for(int i=0;i<heights.length;i++){
            arr[i+1]=heights[i];
        }
        stack.push(0);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else if(arr[i]>arr[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                    int h=arr[stack.pop()];
                    int w=i-stack.peek()-1;
                    res=Math.max(res,w*h);
                }
                stack.push(i);
            }
        }
        return res;
    }
}
