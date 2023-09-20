package CodeFly;

/**
 * 把二叉搜索树转换为累加树-LeetCode:538-代码随想录
 * 2023.09.20/21.11

 题目:给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 TIPS:
    考虑方法是:
 由题意得，从大到小，逐渐加上后面的值，因为，
 二叉搜索树  左中右是从小到大的顺序，那右中左就是从大
 到小的顺序。
 所以实现递归，设置全局变量(或者设置一个pre节点存前一个树节点)
 每次遍历都加上前面值的和


*/

public class L0054LeetCode538 {
    public static void main(String[] args) {

    }
    int count=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        root.right=convertBST(root.right);
        root.val+=count;
        count=root.val;
        root.left=convertBST(root.left);
        return root;
    }

}
