package CodeFly;

/**
 *  �ж�������--LeetCode:392-��������¼
 * 2023.10.15/10.18

 ��Ŀ:�����ַ��� s �� t ���ж� s �Ƿ�Ϊ t �������С�

 �ַ�����һ����������ԭʼ�ַ���ɾ��һЩ��Ҳ���Բ�ɾ�����ַ������ı�ʣ��
 �ַ����λ���γɵ����ַ����������磬"ace"��"abcde"��һ�������У���
 "aec"���ǣ���
 */

public class L00116LeetCode392 {
    public static void main(String[] args) {

    }
    //���⶯̬�滮���ԣ���Ƶ���ò��岻��
    //״̬dp��̬�滮�ⷨ:
    //1.dp[i][j]�ĺ��������ַ���s�±�0~i��β��,�ַ���t0~j��β�Ĺ��������еĳ�����dp[i][j]
    //2.����Ӧ���ַ����ʱdp[i][j]=dp[i-1][j-1]+1
    //�����ʱ����Ϊ����涨��Ҫ�ж�s�ǲ���t�������У�����s.length<=t.length
    //����ֻ�û���t��dp[i][j]=dp[i][j-1]
    //3.��ʼ��:����dp���壬dp[0][j]��dp[j][0]���ǺͿ��ַ����Ƚϣ���Ϊ0������λ������
    //4.����˳�򣺴��ϵ��£�������
    //5.��ӡ
    public boolean isSubsequence(String s, String t) {
        int sLength=s.length();
        int tLength=t.length();
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        int[][] dp=new int[sLength+1][tLength+1];
        for(int i=1;i<=sLength;i++){
            for(int j=1;j<=tLength;j++){
                if(sArr[i-1]==tArr[j-1])dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=dp[i][j-1];
            }
        }
        return dp[sLength][tLength]==sLength;
    }
    //˫ָ��
    public boolean isSubsequence1(String s, String t) {
        int n=s.length();
        int flag=0;
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        for(int i=0,j=0;i<t.length()&&j<s.length();){
            if(ct[i]==cs[j]){
                i++;
                j++;
                flag++;
            }else{
                i++;
            }
        }
        return flag==n;
    }
}
