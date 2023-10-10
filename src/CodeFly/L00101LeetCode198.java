package CodeFly;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  ��ҽ���--LeetCode:198-��������¼
 * 2023.10.10/12.05

 ��Ŀ:����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵ�
 ����װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮
 ���ܹ�͵�Ե�����߽�
 TIPS:
 ��ʼ��ҽ���ϵ������!
 */

public class L00101LeetCode198 {
    public static void main(String[] args) {

    }
    //���ض�̬�滮�ⷨ:
    //1.dp[i]������i�������ܵõ��������Ϊdp[i]
    //2.��������͵����������ʱ����͵�����������ǲ���͵�ڶ���������Ϊdp[3-2]+nums[2]
                      //��͵��������Ϊdp[3-1]=dp[2]��dp��2���ļ۸�һ��
    //��ʱѡ�����е��������Ŀ
    //3.��ʼ��,dp[0]=0,û���ӿ�͵�������,dp[1]=nums[0]ֻ��һ�䷿�ӿ���͵
    //4.����˳��Ϊ�����ң���˳��͵���ɣ�������Ҫ��
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

}
