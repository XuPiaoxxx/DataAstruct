package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������������-LeetCode:104-��������¼
 * 2023.09.09/17.11

 ��Ŀ:
 ����:����һ�������� root �������������ȡ�
 �������� ������ ��ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 *
 * tips:
 *
 *
*/

public class L0033LeetCode104 {
    public static void main(String[] args) {
    }
    //�ݹ�(���������߶�)�����ڵ�߶�=������
    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth1(root.left);
        int right=maxDepth1(root.right);
        return Math.max(left,right)+1;
    }
    //����
    public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que=new LinkedList();
        que.offer(root);
        int res=0;
        while(!que.isEmpty()){
            int size=que.size();
            while(size>0){
                TreeNode temp=que.poll();
                if(temp.left!=null) que.offer(temp.left);
                if(temp.right!=null) que.offer(temp.right);
                size--;
            }
            res++;
        }
        return res;
    }
}
