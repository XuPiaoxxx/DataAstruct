package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  ��ԭ IP ��ַ-LeetCode:93-��������¼
 * 2023.09.24/13.00

 ��Ŀ:��Ч IP ��ַ �������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
 ���磺"0.1.2.201" �� "192.168.1.1" �� ��Ч IP ��ַ������ "0.011.255.245"��"192.168.1.312" �� "192.168@1.1" �� ��Ч IP ��ַ��
 ����һ��ֻ�������ֵ��ַ��� s �����Ա�ʾһ�� IP ��ַ���������п��ܵ���Ч IP ��ַ����Щ��ַ����ͨ���� s �в��� '.' ���γɡ��� ���� ���������ɾ�� s �е��κ����֡�����԰� �κ� ˳�򷵻ش𰸡�
 TIPS:
 ���Ȿ�ʻ��Ƿָ����⣬���Ƕ�ÿһ�ηֳ����������й������ơ�
 ��������¼����pointNum������������ֹ
 �������ø����׶�����������JAVA������ƴ����ʵ�֡�

 �ж��Ƿ�Ϸ���Ҫ������д���ද��ת��˼·
 д֮ǰ�滮�á�
    �������
 ע��ָ��ȥ�Ĳ��֣����ڽ��յ����⣬���Կ���������н��ܡ�
 Ҳ����ֱ�ӽ��д�����뵽���յķ��ؽ���С�
 Integer.ValueOf����Integer��װ��
 Integer.parseInt����int

*/

public class L0061LeetCode93 {
    public static void main(String[] args) {

    }
    List<String> res=new ArrayList();
    LinkedList<String> path=new LinkedList();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0);
        return res;
    }
    public void backTrack(String s,int start){
        if(path.size()==4){
            String sb=String.join(".",path);
            if(sb.length()==s.length()+3){
                res.add(sb);
            }
            return;
        }
        for(int i=start;i<s.length();i++){
            if(!isValid(s,start,i+1)) break;
            path.add(s.substring(start,i+1));
            backTrack(s,i+1);
            path.removeLast();
        }
    }
    public boolean isValid(String s,int start,int end){
        int temp=Integer.parseInt(s.substring(start,end));
        if(end>start+1&&s.charAt(start)=='0') return false;
        if(temp<0||temp>255) return false;
        return true;
    }
}
