package CodeFly;

/**
 *  ������Ʊ�����ʱ����������--LeetCode:714-��������¼
 * 2023.10.13/12.16

 ��Ŀ:����һ���������� prices������ prices[i]��ʾ�� i ��Ĺ�Ʊ�۸� ������ fee �����˽��׹�Ʊ���������á�
 ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 ���ػ����������ֵ��
 ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�

 TIPS:
�������������ѵĸ���漰����ÿ�����붼�ж���Ļ��ѣ����Կ����ǹ���۸��һ���֡�
 */

public class L00109LeetCode714 {
    public static void main(String[] args) {

    }
    //״̬dp��̬�滮�ⷨ:
    //�ο���Ʊ2���������޴ε��򣬲���ÿ�����м���������
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp0=-prices[0]-fee,dp1=0;
        for(int i=1;i<n;i++){
            dp0=Math.max(dp0,dp1-prices[i]-fee);
            dp1=Math.max(dp1,dp0+prices[i]);
        }
        return dp1;
    }




}
