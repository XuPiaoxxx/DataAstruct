package CodeFly;

/**
 * 合并二叉树-LeetCode:617-代码随想录
 * 2023.09.16/12.36

 题目:给你两棵二叉树： root1 和 root2 。
 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值
 相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 返回合并后的二叉树。
 注意: 合并过程必须从两个树的根节点开始。

 TIPS:
 同时操作两个二叉树，思路不难，困扰我的是对于一空一不空的节点处理方法
*/

public class L0043LeetCode617 {
    public static void main(String[] args) {
    }
    //直接覆盖root1树
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val+=root2.val;
        root1.left = mergeTrees1(root1.left,root2.left);
        root1.right = mergeTrees1(root1.right,root2.right);
        return root1;
    }
    //新建一棵树，来作为res返回
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2==null?null:new TreeNode(root2.val,root2.left,root2.right);
        if(root2==null) return new TreeNode(root1.val,root1.left,root1.right);
        TreeNode node=new TreeNode(root1.val+root2.val);
        node.left=mergeTrees2(root1.left,root2.left);
        node.right=mergeTrees2(root1.right,root2.right);
        return node;
    }
}
