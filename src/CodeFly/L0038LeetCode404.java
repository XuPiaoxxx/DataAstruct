package CodeFly;

import java.util.List;

/**
 * 左叶子之和-LeetCode:404-代码随想录
 * 2023.09.13/13.48

 题目:给定二叉树的根节点 root ，返回所有左叶子之和。
 * tips:
 * 后序遍历，收集左右遍历的结果，学习了
 *
 *
 *
*/

public class L0038LeetCode404 {
    public static void main(String[] args) {

    }
    //后序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)  return 0;
        int left=sumOfLeftLeaves(root.left);
        int right=sumOfLeftLeaves(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null) left=root.left.val;
        return left+right;
    }
    //前序遍历，遇到符合的节点就加入
    int sum=0;
    public void dfs(TreeNode node){
        if(node==null) return;
        if(node.left!=null&&node.left.left==null&&node.left.right==null) sum+=node.left.val;
        dfs(node.left);
        dfs(node.right);
    }
}
