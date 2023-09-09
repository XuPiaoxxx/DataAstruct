package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度-LeetCode:104-代码随想录
 * 2023.09.09/17.11

 题目:
 样例:给定一个二叉树 root ，返回其最大深度。
 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * tips:
 *
 *
*/

public class L0033LeetCode104 {
    public static void main(String[] args) {
    }
    //递归(后序遍历求高度)，根节点高度=最大深度
    public int maxDepth1(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth1(root.left);
        int right=maxDepth1(root.right);
        return Math.max(left,right)+1;
    }
    //层序
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
