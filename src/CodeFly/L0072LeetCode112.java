package CodeFly;

/**
 *  L0071LeetCode53-LeetCode:112-��������¼
 * 2023.09.28/17.08

 ��Ŀ:����һ���������� prices ������ prices[i] ��ʾĳ֧��Ʊ�� i ��ļ۸�

 ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�� ��� ֻ�ܳ��� һ�� ��Ʊ����Ҳ�����ȹ���Ȼ���� ͬһ�� ���ۡ�

 ���� ���ܻ�õ� ��� ���� ��


 TIPS:
 ˼·��⵽λ�ͺܼ�
 ����û������������
 һ��ѭ���������ǰֵ����ǰһ��������ֱ�Ӽ��ϲ�ֵ���������������.
 ̰��˼·��ÿ�춼��������������ֵ�Ǹ����������Ǯ����������Ҳ�Ͳ��ۼӡ�
 ֻ�����Ĳ�ֵ��


*/

public class L0072LeetCode112 {
    public static void main(String[] args) {
    }
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=1;i<prices.length;++i){ if(prices[i]>prices[i-1]) sum += prices[i] - prices[i-1]; }
        return sum;
    }

}
