package CodeFly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * �ظ������ַ���-LeetCode:459-��������¼
 * 2023.08.28/19.27

 ��Ŀ:
*����:
 *
 * tips:
 *KMP,KMP��ԭ��֪��
 *
 * ������һ���next���鲻�����ƣ���Ϊ����ȥƥ�䣬Ҫ��¼��ǰ�ַ�������ǰһ��
 * �ַ����Ӵ�����󹫹�ǰ��׺���ȣ�������ᶪʧ������󹫹�ǰ��׺���ȡ�
 *
 * ����һ���ԭ��:
 * �ַ����в����������ǰ��׺���Ӵ������ظ��ִ�(ǰ�����ַ������ȿ��������Ӵ�����)
 * next  ��� next[len - 1] != 0����˵���ַ��������ͬ��ǰ��׺����
 * ���ַ������ǰ׺�Ӵ��ͺ�׺�Ӵ���ͬ������ȣ���
 * ����ǰ��׺�ĳ���Ϊ��next[len - 1] ��(�����next��������ͳһ��һ�ķ�ʽ����ģ����
 * ��Ҫ+1�����ּ���next����ľ�����������ַ�����KMP�㷨����)
 * ���len % (len - (next[len - 1])) == 0 ����˵�� (���鳤��-����ǰ��׺�ĳ���)
 * ���ÿ��Ա� ����ĳ���������˵���и��ַ������ظ������ַ�����

 *
*/

public class L0021LeetCode459 {
    public static void main(String[] args) {
        repeatedSubstringPattern3("abac");
    }
    //�Լ��ı����ⷨ
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

    //s+s�ⷨ
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
