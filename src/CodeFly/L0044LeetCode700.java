package CodeFly;

/**
 * 二叉搜索树中的搜索-LeetCode:700-代码随想录
 * 2023.09.16/12.46

 题目:给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根
 的子树。 如果节点不存在，则返回 null 。

 TIPS:
 二叉搜索树的性质。
*/

public class L0044LeetCode700 {
    public static void main(String[] args) {
    }
    //简单的二叉搜索树应用
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
