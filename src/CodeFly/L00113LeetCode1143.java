package CodeFly;

/**
 *  最长公共子序列--LeetCode:1143-代码随想录
 * 2023.10.14/11.2343

 题目:给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */

public class L00113LeetCode1143 {
    public static void main(String[] args) {

    }
    //因为有两个数组，且要找二者的公共部分，所以需要二维的dp数组，来分别确定两个子序列的范围。
    //如果当前遍历的两个数组中的数相同，则在两个数组中相对的以当前数的前一个为结尾的数的最长公共子序列的长度+1(这时候加的那个位置有可能不相等，而这个值是从前面最大
    // 的相等值保留过来的)
    //这样每次都会更新，最大的长度就是dp数组最后一个值
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是，第一个数组中下标0~i和第二个数组下标0~j为结尾的的范围中，最长公共子序列的长度为dp[i][j]
    //2.在nums[i]=nums[j]的条件下，dp[i][j]=dp[i-1][j-1]+1;
    //如果不相等，则选取之前的序列(1.数组1,0~i，数组2,0~j-1)(2.数组1,0~i-1,数组2,，0~j)这两种序列选择的最大值。
    //即dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])
    //3.初始化,二维数组中多加一行，一列作为第一行和第一列，初始化为0，即数组长度为[nums1.length+1][nums2.length+1]
    //这样初始化更方便
    //这样在状态转移时:dp[i-1][j-1]才代表数组下标i和下标j结尾的子数组
    //4.遍历顺序：纵观dp数组，是从上到下，从左到右，从左上到右下，所以遍历顺序应该是从左到右，从上到下(两个数组无先后)
    //5.打印
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1=text1.toCharArray();
        char[] t2=text2.toCharArray();
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=t1.length;i++){
            for(int j=1;j<=t2.length;j++){
                if(t1[i-1]==t2[j-1])dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }




}
