package CodeFly;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  单词拆分--LeetCode:139-代码随想录
 * 2023.10.10/11.14

 题目:给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

完全背包问题!!!!!!
 转化思路:
 s字符串看成背包，每个String字符串看成物品，看能不能按照顺序放满。

 TIPS:

 严格按照动态规划5步来分析:
 1确定dp数组及对应下标的含义--dp[j]-字符串s的0~j部分能否由添加的物品(字符串)组成，对应的dp值为true或false

 2分析出状态转移方程--求最小的放入的硬币数  if(字符串j~i部分是否能在字典中找到&&前一部分dp[j]是否为true成立) dp[i]=true;

 3确定dp数组的初始化赋值--dp[0]，0长度不符合题目的定义，但是为了状态转移方程的实现需要设置为true，其他默认为false，处理过程中成立再设置为true

 4确定遍历顺序--本题需要保证字典中靠后的数也有可能出现在前面，所以求排列数符合题意
 先遍历物品时候，会出现字典中靠前的物品出现在后面，因为对应的dp[j]也就是前一个区间的字符串还没遍历到，没被赋值为true，所以当前dp[i]也不能被赋值为true
 不符合题意

 5打印dp数组(没有在线oj，需要判断dp数组是否符合预期) --无所谓
 */

public class L00100LeetCode139 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){//防止无意义的循环处理
            for(int j=0;j<i&&!dp[i];j++){//!dp[i]的作用是，只要找到j~i位置上的字符串在set中，dp[i]为true，可以直接进行背包下一个位置
                if(set.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                }
            }
        }
        return dp[s.length()];
    }
    //大佬解法
    //1.直接使用List的contains方法，节省了set空间
    //2.遍历对应0~i位置从后向前遍历，因为到后面，s的长度会远大于字典中字符串的长度，所以从后向前遍历能剪枝浪费的运行
    //3.一旦找到true直接break，防止多余的资源浪费。
    public boolean wordBreak1(String s, List<String> wordDict) {
        //转化为是否可以用 wordDict 中的词组合成 s，完全背包问题
        //有顺序的完全背包问题，先遍历target，再遍历背包
        //dp[i]表示：字符串的前i个字符是否可以由背包中的单词组成
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        //初始化d
        dp[0] = true;
        // 如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
        // 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。

        //这里从1开始遍历是因为substring左开右闭
        for(int i = 1; i <= len; i++){
            //倒着遍历，考虑到单词长度可能远小于target长度，倒着遍历效率更高
            for(int j = i - 1; j >= 0; j--){
                //如果dp[j]为false，已经不符合题意了，继续下一个比较
                if(dp[j] == false) continue;
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    //如果为true，则必定为true，直接break
                    dp[i] = true;
                    break;
                }

            }

        }
        return dp[len];
    }

}
