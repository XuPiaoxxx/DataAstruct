package CodeFly;

/**
 * 修建二叉搜索树-LeetCode:669-代码随想录
 * 2023.09.19/22.29

 题目:给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界
 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪
 树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有
 的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 TIPS:
 首先进行分析。
 遍历顺序无所谓，终止条件在最上面。
 采用重新构建二叉树左右节点指向的策略。
 每次都重新设置node.left和node.right
 当节点为空，依然返回空。
 当遇到root.val小于low的情况，证明root.left子树的所有值都不符合，
 可以直接不考虑，但是右树可能有大于low的情况，所以返回递归右树的结果
 同理root.val大于high。
 如果当前节点符合，在区间内，则设置左指针和右指针，向上返回当前节点。

*/

public class L0052LeetCode669 {
    public static void main(String[] args) {

    }
    //代码随想录，递归方法，每次向上返回节点，重新进行左右指针的赋值
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val<low) return trimBST(root.right,low,high);
        if(root.val>high) return trimBST(root.left,low,high);

        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
