package CodeFly;

/**
 *  不同的子序列--LeetCode:115-代码随想录
 * 2023.10.15/17.49

 题目:给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 */

public class L00117LeetCode115 {
    public static void main(String[] args) {

    }
    //这题动态规划很迷，视频讲得不清不楚
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是在字符串s中以i结尾的序列中以j结尾的t的子序列的个数
    //2.s字符串跟t字符串如果增添了一个相同的字符，那么你现在以这个字符串结尾的s字符串
    // 中出现以这个字符串结尾的t字符串的个数就会有两个来源，一就是原本不加这个字符，s字
    // 符串以s【i-2】结尾时出现t字符串以t【j-2】结尾的个数，也就是dp【i-1】【j-1】的值，
    // 就不需要考虑s【i-1】跟t【j-1】。二就是由于t新增添了这个字符，s字符串以s【i-2】结尾时
    //                if(sArr[i-1]==tArr[j-1]) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
    //                else dp[i][j]=dp[i-1][j];
    //3.初始化:根据dp数组的含义，dp[i][0]是字符串0~i中含有空字符串的个数为1,dp[0][j]是空字符串含有0~j的t字符串个数为0
    //4.遍历顺序：从上到下，从左到右
    //5.打印
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
