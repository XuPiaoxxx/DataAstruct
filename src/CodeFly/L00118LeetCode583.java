package CodeFly;

/**
 *  两个字符串的删除操作--LeetCode:583-代码随想录
 * 2023.10.16/13.42

 题目:给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 每步 可以删除任意一个字符串中的一个字符。
 */

public class L00118LeetCode583 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是使得word1从0~i与word2从0~j变成相等的字符串所要删除的最小的字符个数
    //2.如当前遍历到的位置i和j的字符相同，则不做删除操作，直接继承两个字符串上一个位置的值
    //  dp[i][j]=dp[i-1][j-1]
    //如果当前位置不相同，则需要进行删除操作，操作计数加1，因为要求最小的操作数，所以对三种情况取最小值。
    //1.删除word1当前字符，则值等于dp[i-1][j],或者删除word2，(或者两个都删除,操作数加2，但是这种条件在上一个dp[i-1][j]的分支中以及走过，dp[i-1][j]+1=dp[i-1][j-1]+2)
    //3.初始化:dp[i][0]代表字符串1的0~i变成空字符串的删除操作次数，可知为i，dp[0][j]同理
    //4.遍历顺序：从上到下，从左到右
    //5.打印
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
                else dp[i][j]=Math.min(dp[i][j-1]+1,Math.min(dp[i-1][j]+1,dp[i-1][j-1]+2));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
