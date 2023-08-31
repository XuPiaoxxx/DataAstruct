package CodeFly;

import java.util.Stack;

/**
 * ɾ���ַ����е����������ظ���-LeetCode:1047-��������¼
 * 2023.08.31/20.32

 ��Ŀ:������Сд��ĸ��ɵ��ַ��� S���ظ���ɾ��������ѡ������
 ��������ͬ����ĸ����ɾ�����ǡ��� S �Ϸ���ִ���ظ���ɾ������
 ��ֱ���޷�����ɾ��������������ظ���ɾ�������󷵻����յ��ַ�����
 �𰸱�֤Ψһ��
*����:
 *
 * tips:
 ջ������ʵ��(������StringBuilderֱ�ӳ䵱���У����Ϳռ临�Ӷ�)
 *
*/

public class L0025LeetCode1047 {
    public static void main(String[] args) {
    }
    //�ο��˴𰸣��Ժ��Լ���ջʵ�֣����һ�¡�
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
