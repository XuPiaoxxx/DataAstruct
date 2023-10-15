package CodeFly;

/**
 *  ��ͬ��������--LeetCode:115-��������¼
 * 2023.10.15/17.49

 ��Ŀ:���������ַ��� s �� t ��ͳ�Ʋ������� s �� ������ �� t ���ֵĸ����������Ҫ�� 109 + 7 ȡģ��
 */

public class L00117LeetCode115 {
    public static void main(String[] args) {

    }
    //���⶯̬�滮���ԣ���Ƶ���ò��岻��
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�ĺ��������ַ���s����i��β����������j��β��t�������еĸ���
    //2.s�ַ�����t�ַ������������һ����ͬ���ַ�����ô������������ַ�����β��s�ַ���
    // �г���������ַ�����β��t�ַ����ĸ����ͻ���������Դ��һ����ԭ����������ַ���s��
    // ������s��i-2����βʱ����t�ַ�����t��j-2����β�ĸ�����Ҳ����dp��i-1����j-1����ֵ��
    // �Ͳ���Ҫ����s��i-1����t��j-1��������������t������������ַ���s�ַ�����s��i-2����βʱ
    //                if(sArr[i-1]==tArr[j-1]) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    //                else dp[i][j]=dp[i-1][j];
    //3.��ʼ��:����dp����ĺ��壬dp[i][0]���ַ���0~i�к��п��ַ����ĸ���Ϊ1,dp[0][j]�ǿ��ַ�������0~j��t�ַ�������Ϊ0
    //4.����˳�򣺴��ϵ��£�������
    //5.��ӡ
    public int numDistinct(String s, String t) {
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] arr:dp){
            arr[0]=1;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(sArr[i-1]==tArr[j-1]) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
