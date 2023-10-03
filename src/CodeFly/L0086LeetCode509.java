package CodeFly;

/**
 *  ��¥��-LeetCode:70-��������¼
 * 2023.10.3/14.28

 ��Ŀ:������������¥�ݡ���Ҫ n ������ܵ���¥����

 ÿ��������� 1 �� 2 ��̨�ס����ж����ֲ�ͬ�ķ�����������¥���أ�
 TIPS:

 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���---��i������Ԫ���ǵ���ǰ̨�׵����з���
 2������״̬ת�Ʒ���  dp[i]=dp[i-1]+dp[i-2]
 3ȷ��dp����ĳ�ʼ����ֵdp[0]=0,dp[1]=1��dp[2]=2;
 4ȷ������˳��---һ�α�������������
 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L0086LeetCode509 {
    public static void main(String[] args) {
    }
    public int climbStairs(int n) {
        if(n<3) return n;
        // int[] dp=new int[n+1];
        // dp[0]=0;
        // dp[1]=1;
        // dp[2]=2;
        int a=1;
        int b=2;
        for(int i=3;i<n+1;i++){
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
    }
}
