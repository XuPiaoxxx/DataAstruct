package CodeFly;

/**
 *  ������Ʊ�����ʱ�� III--LeetCode:123-��������¼
 * 2023.10.12/10.51

 ��Ŀ:����һ�����飬���ĵ� i ��Ԫ����һ֧�����Ĺ�Ʊ�ڵ� i ��ļ۸�

 ���һ���㷨�����������ܻ�ȡ�������������������� ���� ���ס�

 ע�⣺�㲻��ͬʱ�����ʽ��ף���������ٴι���ǰ���۵�֮ǰ�Ĺ�Ʊ����

 TIPS:
�������ƽ�������������Σ���˻�������״̬��������ǰ������������
 */

public class L00106LeetCode123 {
    public static void main(String[] args) {

    }
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�����˵�i����ѡ��״̬jӵ�е�����j=0��һ�γ��й�Ʊ��j=1��һ�β����г��й�Ʊ��j=3�ڶ��γ��й�Ʊ,j=4�ڶ��β����й�Ʊ
    //2.��Ϊ��4��״̬������ά��һ����ά���飬ÿ��һά���鳤��Ϊ4.(ʵ���ϻ���һ���տ�ʼδ���е�״̬��������ȡֵ����0������ֱ��ʡ�ԣ���һ�γ���ֱ����0�Ļ����Ͻ��м�)
    //��Ҫ������״̬�������״̬ת�Ʒ��̣�
    //��һ�γֹ� ������ѡ��
    //��һ�β��ֹ�,����ͬ��
    //�ڶ��γֹ�
    //�ڶ��β��ֹ�
    //ͬ��ȡ�����е����ֵ
    //3.��ʼ����dp[0][0]Ϊ��һ�γֹɣ�ֻ��Ϊ-prices[0],dp[0][1]Ϊ��һ�β��ֹɣ�Ϊ0�����������dp[0][2]�ڶ��γֹɣ���һ��ʱ��������������Ϊ-price[0]
    //dp[0][3]Ϊ�ڶ��β����й�Ʊ����һ����˵�����������ˣ�Ϊ0
    //��󷵻�ֵ������ȡ����һ�β����к͵ڶ��β����е����ֵ�����������һ�β�����������ߣ����Խ��ڶ��β����п�������������������ȣ��ܵ���˵ֱ�ӷ��صڶ���δ���оͿ�
    //4.��Ϊ״̬ת���У���һ����Ҫǰһ�������״̬����Ϣ�����԰��մ����ң�������б�����

    //5.��ӡ
    //���涯̬�滮˼·
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][4];
        dp[0][0]=-prices[0];
        dp[0][1]=0;
        dp[0][2]=-prices[0];
        dp[0][3]=0;
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
        }
        return dp[n-1][3];
    }
    //�ռ��Ż�
    //dp[2]���õ��ǵ����dp[1]�� �����Ҳ�ǶԵġ�
    //�����򵥽���һ�£�
    //dp[1] = max(dp[1], dp[0] - prices[i]); ���dp[1]ȡdp[1]�������������Ʊ��״̬����ô dp[2] = max(dp[2], dp[1] + prices[i]);��dp[1] + prices[i] ���ǽ���������
    //���dp[1]ȡdp[0] - prices[i]�����������Ʊ����ôdp[2] = max(dp[2], dp[1] + prices[i]);�е�dp[1] + prices[i]�൱���ǽ�����������Ʊ��һ��һ������Ϊ0���������ֽ�û��Ӱ�졣�൱�ڽ��������Ʊ��������Ʊ������û�в�������������������Ʊ��״̬�ˡ�
    //����д������ȥ�򵥣���ʵ˼·���ƣ�����������ôд����ô˼���������װ��Լ��ƽ�ȥ��
    public int maxProfit1(int[] prices) {
        int[] dp = new int[4];
        // �洢���ν��׵�״̬������
        // dp[0]������һ�ν��׵�����
        dp[0] = -prices[0];
        // dp[1]������һ�ν��׵�����
        dp[1] = 0;
        // dp[2]�����ڶ��ν��׵�����
        dp[2] = -prices[0];
        // dp[3]�����ڶ��ν��׵�����
        dp[3] = 0;
        for(int i = 1; i <= prices.length; i++){
            // Ҫô���ֲ��䣬Ҫôû�о������˾���
            dp[0] = Math.max(dp[0], -prices[i-1]);
            dp[1] = Math.max(dp[1], dp[0]+prices[i-1]);
            // ���Ѿ��ǵڶ��ν����ˣ����Եü���ǰһ�ν�������ȥ���ջ�
            dp[2] = Math.max(dp[2], dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3], dp[2]+ prices[i-1]);
        }
        return dp[3];
    }



}