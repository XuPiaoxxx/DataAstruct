package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 翻转二叉树-LeetCode:226-代码随想录
 * 2023.09.08/20.38

 题目:给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
*样例:
 *
 * tips:递归翻转，返回值符合（在递归中没什么用）,前中后序遍历类似
 *
*/

public class L0031LeetCode226 {
    public static void main(String[] args) {
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        TreeNode temp=new TreeNode();
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
