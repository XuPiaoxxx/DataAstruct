package CodeFly;

import java.util.List;

/**
 * ��Ҷ��֮��-LeetCode:404-��������¼
 * 2023.09.13/13.48

 ��Ŀ:�����������ĸ��ڵ� root ������������Ҷ��֮�͡�
 * tips:
 * ����������ռ����ұ����Ľ����ѧϰ��
 *
 *
 *
*/

public class L0038LeetCode404 {
    public static void main(String[] args) {

    }
    //�������
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)  return 0;
        int left=sumOfLeftLeaves(root.left);
        int right=sumOfLeftLeaves(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null) left=root.left.val;
        return left+right;
    }
    //ǰ��������������ϵĽڵ�ͼ���
    int sum=0;
    public void dfs(TreeNode node){
        if(node==null) return;
        if(node.left!=null&&node.left.left==null&&node.left.right==null) sum+=node.left.val;
        dfs(node.left);
        dfs(node.right);
    }
}
