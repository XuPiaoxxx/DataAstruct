package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  �绰�������ĸ���-LeetCode:17-��������¼
 * 2023.09.22/23.08

 ��Ŀ:����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�

 �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 TIPS:
 �漰ӳ��Ĵ������Բ����ַ�����ķ���ʵ�֣�
 ���漰��ͨ��ASCII��Ĳ�ֵ��ת���ַ����ֺ�int����
 �����㷨��˼·��Ϊ��Ϊ0�Ĵ���
 ������ȡ��Ӧ���ֵ�ӳ�䣬�ٽ�����Щ��Ӧ�ַ��õ�ѭ��������ͬʱ�ݹ���ݴ���
 ��һ�����ֶ�Ӧ���ַ���(ͨ���±�ȡ��ӳ��)
 ��ֹ����Ϊ�±��ֵ�����������ַ�����ȣ�Ҳ���ǵݹ�������������ַ�����+1


*/

public class L0057LeetCode17 {
    static int total=0;
    public static void main(String[] args) {


    }
    //��������¼�������㷨+С���ɴ���ӳ�䣬ת������Ҫ�����鼯�ϴ洢���ַ����洢��StringBulider����ɾ�ܷ���
    List<String> res=new ArrayList();
    StringBuilder sb=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)return res;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(digits,map,0);
        return res;
    }
    public void backTrack(String digits,String[] map,int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String temp = map[digits.charAt(start) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            backTrack(digits, map, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
