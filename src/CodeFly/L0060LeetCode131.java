package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  �ָ���Ĵ�-LeetCode:131-��������¼
 * 2023.09.24/10.48

 ��Ŀ:����һ���ַ��� s�����㽫 s �ָ��һЩ�Ӵ���ʹÿ���Ӵ����� ���Ĵ� ������ s ���п��ܵķָ����
 ���Ĵ� �����Ŷ��ͷ��Ŷ���һ�����ַ�����
 ע�⣺�⼯���ܰ����ظ�����ϡ�
 TIPS:
 �ָ�����Ĺؼ����Ѷȣ�����Ϊ��ת��Ϊ���ݽ����
 ���±����ʼλ�ñ�ʾ�Ӵ��Ľ���λ��(Ҳ���Ƿָ��ߵ�λ��)��
 �����漰��substring������ʹ��.
 �жϻ��Ĵ�������һ�����ܡ�
 ת��Ϊ���������



*/

public class L0060LeetCode131 {
    public static void main(String[] args) {

    }
    List<List<String>> res=new ArrayList();
    LinkedList<String> row=new LinkedList();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return res;
    }
    public void backTrack(String s,int start){
        if(start>=s.length()){
            res.add(new ArrayList(row));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isP(s,start,i)){
                row.add(s.substring(start,i+1));
            }else{
                continue;
            }
            backTrack(s,i+1);
            row.removeLast();
        }
    }

    public boolean isP(String s,int start,int end){
        for(int i=start,j=end;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
