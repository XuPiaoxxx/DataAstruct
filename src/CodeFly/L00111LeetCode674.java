package CodeFly;

import java.util.Arrays;

/**
 *  �������������--LeetCode:674-��������¼
 * 2023.10.13/14.20

 ��Ŀ:����һ��δ��������������飬�ҵ���� ���������������У������ظ����еĳ��ȡ�
 ���������������� �����������±� l �� r��l < r��ȷ�����������ÿ�� l <= i < r
 ������ nums[i] < nums[i + 1] ����ô������ [nums[l], nums[l + 1], ...,
 nums[r - 1], nums[r]] �����������������С� TIPS:
 */

public class L00111LeetCode674 {
    public static void main(String[] args) {

    }
    //��Ҫ��˼·���ǣ�����ÿһ��������ΪҪ�����������������ĵ��������У�����ÿ��ֻҪ�Ƚ����������������ɣ�
    //������ߴ���ǰ�ߣ�����ǰ��ĳ��Ȼ����ϼ�1������ҳ�����dp[i]
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i]�ĺ����ǣ����±�Ϊ0���±�Ϊi(��i��β��������)��������������������еĳ���Ϊdp[i]
    //2.��nums[i]>nums[i-1]�������£�dp[i]=dp[i-1]+1;
    //3.��ʼ��,��Ϊ��̵������г���Ϊ1������ȫ����ʼ��Ϊ1
    //4.����˳����״̬ת�Ʒ��̿�֪��ÿ�ν���״̬ת����Ҫǰ���һ��ֵ����Ϊ����������Ҫ�����������α�����
    //5.��ӡ
    public int findLengthOfLCIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])dp[i]=dp[i-1]+1;
        }
        int res=1;
        for(int i:dp){
            if(i>res)res=i;
        }
        return res;
    }
    //̰���㷨����һ��ֵ����¼������������У�����һ��temp�����㵱ǰ�����е����������еĳ���
    public int findLengthOfLCIS1(int[] nums) {
        int res=1;
        int temp=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1])temp++;
            else{
                res=Math.max(res,temp);
                temp=1;
            }
        }
        res=Math.max(res,temp);
        return res;
    }




}
