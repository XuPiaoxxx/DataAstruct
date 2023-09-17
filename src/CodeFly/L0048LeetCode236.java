package CodeFly;

/**
 * 二叉树的最近公共祖先-LeetCode:236-代码随想录
 * 2023.09.17/22.54

 题目:给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 TIPS:
 后序遍历是关键，根据处理节点的左右返回的类型，来逐渐向上返回。
*/

public class L0048LeetCode236 {
    public static void main(String[] args) {
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        else if(left==null&&right!=null) return right;
        else if(left!=null&&right==null) return left;
        else return null;
    }
}
