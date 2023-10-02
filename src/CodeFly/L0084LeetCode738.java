package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ��������������-LeetCode:738-��������¼
 * 2023.10.2/10.53

 ��Ŀ:���ҽ���ÿ������λ���ϵ����� x �� y ���� x <= y ʱ�����ǳ���������ǵ��������ġ�
 ����һ������ n ������ С�ڻ���� n ��������֣������ֳ� �������� ��

 TIPS:

 �Լ���ȫ�벻��������������¼�ⷨ:
 ��λ��λȥ�Ƚ�
 ���ǰ������Ⱥ����������ǰ��-1�������Ϊ9
 Ϊ�˱�������9�������ԣ���flag��¼��Ϊ9�Ŀ�ʼλ�ã���������м䴦���ַ�����������������ֶ�9�����������������

 ����֮�⣬������Stirng��valueOf������Integer��ParseInt������ֵ�ü�ס�������㷨�͹��̶����а���

 ��char����ԭ�ز�����Ƶ��ʹ��ParseInt�Ƚϴ�СЧ�ʸ���

 Integer.parseInt(String s)��������ڴ����ַ���ʱ��һЩϸ��Ҫע�⣬����"030"��ת����30

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
