package CodeFly;

/**
 *  判断子序列--LeetCode:392-代码随想录
 * 2023.10.15/10.18

 题目:给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余
 字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
 "aec"不是）。
 */

public class L00116LeetCode392 {
    public static void main(String[] args) {

    }
    //这题动态规划很迷，视频讲得不清不楚
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是以字符串s下标0~i结尾的,字符串t0~j结尾的公共子序列的长度是dp[i][j]
    //2.当对应的字符相等时dp[i][j]=dp[i-1][j-1]+1
    //不相等时，因为本题规定，要判断s是不是t的子序列，所以s.length<=t.length
    //所以只用回退t：dp[i][j]=dp[i][j-1]
    //3.初始化:根据dp含义，dp[0][j]和dp[j][0]都是和空字符串比较，都为0，其他位置随意
    //4.遍历顺序：从上到下，从左到右
    //5.打印
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
    //双指针
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
