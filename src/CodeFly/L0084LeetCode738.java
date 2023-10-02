package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  单调递增的数字-LeetCode:738-代码随想录
 * 2023.10.2/10.53

 题目:当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

 TIPS:

 自己完全想不出来，代码随想录解法:
 两位两位去比较
 如果前面的数比后面的数大，则前面-1，后面改为9
 为了保持数变9的连贯性，用flag记录都为9的开始位置，否则如果中间处理部分符合条件的数，会出现断9的情况，不符合题意

 除此之外，本题中Stirng的valueOf方法和Integer的ParseInt方法都值得记住，对于算法和工程都很有帮助

 用char数组原地操作比频繁使用ParseInt比较大小效率更高

 Integer.parseInt(String s)这个方法在处理字符串时有一些细节要注意，比如"030"会转换成30

 */

public class L0084LeetCode738 {
    public static void main(String[] args) {
    }
    public int monotoneIncreasingDigits(int n) {
        String s=String.valueOf(n);
        char[] chars=s.toCharArray();
        int flag=chars.length;
        for(int i=chars.length-2;i>=0;i--){
            if(chars[i]>chars[i+1]){
                chars[i]--;
                flag=i+1;
            }
        }
        for(int i=flag;i<chars.length;i++){
            chars[i]='9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
