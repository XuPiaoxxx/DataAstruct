package CodeFly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ��ת�ַ����еĵ���-LeetCode:151-��������¼
 * 2023.08.27/11.59

 ��Ŀ:����һ���ַ��� s �����㷴ת�ַ����� ���� ��˳��
 ���� ���ɷǿո��ַ���ɵ��ַ�����s ��ʹ������һ���ո��ַ����е� ���� �ָ�����
 ���� ���� ˳��ߵ��� ���� ֮���õ����ո����ӵĽ���ַ�����
 ע�⣺�����ַ��� s�п��ܻ����ǰ���ո�β��ո���ߵ��ʼ�Ķ���ո񡣷��صĽ���ַ����У����ʼ�Ӧ�����õ����ո�ָ����Ҳ������κζ���Ŀո�

*����:
 * ʾ�� 1��ʾ�� 1��
 *
 * ���룺s = "the sky is blue"
 * �����"blue is sky the"
 * ʾ�� 2��
 *
 * ���룺s = "  hello world  "
 * �����"world hello"
 * ���ͣ���ת����ַ����в��ܴ���ǰ���ո��β��ո�
 *
 * ���룺
 * tips:
 * ѧϰ��������Ľ��ⷽ��
 * ˫ָ��(����ָ�룬����)ɾ����ӦԪ�أ�ʱ�临�Ӷ�O(n)
*/

public class L0020LeetCode151 {
    public static void main(String[] args) {

    }

    /**
     * �⺯����
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        s=s.trim();
        List<String> wordList= Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }

    /**
     * �Ӻ���ǰ���������leftָ��ȥ����ͷ�ո�
     * rightȥ���ұ߿ո��Ҷ��嵥�ʵ��ұ߽硣
     * index�Ӻ�ǰ�ڱ�������ֵ�����ո��ȷ�����ʵ���߽硣
     * �½����鲢���롣
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s=s.trim();
        StringBuilder sb=new StringBuilder();
        int j=s.length()-1;
        int i=j;
        while(i>=0){
            while(i>=0&&s.charAt(i)!=' ') i--;
            sb.append(s.substring(i+1,j+1)+" ");
            while(i>=0&&s.charAt(i)==' ') i--;
            j=i;
        }
        return sb.toString().trim();
    }
}
