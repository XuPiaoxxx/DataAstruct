package CodeFly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前中后序遍历-LeetCode:144,145,94-代码随想录
 * 2023.09.07/12.41

 题目:二叉树前中后序遍历
 *
 * tips:左程云的思想，遍历二叉树，每个节点实际上都访问了三遍，
 * 在对应的第几次访问操作就，分别对应着前中后序。
 *
*/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
public class L0029LeetCode94A144A145 {
    public static void main(String[] args) {
    }
    //中序遍历
    public void inorder(TreeNode node, List list){
        if(node==null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    //先序遍历
    public void preorder(TreeNode node,List list){
        if(node==null) return;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
    //后序遍历
    public void postorder(TreeNode node,List list){
        if(node==null) return;
        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);
    }


}
