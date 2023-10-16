package CodeFly;

/**
 *  �༭����--LeetCode:72-��������¼
 * 2023.10.16/20.28

 ��Ŀ:������������ word1 �� word2�� �뷵�ؽ� word1 ת���� word2 ��ʹ�õ����ٲ�����  ��
 ����Զ�һ�����ʽ����������ֲ�����
 ����һ���ַ�
 ɾ��һ���ַ�
 �滻һ���ַ�
 */

public class L00119LeetCode72 {
    public static void main(String[] args) {

    }
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�ĺ�����ʹ��word1��0~i��word2��0~j�����ȵ��ַ�����Ҫ���в����Ĵ���
    //2.�統ǰ��������λ��i��j���ַ���ͬ��������������������ͬ��ǰһ���ֵ�������
    //  dp[i][j]=dp[i-1][j-1]
    //�����ǰλ�ò���ͬ������Ҫ���в�����ͨ��ʵ�ٿ�֪��ɾ���������ǻ���ģ����Կ���ͬ��������滻����һ�ֲ�����
    //dp[i][j]=max(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1)---ǰ����������ɾ����ǰ������ĳһ���ַ����ڲ�������ַ��Ĳ�����������+1��ʾɾ����������������ǰ���������ַ���
    //��С�������Ļ����Ͻ����޸Ĳ�����ֻ���޸�һ���ַ�Ϊ��һ��������+1
    //3.��ʼ��:dp[i][0]�����ַ���1��0~i��ɿ��ַ����Ĳ�������(ɾ��)����֪Ϊi��dp[0][j]ͬ��
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
                else dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
