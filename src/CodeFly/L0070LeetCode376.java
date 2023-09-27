package CodeFly;

import java.util.Arrays;

/**
 *  �ڶ�����-LeetCode:376-��������¼
 * 2023.09.27/21.25

 ��Ŀ:�����������֮��Ĳ��ϸ���������͸���֮�佻�棬���������г�Ϊ �ڶ����� ����һ���������ڵĻ�����������������������һ��Ԫ�ػ��ߺ���������Ԫ�ص�����Ҳ�����ڶ����С�
 ���磬 [1, 7, 4, 9, 2, 5] ��һ�� �ڶ����� ����Ϊ��ֵ (6, -3, 5, -7, 3) ������������ֵġ�
 �෴��[1, 4, 7, 2, 5] �� [1, 7, 4, 5, 5] ���ǰڶ����У���һ����������Ϊ����ǰ������ֵ�����������ڶ�����������Ϊ�������һ����ֵΪ�㡣
 ������ ����ͨ����ԭʼ������ɾ��һЩ��Ҳ���Բ�ɾ����Ԫ������ã�ʣ�µ�Ԫ�ر�����ԭʼ˳��
 ����һ���������� nums ������ nums ����Ϊ �ڶ����� �� ������еĳ��� ��
 TIPS:
 ��������Ҫ������Ŀ��Ҫ�������Ҫ����������������������
 1.��������ƽ��--��ֵΪ0(�ж��������ϵ���0��������ɾ��ɾ�Ҵ��벻ͬ����ǰdif
 ���ߺ�dif)
 2.��βԪ��--��������ǰ���и��������һ����ȣ�����predif��ʼ��Ϊ0
 3.����ƽ��--ÿ���аڶ��ż��䣬��Ȼһֱ����predif�������dif=0��curdif!=0
 ������������¼res��
 ���ж�̬�滮����:�Ժ���ѧ��




*/

public class L0070LeetCode376 {
    public static void main(String[] args) {

    }
    //�Լ���첹��д��
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int res=1;
        int dif=nums[0]-nums[1];
        for(int i=1;i<nums.length;i++){
            if(dif==0&&nums[i]-nums[i-1]!=0){
                dif=nums[i]-nums[i-1];
                res++;
            }else if((nums[i]-nums[i-1])*dif<0){
                res++;
                dif=nums[i]-nums[i-1];
            }
        }
        return res;
    }
    //ѧϰ��������¼д�ģ�˼·����һ��
    public int wiggleMaxLength1(int[] nums) {
        if(nums.length==1) return 1;
        int res=1;
        int preDif=0;
        int curDif=0;
        for(int i=1;i<nums.length;i++){
            curDif=nums[i]-nums[i-1];
            if((preDif>=0&&curDif<0)||(preDif<=0&&curDif>0)){
                res++;
                preDif=curDif;
            }
        }
        return res;
    }

}
