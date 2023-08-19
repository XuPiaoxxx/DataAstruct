package CodeFly;

/**
 * 螺旋矩阵2-LeetCode:59-代码随想录
 * 2023.08.19/19:08
 * 问题:给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *样例:
 示例 1：
 输入：n = 3
 输出：[[1,2,3],[8,9,4],[7,6,5]]
 示例 2：
 输入：n = 1
 输出：[[1]]
 *
 * tips:
 * 圈数=n/2--每转一圈，边长-2，看有多少圈就是除。
 *
 *
 */
public class L005LeetCode59 {
    public static void main(String[] args) {

    }

    /**
     * 自己写的
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
     * 看过代码随想录后自己改写的，for循环和while循环可改写，
     * 可以凭借圈数来控制循环次数和最终中心位置填不填(n的奇偶)
     * 代码简洁了一点?
     * @param n
     * @return
     */
    public static int[][] generateMatrix2(int n) {
        //创建对应大小的二维数组
        int[][] matrix=new int[n][n];
        //圈数:圈数=n/2--每转一圈，边长-2，算有多少圈就是除
        int circle=n/2;
        //x控制行，y控制列
        int x=0;
        int y=0;
        //作为赋值的数，每次赋值后++
        int i=1;
        //flag控制循环条件，等同于代码随想录的offset
        int flag=1;
        while(circle>0){
            //依次转圈赋值，左闭右开
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
        //如果是奇数，则此时最中心未赋值。
        if(n%2!=0){
            matrix[x][y]=i;
        }
        return matrix;
    }
}
