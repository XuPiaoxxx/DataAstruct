package CodeFly;

/**
 *  ����������--LeetCode:53-��������¼
 * 2023.10.14/12.54

 ��Ŀ:����һ���������� nums ��
 �����ҳ�һ���������͵���������
 �飨���������ٰ���һ��Ԫ�أ�������
 �����͡�
 ������ �������е�һ���������֡�
 */

public class L00115LeetCode53 {
    public static void main(String[] args) {

    }
    //̰�ĵ�˼·����̬�滮�Ľⷨ
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i]�ĺ������������±�i��β������������������dp[i]
    //2.dp[i]=max(dp[[i-1]+nums[i],nums[i])
    //3.��ʼ��:dp[0]�ĺ�������dp[0]��β����������󳤶ȣ���ǰֻ��1����������dp[0]=nums[0]
    //4.����˳��״̬ת�Ʒ��̿��Եó���ǰdpֵ��Ҫǰһ������Ϊ���������Դ�����
    //5.��ӡ
    public int maxSubArray0(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int res=dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    //̰�Ľⷨ
    //һ������resͳ�����������ͣ�һ��countͳ�Ƶ�ǰ����������������
    //һ��count<0������ⲿ������Ժ���û����ӱ������ԣ�������λ0������ͳ��
    public int maxSubArray1(int[] nums) {
        int res=nums[0];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            if(count>res) res=count;
            if(count<0) count=0;
        }
        return res;
    }




}
