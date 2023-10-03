package CodeFly;

/**
 *  ʹ����С������¥��-LeetCode:746-��������¼
 * 2023.10.3/15.23

 ��Ŀ:����һ���������� cost ������ cost[i] �Ǵ�¥�ݵ� i ��̨����������Ҫ֧���ķ��á�һ����֧���˷��ã�����ѡ��������һ����������̨�ס�
 �����ѡ����±�Ϊ 0 ���±�Ϊ 1 ��̨�׿�ʼ��¥�ݡ�
 ������㲢���شﵽ¥�ݶ�������ͻ��ѡ�
 TIPS:

 ��λ�ò����ģ����������������
 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���---��i������Ԫ��ָ��ǰ̨��Ϊ¥��������ǰλ�õ���С����
 2������״̬ת�Ʒ���  dp[i]=Min(dp[i-1]+cost[i-1]��dp[i-2]+cost[i-2])
 3ȷ��dp����ĳ�ʼ����ֵdp[0]=0,dp[1]=0;
 4ȷ������˳��---һ�α�������������
 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L0087LeetCode746 {
    public static void main(String[] args) {
    }
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length<2)return 0;
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }
}
