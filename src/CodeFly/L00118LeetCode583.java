package CodeFly;

/**
 *  �����ַ�����ɾ������--LeetCode:583-��������¼
 * 2023.10.16/13.42

 ��Ŀ:������������ word1 �� word2 ������ʹ�� word1 ��  word2 ��ͬ�������С������
 ÿ�� ����ɾ������һ���ַ����е�һ���ַ���
 */

public class L00118LeetCode583 {
    public static void main(String[] args) {

    }
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�ĺ�����ʹ��word1��0~i��word2��0~j�����ȵ��ַ�����Ҫɾ������С���ַ�����
    //2.�統ǰ��������λ��i��j���ַ���ͬ������ɾ��������ֱ�Ӽ̳������ַ�����һ��λ�õ�ֵ
    //  dp[i][j]=dp[i-1][j-1]
    //�����ǰλ�ò���ͬ������Ҫ����ɾ������������������1����ΪҪ����С�Ĳ����������Զ��������ȡ��Сֵ��
    //1.ɾ��word1��ǰ�ַ�����ֵ����dp[i-1][j],����ɾ��word2��(����������ɾ��,��������2������������������һ��dp[i-1][j]�ķ�֧���Լ��߹���dp[i-1][j]+1=dp[i-1][j-1]+2)
    //3.��ʼ��:dp[i][0]�����ַ���1��0~i��ɿ��ַ�����ɾ��������������֪Ϊi��dp[0][j]ͬ��
    //4.����˳�򣺴��ϵ��£�������
    //5.��ӡ
    public int minDistance(String word1, String word2) {
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=word2.length();i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(w1[i-1]==w2[j-1])dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i][j-1]+1,Math.min(dp[i-1][j]+1,dp[i-1][j-1]+2));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
