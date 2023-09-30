package CodeFly;

import java.util.Arrays;

/**
 *  �ַ��ǹ�-LeetCode:135-��������¼
 * 2023.09.30/17.44

 ��Ŀ:n ������վ��һ�š�����һ���������� ratings ��ʾÿ�����ӵ����֡�
 ����Ҫ��������Ҫ�󣬸���Щ���ӷַ��ǹ���
 ÿ���������ٷ��䵽 1 ���ǹ���
 ���������������ָ��ߵĺ��ӻ��ø�����ǹ���
 �����ÿ�����ӷַ��ǹ������㲢������Ҫ׼���� �����ǹ���Ŀ ��
 TIPS:
 ��Ҫ�������Ҫ���ұ�
 ����:
 1.ֻ���ұߴ�����ߵ��������ʱ��Ϊ��ߵ�ֵ�����ұߵ�ֵ��Ӱ��(���Դ������ұ���)
 2.ֻ����ߴ����ұߵ��������ʱ��Ϊ�ұߵ�ֵ������ߵ�ֵ��Ӱ��(���Դ������󣬵��ű���)
 (�������ܱ�֤�޺�Ч��)
 ��Ϊÿ������������һ���ǹ�����������������ĳ��Ⱥ��ǹ������ܺ͡�
 ��Ϊ rating[5]��rating[4]�ıȽ� Ҫ������ rating[5]��rating[6]�ıȽϽ�������� Ҫ�Ӻ���ǰ������
 �����ǰ��������rating[5]��rating[4]�ıȽ� �Ͳ������� rating[5]��rating[6]�ıȽϽ����
 */

public class L0077LeetCode135 {
    public static void main(String[] args) {
    }
    //�Լ�д�Ĵ��뱾���Ͼ��Ǳ���������Ĵ���ʱ�临�Ӷȸ��͡�
    //Stream��Ч�ʺܵͣ�ʱ��Ա�forѭ��������ܶ࣬������
    public int candy(int[] ratings) {
        int[] candys=new int[ratings.length];
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candys[i]=candys[i-1]+1;
        }
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i-1]>ratings[i]) candys[i-1]=Math.max(candys[i-1],candys[i]+1);
        }
        //return ratings.length+ Arrays.stream(candys).sum();
        int ans=0;
        for(int i:candys){
            ans+=i;
        }
        return ratings.length+ans;
    }
}
