package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������С���-LeetCode:111-��������¼
 * 2023.09.10/17.24

 ��Ŀ:
 ����:����һ�������� root ����������С��ȡ�
 �������� ������ ��ָ�Ӹ��ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 *
 * tips:
 *
 *
*/

public class L0034LeetCode111 {
    public static void main(String[] args) {
    }
    //�ݹ�
    public int minDepth1(TreeNode root) {
        if(root==null) return 0;
        int left=minDepth1(root.left);
        int right=minDepth1(root.right);
        if(root.left==null&&root.right!=null){
            return 1+right;
        }else if(root.left!=null&&root.right==null){
            return 1+left;
        }else{
            return Math.min(left,right)+1;
        }
    }
    //����
    public int minDepth2(TreeNode root) {
        Queue<TreeNode> que=new LinkedList();
        if(root==null) return 0;
        que.offer(root);
        int res=0;
        while(!que.isEmpty()){
            int size=que.size();
            while(size>0){
                TreeNode temp=que.poll();
                if(temp.left==null&&temp.right==null){
                    return res+1;
                }
                if(temp.left!=null) que.offer(temp.left);
                if(temp.right!=null) que.offer(temp.right);
                size--;
            }
            res++;
        }
        return res+1;
    }
}
