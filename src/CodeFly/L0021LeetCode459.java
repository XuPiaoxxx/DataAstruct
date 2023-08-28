package CodeFly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 重复的子字符串-LeetCode:459-代码随想录
 * 2023.08.28/19.27

 题目:
*样例:
 *
 * tips:
 *KMP,KMP的原理知道
 *
 * 但是这一题的next数组不能右移，因为不是去匹配，要记录当前字符串包含前一个
 * 字符的子串的最大公共前后缀长度，右移则会丢失最后的最大公共前后缀长度。
 *
 * ，这一题的原理:
 * 字符串中不包含最长公共前后缀的子串就是重复字串(前提是字符串长度可以整除子串长度)
 * next  如果 next[len - 1] != 0，则说明字符串有最长相同的前后缀（就
 * 是字符串里的前缀子串和后缀子串相同的最长长度）。
 * 最长相等前后缀的长度为：next[len - 1] 。(这里的next数组是以统一减一的方式计算的，因此
 * 需要+1，两种计算next数组的具体区别看这里：字符串：KMP算法精讲)
 * 如果len % (len - (next[len - 1])) == 0 ，则说明 (数组长度-最长相等前后缀的长度)
 * 正好可以被 数组的长度整除，说明有该字符串有重复的子字符串。

 *
*/

public class L0021LeetCode459 {
    public static void main(String[] args) {
        repeatedSubstringPattern3("abac");
    }
    //自己的暴力解法
    public static boolean repeatedSubstringPattern1(String s) {
        String temp;
        boolean flag;
        for(int i=1;i<=s.length()/2;i++){
            flag=true;
            temp=s.substring(0,i);
            for(int j=i;j<=s.length();j+=temp.length()){
                if(s.length()%temp.length()!=0){
                    flag=false;
                    break;
                }
                if(!temp.equals(s.substring(j-i,j))){
                    flag=false;
                }
            }
            if(flag) return true;
        }
        return false;
    }

    //s+s解法
    public boolean repeatedSubstringPattern2(String s) {
        StringBuilder sb=new StringBuilder();
        return sb
                .append(s)
                .append(s)
                .delete(0,1)
                .delete(sb.length()-1,sb.length())
                .toString()
                .contains(s)
                ?true:false;
    }

    //KMP
    public static void getNext(int[] next,String s){
        int k=0;
        next[0]=0;
        for(int j=1;j<s.length();j++){
            while(k>0&&s.charAt(k)!=s.charAt(j)){
                k=next[k-1];
            }
            if(s.charAt(k)==s.charAt(j)){
                k++;
            }
            next[j]=k;
        }
    }
    public static boolean repeatedSubstringPattern3(String s) {
        if(s.length()==0) return false;

        int[] next=new int[s.length()];
        getNext(next,s);

        if(next[s.length()-1]!=0&&s.length()%(s.length()-next[s.length()-1])==0){
            return true;
        }
        return false;
    }
}
