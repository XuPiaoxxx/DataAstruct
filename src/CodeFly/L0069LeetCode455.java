package CodeFly;

import java.util.Arrays;

/**
 *  �ַ�����-LeetCode:455-��������¼
 * 2023.09.26/18.43

 ��Ŀ:��������һλ�ܰ��ļҳ�����Ҫ����ĺ�����һЩС���ɡ����ǣ�ÿ���������ֻ�ܸ�һ����ɡ�

 ��ÿ������ i������һ��θ��ֵ g[i]���������ú���������θ�ڵı��ɵ���
 С�ߴ磻����ÿ����� j������һ���ߴ� s[j] ����� s[j] >= g[i]�����ǿ�
 �Խ�������� j ��������� i ��������ӻ�õ����㡣���Ŀ���Ǿ���������Խ
 �������ĺ��ӣ��������������ֵ��
 TIPS:
 ̰������·���������������飬�����ԡ�
 �����������+˫ָ��
 1.�Ӵ�Ŀ�ʼ�������ô���������θ
 2.��С�Ŀ�ʼ���þ���С�ı�������Сθ


*/

public class L0069LeetCode455 {
    public static void main(String[] args) {
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(g[i]<=s[j]){
                res++;
                i++;
                j++;
            }else if(g[i]>s[j]){
                j++;
            }
        }
        return res;
    }

}
