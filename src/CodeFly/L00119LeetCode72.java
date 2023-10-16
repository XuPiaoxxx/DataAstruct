package CodeFly;

/**
 *  编辑距离--LeetCode:72-代码随想录
 * 2023.10.16/20.28

 题目:给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 你可以对一个单词进行如下三种操作：
 插入一个字符
 删除一个字符
 替换一个字符
 */

public class L00119LeetCode72 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是使得word1从0~i与word2从0~j变成相等的字符串所要进行操作的次数
    //2.如当前遍历到的位置i和j的字符相同，则不做操作，操作数等同于前一部分的两数组
    //  dp[i][j]=dp[i-1][j-1]
    //如果当前位置不相同，则需要进行操作，通过实操可知，删除和新增是互逆的，所以看作同类操作，替换又是一种操作。
    //dp[i][j]=max(dp[i][j-1]+1,dp[i-1][j]+1,dp[i-1][j-1]+1)---前两个都是在删除当前遍历的某一个字符后，在不看这个字符的操作数基础上+1表示删除操作，后面是在前部分两个字符串
    //最小操作数的基础上进行修改操作，只需修改一个字符为另一个，所以+1
    //3.初始化:dp[i][0]代表字符串1的0~i变成空字符串的操作次数(删除)，可知为i，dp[0][j]同理
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
                else dp[i][j]=Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
