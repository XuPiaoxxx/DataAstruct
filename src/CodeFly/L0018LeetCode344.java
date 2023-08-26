package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ԭ�ط�ת�ַ���-LeetCode:344-��������¼
 * 2023.08.26/17.54

 ��Ŀ:��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� s
 ����ʽ��������Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ��
 O(1) �Ķ���ռ�����һ���⡣


*����:ʾ�� 1��
 * ���룺s = ["h","e","l","l","o"]
 * �����["o","l","l","e","h"]
 * ʾ�� 2��
 * ���룺s = ["H","a","n","n","a","h"]
 * �����["h","a","n","n","a","H"]
 * tips:
 * һ���漰������������ֱ�ӿ���λ����(ǰ����λ���㲻������ݽ���Ӱ��)
*/

public class L0018LeetCode344 {
    public static void main(String[] args) {

    }

    /**
     * �Լ�д�ģ��ܼ�
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
