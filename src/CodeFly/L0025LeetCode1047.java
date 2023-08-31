package CodeFly;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项-LeetCode:1047-代码随想录
 * 2023.08.31/20.32

 题目:给出由小写字母组成的字符串 S，重复项删除操作会选择两个
 相邻且相同的字母，并删除它们。在 S 上反复执行重复项删除操作
 ，直到无法继续删除。在完成所有重复项删除操作后返回最终的字符串。
 答案保证唯一。
*样例:
 *
 * tips:
 栈：队列实现(可以用StringBuilder直接充当队列，降低空间复杂度)
 *
*/

public class L0025LeetCode1047 {
    public static void main(String[] args) {
    }
    //参考了答案，以后自己用栈实现，理解一下。
    public String removeDuplicates(String s) {
        StringBuilder stack=new StringBuilder();
        int top=-1;
        for(int i=0;i<s.length();i++){
            if(top>-1&&stack.charAt(top)==s.charAt(i)){
                stack.deleteCharAt(top);
                top--;
            }else{
                stack.append(s.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }


}
