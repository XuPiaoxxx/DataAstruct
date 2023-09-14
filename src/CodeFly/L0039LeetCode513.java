package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树左下角的值-LeetCode:513-代码随想录
 * 2023.09.14/20.41

 题目:给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 假设二叉树中至少有一个节点。

*/

public class L0039LeetCode513 {
    public static void main(String[] args) {

    }
    //BFS，在最后一层遍历之后存储最左值(先右后左)
    public int findBottomLeftValue1(TreeNode root) {
        Queue<TreeNode> que=new LinkedList();
        que.offer(root);
        int res=0;
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode temp=que.poll();
                if(temp.right!=null) que.offer(temp.right);
                if(temp.left!=null) que.offer(temp.left);
                res=temp.val;
            }
        }
        return res;
    }
    //BFS，在最后一层遍历之前存储最左值
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> que=new LinkedList();
        que.offer(root);
        int res=0;
        while(!que.isEmpty()){
            int size=que.size();
            res=que.peek().val;
            for(int i=0;i<size;i++){
                TreeNode temp=que.poll();
                if(temp.left!=null) que.offer(temp.left);
                if(temp.right!=null) que.offer(temp.right);
            }
        }
        return res;
    }
    //DFS  DFS,全局两个变量记录叶子结点当前最大深度和结果。
    int Max=Integer.MIN_VALUE;
    int result;
    public void dfs(TreeNode node,int depth){
        if(node.left==null&&node.right==null){
            if(depth>Max){
                Max=depth;
                result=node.val;
            }
        }
        if(node.left!=null){
            depth++;
            dfs(node.left,depth);
            depth--;
        }
        if(node.right!=null){
            depth++;
            dfs(node.right,depth);
            depth--;
        }
    }

}
