package CodeFly;

/**
 * 判断是否是平衡二叉树-LeetCode:110-代码随想录
 * 2023.09.09/22.05

 题目:给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * tips:
 * 普通二叉树:各种遍历O(n)
 * 完全二叉树:
 *
 *
*/

public class L0036LeetCode110 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1?false:true;
    }
    public int getHeight(TreeNode node){
        if(node==null) return 0;
        int leftCount=getHeight(node.left);
        if(leftCount==-1) return -1;
        int rightCount=getHeight(node.right);
        if(rightCount==-1) return -1;
        if(Math.abs(leftCount-rightCount)>1){
            return -1;
        }else{
            return 1+Math.max(leftCount,rightCount);
        }
    }
}
