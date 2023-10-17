package CodeFly;

/**
 *  回文子串--LeetCode:647-代码随想录
 * 2023.10.17/10.23

 题目:给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 回文字符串 是正着读和倒过来读一样的字符串。
 子字符串 是字符串中的由连续字符组成的一个序列。
 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */

public class L00120LeetCode647 {
    public static void main(String[] args) {

    }
    //状态dp动态规划解法:
    //1.dp[i][j]的含义是下标从i到j的字符串是不是回文串(为true和boolean)
    //2.状态转移方程:
    //如果当前子字符串长度为1或者2，且对应字符相等，则属于特殊情况的回文串，dp[i][j]=true;
    //否则如果当前区间i~j包含的上一个区间i+1~j-1是回文串也就是true，且当前对应字符相等，那么当前区间也是回文串dp[i][j]=true;
    //否则设为false
    //3.初始化:因为本题状态转移没有数字相加的需求，只有更改和判断状态，所以全部初始化为false
    //4.遍历顺序：由状态转移方程可知需要按照推导方向来遍历，i所以从下到上，j从左到右
    //5.打印
    public int countSubstrings(String s) {
        char[] ch=s.toCharArray();
        boolean[][] dp=new boolean[s.length()][s.length()];
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(ch[i]==ch[j]){
                    if(j-i<2){
                        dp[i][j]=true;
                        count++;
                    }
                    else if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
