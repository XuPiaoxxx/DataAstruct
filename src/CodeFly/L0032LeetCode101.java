package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �Գƶ�����-LeetCode:101-��������¼
 * 2023.09.09/11.51

 ��Ŀ:����һ���������ĸ��ڵ� root �� ������Ƿ���Գơ�
 ����:
 *
 * tips:
 * �ݹ�Ͳ�������ֱ��ӦDFS��BFS���������ı������⣬���⴦��
 * �ڵ�ʱ��Ҫ֪�����ҽڵ����Ϣ���Եݹ���ú���������
 * �������ʱ����Ӿ͹涨�Ƚϵ�˳��
 *
*/

public class L0032LeetCode101 {
    public static void main(String[] args) {
    }
    //�ݹ�
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
    //����
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        Queue<TreeNode> que=new LinkedList();
        que.offer(root.left);
        que.offer(root.right);
        while(!que.isEmpty()){
            TreeNode left=que.poll();
            TreeNode right=que.poll();
            if(left==null&&right==null) continue;
            if(left==null||right==null) return false;
            if(left.val!=right.val) return false;
            que.offer(left.left);
            que.offer(right.right);
            que.offer(left.right);
            que.offer(right.left);
        }
        return true;
    }
}
