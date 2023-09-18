package CodeFly;

/**
 * 二叉搜索树中的插入操作-LeetCode:701-代码随想录
 * 2023.09.18/12.50

 题目:给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值
 插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原
 始二叉搜索树中的任意节点值都不同。
 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 你可以返回 任意有效的结果 。
 TIPS:
 二叉树特性，向左向右遍历(这是普通搜索二叉树，不是平衡二叉树)，所以不难
*/

public class L0050LeetCode701 {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(val<root.val){
            if(root.left!=null){
                insertIntoBST(root.left,val);
            }else{
                root.left=new TreeNode(val);
            }
        }else{
            if(root.right!=null){
                insertIntoBST(root.right,val);
            }else{
                root.right=new TreeNode(val);
            }
        }
        return root;
    }


}
