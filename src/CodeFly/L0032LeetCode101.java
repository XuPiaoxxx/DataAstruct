package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树-LeetCode:101-代码随想录
 * 2023.09.09/11.51

 题目:给你一个二叉树的根节点 root ， 检查它是否轴对称。
 样例:
 *
 * tips:
 * 递归和层序遍历分别对应DFS和BFS，二叉树的遍历问题，这题处理
 * 节点时需要知道左右节点的信息所以递归采用后续遍历。
 * 层序遍历时候入队就规定比较的顺序
 *
*/

public class L0032LeetCode101 {
    public static void main(String[] args) {
    }
    //递归
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return dfs(left.left,right.right)&&dfs(left.right,right.left);
    }
    //层序
    public boolean isSymmetric2(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        Queue<TreeNode> que=new LinkedList();
        que.offer(root.left);
        que.offer(root.right);
        while(!que.isEmpty()){
            TreeNode left=que.poll();
            TreeNode right=que.poll();
            if(left==null&&right==null) continue;
            if(left==null||right==null) return false;
            if(left.val!=right.val) return false;
            que.offer(left.left);
            que.offer(right.right);
            que.offer(left.right);
            que.offer(right.left);
        }
        return true;
    }
}
