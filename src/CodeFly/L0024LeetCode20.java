package CodeFly;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��Ч������-LeetCode:20-��������¼
 * 2023.08.30/9.48

 ��Ŀ:
*����:
 *
 * tips:
 ջ���ַ�������(˫��)+�ַ����飬��ǿfor�Ľ�����ʱ�ͣ�+foreach�������ַ�
 *
*/

public class L0024LeetCode20 {
    public static void main(String[] args) {
    }
    //�Լ�д��(���и��ռ临�Ӷ�O��1���ģ�ֱ�ӱ���s����charAt()���)
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
