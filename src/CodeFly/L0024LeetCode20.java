package CodeFly;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有效的括号-LeetCode:20-代码随想录
 * 2023.08.30/9.48

 题目:
*样例:
 *
 * tips:
 栈：字符串数组(双高)+字符数组，增强for改进（耗时低）+foreach不开辟字符
 *
*/

public class L0024LeetCode20 {
    public static void main(String[] args) {
    }
    //自己写的(还有个空间复杂度O（1）的，直接遍历s，用charAt()获得)
    public boolean isValid1(String s) {
        Stack<Character> stack=new Stack();
        char[] sc=s.toCharArray();
        for(char i:sc){
            if(i=='('||i=='['||i=='{'){
                stack.push(i);
            }else{
                if(stack.isEmpty()) return false;
                if(i==')'&&stack.peek()=='('||i==']'&&stack.peek()=='['||i=='}'&&stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }


}
