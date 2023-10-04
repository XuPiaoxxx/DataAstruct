package CodeFly;

/**
 *  ��ͬ·�� II--LeetCode:63-��������¼
 * 2023.10.4/15:53

 ��Ŀ:һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����

 ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish������

 ���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����

 �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
 TIPS:

 �ϸ��ն�̬�滮5��������:
 1ȷ��dp���鼰��Ӧ�±�ĺ���---��άdp���飬ÿ��Ԫ��ָ���±�Ϊi,j��λ���ж������߷�
 2������״̬ת�Ʒ���  dp[i][j]=dp[i-1][j]+dp[i][j-1]
        �����ǰλ�����ϰ�����obs[i][j]==1,��ô��Ӧdpλ��Ϊ0
 3ȷ��dp����ĳ�ʼ����ֵdp[0][j]=1,dp[i][0]=1;��һ�к͵�һ�е�Ԫ�ض�ֻ��1���߷�
    �����漰���ϰ��������һ�к͵�һ�г�ʼ��ʱ�����ϰ�����ǰλ�ü�֮��ȫ����ֵΪ0
 4ȷ������˳��---���ϵ��£������ң�һֱ��Ŀ��λ��dp[m-1][n-1]��
 5��ӡdp����(û������oj����Ҫ�ж�dp�����Ƿ����Ԥ��) --����ν
 */

public class L0088LeetCode62 {
    public static void main(String[] args) {
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]==1) break;
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1) break;
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
