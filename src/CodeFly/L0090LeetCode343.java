package CodeFly;

/**
 *  �������--LeetCode:343-��������¼
 * 2023.10.5/12.01

 ��Ŀ:����һ�������� n ��������Ϊ k �� ������ �ĺͣ� k >= 2 ������ʹ��Щ�����ĳ˻���󻯡�
 ���� ����Ի�õ����˻� ��
 TIPS:

 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���---dp[i]��Ӧ���i���õ������˻�
 2������״̬ת�Ʒ���  dp[i]=Max(j*(i-j),j*dp[i-j],dp[i])
 3ȷ��dp����ĳ�ʼ����ֵdp[0]=0,dp[1]=0�����壬i>=2���ܿ�ʼ��dp[2]=1,ֻ��1+1�Ĳ�ַ���
 4ȷ������˳��---��ȷ�����i,һ��ѭ�����ٴ�j=1��ʼ���в�֣�����ѭ��������Ԥ���ǲ�2����ֵΪi/2*i/2(���),���Ա�������i-j���Ϳ���ֹͣ�ڲ�ѭ��
 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L0090LeetCode343 {
    public static void main(String[] args) {

    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<n+1;i++){
            for(int j=1;j<=i-j;j++){
                dp[i]=Math.max(j*(i-j),Math.max(j*dp[i-j],dp[i]));
            }
        }
        return dp[n];
    }
}