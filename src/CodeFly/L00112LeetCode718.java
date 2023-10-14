package CodeFly;

import java.util.Arrays;

/**
 *  ��ظ�������--LeetCode:718-��������¼
 * 2023.10.14/10.23

 ��Ŀ:�������������� nums1 �� nums2 ������ ���������� ������ ���������������ĳ��� ��
 */

public class L00112LeetCode718 {
    public static void main(String[] args) {

    }
    //��Ϊ���������飬��Ҫ�Ҷ��ߵĹ������֣�������Ҫ��ά��dp���飬���ֱ�ȷ��������������������ĩ��һ������
    //�����ǰ���������������е�����ͬ������������������Ե��Ե�ǰ����ǰһ��Ϊ��β�������������������ĳ���+1
    //����ҳ����ĳ���
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�ĺ����ǣ��Ե�һ���������±�i�͵ڶ��������±�jΪ��β�����������������ĳ���Ϊdp[i][j]
    //2.��nums[i]>nums[j]�������£�dp[i][j]=dp[i-1][j-1]+1;
    //3.��ʼ��,��ά�����ж��һ�У�һ����Ϊ��һ�к͵�һ�У���ʼ��Ϊ0�������鳤��Ϊ[nums1.length+1][nums2.length+1]
    //������״̬ת��ʱ:dp[i-1][j-1]�Ŵ��������±�i���±�j��β��������
    //4.����˳�򣺶��ڶ�ά������˵������˳����Ҫ�󣬶�ά���������
    //5.��ӡ
    public int findLength1(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=1;j<=nums2.length;j++){
                if(nums1[i-1]==nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    //��������
    //��Ϊ��̬ת�Ʒ��̣���һ������Ҫ��һ�ε�ǰ�������Ƶ�������ڶ�����������ң���Ḳ�ǣ����Ժ��������
    //���������;���������������жϣ���Ҫ���¸�ֵΪ0
    //�������Ӧֵ�����
    //��һ��res���洢���ĳ���
    public int findLength(int[] nums1, int[] nums2) {
        int[] dp=new int[nums2.length+1];
        int res=0;
        for(int i=1;i<=nums1.length;i++){
            for(int j=nums2.length;j>0;j--){
                if(nums1[i-1]==nums2[j-1]) dp[j]=dp[j-1]+1;
                else dp[j]=0;
                res=Math.max(res,dp[j]);
            }
        }
        return res;
    }




}
