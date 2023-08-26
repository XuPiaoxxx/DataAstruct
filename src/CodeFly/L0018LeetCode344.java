package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原地反转字符串-LeetCode:344-代码随想录
 * 2023.08.26/17.54

 题目:编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s
 的形式给出。不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用
 O(1) 的额外空间解决这一问题。


*样例:示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * tips:
 * 一旦涉及到交换，可以直接考虑位运算(前提是位运算不会对数据进行影响)
*/

public class L0018LeetCode344 {
    public static void main(String[] args) {

    }

    /**
     * 自己写的，很简单
     * @param s
     */
    public void reverseString1(char[] s) {
//        for(int i=0;i<s.length/2;i++){
//            char temp=s[s.length-1-i];
//            s[s.length-1-i]=s[i];
//            s[i]=temp;
//        }
        int L=0;
        int R=s.length-1;
        while(L<R){
            s[L]^=s[R];
            s[R]^=s[L];
            s[L]^=s[R];
        }
    }
}
