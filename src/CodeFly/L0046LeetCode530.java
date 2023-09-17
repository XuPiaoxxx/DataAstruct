package CodeFly;

/**
 * 验证二叉搜索树-LeetCode:98-代码随想录
 * 2023.09.17/11.58

 题目:给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 差值是一个正数，其数值等于两值之差的绝对值。

 TIPS:
 二叉搜索树的特性，中序遍历，值由小到大，所以绝对值最小的一定是两个相邻值的差，后-前。
*/

public class L0046LeetCode530 {
    public static void main(String[] args) {
    }
    int max=Integer.MAX_VALUE;
    TreeNode pre=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        getMinimumDifference(root.left);
        if(pre!=null&&root.val-pre.val<max){
            max=root.val-pre.val;
            pre=root;
        }else{
            pre=root;
        }
        getMinimumDifference(root.right);
        return max;
    }
}
