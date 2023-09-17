package CodeFly;

/**
 * 求二叉搜索树中的众数-LeetCode:501-代码随想录
 * 2023.09.17/14.32

 题目:给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 如果树中有不止一个众数，可以按 任意顺序 返回。
 假定 BST 满足如下定义：
 结点左子树中所含节点的值 小于等于 当前节点的值
 结点右子树中所含节点的值 大于等于 当前节点的值
 左子树和右子树都是二叉搜索树
 TIPS:
 二叉搜索树中序遍历，通过全局变量maxCount记录遍历过程中出现的最大次数，每次当局部相等值遍历的次数count>maxCount的时候，更新maxCount的值，清空之前以maxCount（为基准的众数的集合），再加入当前的数为第一个以当前maxCount为出现次数的众数。
 全局变量max记录局部范围连续出现的相同值(因为中序遍历顺序从小到大，相同值一定相邻)
 二叉搜索树，中序遍历从大到小的序列，前后出现关联--（入手）
*/

public class L0047LeetCode501 {
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
