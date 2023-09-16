package CodeFly;

/**
 * 验证二叉搜索树-LeetCode:98-代码随想录
 * 2023.09.16/14.00

 题目:给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 有效 二叉搜索树定义如下：
 节点的左子树只包含 小于 当前节点的数。
 节点的右子树只包含 大于 当前节点的数。
 所有左子树和右子树自身必须也是二叉搜索树。

 TIPS:
 涉及到二叉搜索树BST,一定要记住中序遍历的顺序一定是节点的值从小到大排列的，
 符合则为二叉搜索树。
 关于存储中序编写中当前节点前一个结点的值，可以用数组(赋值之后单独判断是否单调)
 ,一个int类型的值，long long 最小值，一个结点(pre结点在开始时为空，单独第一次赋值，
 随后被赋值为当前节点前一个结点)。
 中序遍历很重要。
*/

public class L0045LeetCode98 {
    public static void main(String[] args) {
    }
    TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left=isValidBST(root.left);
        if(pre!=null&&root.val<=pre.val){
            return false;
        }else{
            pre=root;
        }
        boolean right=isValidBST(root.right);
        return left&&right;
    }
}
