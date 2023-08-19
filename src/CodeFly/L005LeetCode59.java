package CodeFly;

/**
 * ��������2-LeetCode:59-��������¼
 * 2023.08.19/19:08
 * ����:����һ�������� n ������һ������ 1 �� n2 ����Ԫ�أ�
 * ��Ԫ�ذ�˳ʱ��˳���������е� n x n �����ξ��� matrix ��
 *����:
 ʾ�� 1��
 ���룺n = 3
 �����[[1,2,3],[8,9,4],[7,6,5]]
 ʾ�� 2��
 ���룺n = 1
 �����[[1]]
 *
 * tips:
 * Ȧ��=n/2--ÿתһȦ���߳�-2�����ж���Ȧ���ǳ���
 *
 *
 */
public class L005LeetCode59 {
    public static void main(String[] args) {

    }

    /**
     * �Լ�д��
     * @param n
     * @return
     */
    public static int[][] generateMatrix1(int n) {
        int[][] matrix=new int[n][n];
        int x=0;
        int y=0;
        int flag=1;
        if(n%2==0){
            for(int i=1;i<=n*n;){
                while(y!=n-flag){
                    matrix[x][y++]=i++;
                }
                while(x!=n-flag){
                    matrix[x++][y]=i++;
                }
                while(y!=flag-1){
                    matrix[x][y--]=i++;
                }
                while(x!=flag-1){
                    matrix[x--][y]=i++;
                }
                x++;
                y++;
                flag++;
            }
        }else{
            for(int i=1;i<=n*n-1;){
                while(y!=n-flag){
                    matrix[x][y++]=i++;
                }
                while(x!=n-flag){
                    matrix[x++][y]=i++;
                }
                while(y!=flag-1){
                    matrix[x][y--]=i++;
                }
                while(x!=flag-1){
                    matrix[x--][y]=i++;
                }
                x++;
                y++;
                flag++;
            }
            matrix[x][y]=n*n;
        }
        return matrix;
    }

    /**
     * ������������¼���Լ���д�ģ�forѭ����whileѭ���ɸ�д��
     * ����ƾ��Ȧ��������ѭ����������������λ�����(n����ż)
     * ��������һ��?
     * @param n
     * @return
     */
    public static int[][] generateMatrix2(int n) {
        //������Ӧ��С�Ķ�ά����
        int[][] matrix=new int[n][n];
        //Ȧ��:Ȧ��=n/2--ÿתһȦ���߳�-2�����ж���Ȧ���ǳ�
        int circle=n/2;
        //x�����У�y������
        int x=0;
        int y=0;
        //��Ϊ��ֵ������ÿ�θ�ֵ��++
        int i=1;
        //flag����ѭ����������ͬ�ڴ�������¼��offset
        int flag=1;
        while(circle>0){
            //����תȦ��ֵ������ҿ�
            while(y!=n-flag){
                matrix[x][y++]=i++;
            }
            while(x!=n-flag){
                matrix[x++][y]=i++;
            }
            while(y!=flag-1){
                matrix[x][y--]=i++;
            }
            while(x!=flag-1){
                matrix[x--][y]=i++;
            }
            x++;
            y++;
            flag++;
            circle--;
        }
        //��������������ʱ������δ��ֵ��
        if(n%2!=0){
            matrix[x][y]=i;
        }
        return matrix;
    }
}
