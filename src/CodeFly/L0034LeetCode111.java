package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度-LeetCode:111-代码随想录
 * 2023.09.10/17.24

 题目:
 样例:给定一个二叉树 root ，返回其最小深度。
 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * tips:
 *
 *
*/

public class L0034LeetCode111 {
    public static void main(String[] args) {
    }
    //递归
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
    //层序
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
