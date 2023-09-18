package CodeFly;

/**
 * 二叉搜索树的最近公共祖先-LeetCode:236-代码随想录
 * 2023.09.18/12.21

 题目:给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 TIPS:
 二叉搜索树的特性：1，左孩子小于根节点，右孩子大于根节点
                2.中序遍历有序
 所以确定了遍历方向，遇到节点的值在p，q之间即为开始分叉的最近公共祖先
*/

public class L0049LeetCode235 {
    public static void main(String[] args) {

    }
    //迭代解法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val&&root.val>q.val) root=root.left;
            else if(root.val<p.val&&root.val<q.val) root=root.right;
            else return root;
        }
        return root;
    }
    //递归解法
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val&&root.val>q.val){
            TreeNode left=lowestCommonAncestor1(root.left,p,q);
            if(left!=null) return left;
        }else if(root.val<p.val&&root.val<q.val){
            TreeNode right=lowestCommonAncestor1(root.right,p,q);
            if(right!=null) return right;
        }
        return root;
    }

}
