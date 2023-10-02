package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ������ĸ����-LeetCode:763-��������¼
 * 2023.10.2/10.27

 ��Ŀ:����һ���ַ��� s ������Ҫ������ַ�������Ϊ�����ܶ��Ƭ�Σ�ͬһ��ĸ��������һ��Ƭ���С�

 ע�⣬���ֽ����Ҫ���㣺�����л��ֽ����˳�����ӣ��õ����ַ�����Ȼ�� s ��

 ����һ����ʾÿ���ַ���Ƭ�εĳ��ȵ��б�
 TIPS;
 ѧϰ��������¼˼��������
 ������ĸ-��������
 ��һ�α�����ͳ����ĸ��Ӧ����Զλ��
 ASCII����ж�Ӧ��ĸ�±�ȷ��
 ��end���ٱ���һ�飬ÿ�ζ�����endΪ��ǰ�ַ���Զ���Ⱥ�end������ֵ
 �������ֵ���������
 */

public class L0082LeetCode763 {
    public static void main(String[] args) {
    }
    //�Լ�����˼·����--4ms
    public List<Integer> partitionLabels(String s) {
        int[] hash=new int[26];
        List<Integer> res=new ArrayList();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,hash[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
    //�Ƚ��ַ���ת��Ϊ�ַ����飬�ٲ����������ٿ�1����
    public List<Integer> partitionLabels1(String s) {
        int[] hash=new int[26];
        List<Integer> res=new ArrayList();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,hash[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}
