package CodeFly;

/**
 *  ��ͬ·��--LeetCode:62-��������¼
 * 2023.10.4/14.58

 ��Ŀ:һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����

 ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����

 ���ܹ��ж�������ͬ��·����
 TIPS:

 ��λ�ò����ģ����������������
 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���---��άdp���飬ÿ��Ԫ��ָ���±�Ϊi,j��λ���ж������߷�
 2������״̬ת�Ʒ���  dp[i][j]=dp[i-1][j]+dp[i][j-1]
 3ȷ��dp����ĳ�ʼ����ֵdp[0][j]=1,dp[i][0]=1;��һ�к͵�һ�е�Ԫ�ض�ֻ��1���߷�
 4ȷ������˳��---���ϵ��£������ң�һֱ��Ŀ��λ��dp[m-1][n-1]��
 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L0089LeetCode63 {
    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{{1,0}});
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid[0].length;i++){
            dp[0][i]=obstacleGrid[0][i]==1?0:1;
        }
        for(int i=0;i<obstacleGrid.length;i++){
            dp[i][0]=obstacleGrid[i][0]==1?0:1;
        }
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                dp[i][j]=obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
