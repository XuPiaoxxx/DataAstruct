package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全二叉树节点的数量-LeetCode:222-代码随想录
 * 2023.09.11/10.47

 题目:给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * tips:
 * 普通二叉树:各种遍历O(n)
 * 完全二叉树:
 *
 *
*/

public class L0035LeetCode222 {
    public static void main(String[] args) {
    }
    //普通二叉树(后序-收集信息)
    public int countNodes1(TreeNode root) {
        if(root==null) return 0;
        int left=countNodes1(root.left);
        int right=countNodes1(root.right);
        return left+right+1;
    }
    //运用完全二叉树的特性，完全二叉树的节点数=2的层数次方-1
    public int countNodes2(TreeNode root) {
        if(root==null) return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int leftCount=0,rightCount=0;
        while(left!=null){
            leftCount++;
            left=left.left;
        }
        while(right!=null){
            rightCount++;
            right=right.right;
        }
        if(leftCount==rightCount) return (2<<leftCount)-1;
        int l=countNodes2(root.left);
        int r=countNodes2(root.right);
        return l+r+1;
    }
}
