package CodeFly;

/**
 *  最长回文子序列--LeetCode:516-代码随想录
 * 2023.10.17/11.48

 题目:给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */

public class L00121LeetCode516 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是下标从i到j的字符串中回文串的最大个数
    //2.状态转移方程:
    //如果当前子字符串长度为1或者2，且对应字符相等，则属于单独判断的回文串，dp[i][j]=1或2;
    //否则当前两字符相等，那么当前区间回文串的最大长的为dp[i][j]=dp[i+1][j-1]+2;
    //否则dp[i][j]=max(dp[i+1][j],dp[i][j-1]),从对应字符串区间来看就是取不包括当前不相等字符的最长回文子序列长度(dp[i+1][j-1]包括在其中)
    //3.初始化:全部初始化为0，（或者dp[i][i]表示当前字符为同一个字符，也是回文串，长度为1）
    //4.遍历顺序：由状态转移方程可知需要按照推导方向来遍历，i所以从下到上，j从左到右
    //5.打印
    public int longestPalindromeSubseq(String s) {
        char[] ch=s.toCharArray();
        int dp[][]=new int[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(ch[i]==ch[j]){
                    if(j-i==0)dp[i][j]=1;
                    else if(j-i==1)dp[i][j]=2;
                    else dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    if(i<s.length()-1&&j>0){
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
