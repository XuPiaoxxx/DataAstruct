package CodeFly;

import java.util.List;

/**
 * ������������·��-LeetCode:257-��������¼
 * 2023.09.12/12.24

 ��Ŀ:����һ���������ĸ��ڵ� root ���� ����˳�� ���������дӸ��ڵ㵽Ҷ�ӽڵ��·����
 *
 * tips:
 * ������Ŀ����˼����Ҫ��¼�ڵ������·��������ʹ��
 * ����������ռ��ڵ��ֵ
 * ���зֱ����������飬��һ�����鱣�����·�����ֵ���ڶ�������
 * �������ս����
 *
 *
 *
*/

public class L0037LeetCode257 {
    public static void main(String[] args) {

    }
    //�������
    public void dfs(TreeNode node, List<Integer> list, List<String> string){
        list.add(node.val);
        if(node.left==null&&node.right==null){
            StringBuilder sb=new StringBuilder();
            sb.append(list.get(0));
            for(int i=1;i<list.size();i++){
                sb.append("->"+list.get(i));
            }
            string.add(sb.toString());
        }
        if(node.left!=null){
            dfs(node.left,list,string);
            list.remove(list.size()-1);
        }
        if(node.right!=null){
            dfs(node.right,list,string);
            list.remove(list.size()-1);
        }
    }
}
