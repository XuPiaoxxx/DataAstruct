package CodeFly;

import java.util.*;

/**
 * 二叉树的层序遍历-LeetCode:102-代码随想录
 * 2023.09.07/22.16

 题目:给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
*样例:
 *
 * tips:队列实现层序遍历，BFS很合适。还有一种DFS的写法，有点牛，后话再说.
 *
*/

public class L0030LeetCode102 {
    public static void main(String[] args) {
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList();
            int len=queue.size();
            while(len>0){
                TreeNode tempNode=queue.poll();
                temp.add(tempNode.val);
                if(tempNode.left!=null) queue.offer(tempNode.left);
                if(tempNode.right!=null) queue.offer(tempNode.right);
                len--;
            }
            res.add(temp);
        }
        return res;
    }
}
