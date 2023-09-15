package CodeFly;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树-LeetCode:106-代码随想录
 * 2023.09.15/19.27

 题目:给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历
 ， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

 TIPS:
 直接分割数组，传递数组，新建数组，涉及了太多多余的操作，每次递归都在新建数组操作。
 通过学习其他人的解法，可以用全局的HashMap存中序的值，因为有找中序中根节点作为分割点
 的需求，再用全局的post存后序遍历数组。这样每次递归传的都是数组下标，不涉及新建数组，
 程序的速度就会快起来，只操作全局的数组。


*/

public class L0041LeetCode106 {
    public static void main(String[] args) {

    }
    //自己按照代码随想录思路编写，非常慢。
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        //遇到叶子节点
        if(postorder.length==1) return root;
        //作用域大的index
        int index;
        //找到分割点，为后序数组最后一个数
        for(index=0;index<inorder.length;index++){
            if(inorder[index]==postorder[postorder.length-1]){
                break;
            }
        }
        //切割中序数组
        int[] leftInorder=new int[index];
        for(int i=0;i<index;i++){
            leftInorder[i]=inorder[i];
        }
        int[] rightInorder=new int[inorder.length-leftInorder.length-1];
        for(int i=index+1;i<inorder.length;i++){
            rightInorder[i-(index+1)]=inorder[i];
        }
        //切割后序数组
        int[] leftPostorder=new int[leftInorder.length];
        for(int i=0;i<leftInorder.length;i++){
            leftPostorder[i]=postorder[i];
        }
        int[] rightPostorder=new int[rightInorder.length];
        for(int i=0;i<rightInorder.length;i++){
            rightPostorder[i]=postorder[leftPostorder.length+i];
        }
        //为当前左右节点赋值，并递归处理下一层节点
        root.left=buildTree(leftInorder,leftPostorder);
        root.right=buildTree(rightInorder,rightPostorder);
        return root;
    }

    //学习了，大佬解法
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
