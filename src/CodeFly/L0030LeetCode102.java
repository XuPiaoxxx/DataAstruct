package CodeFly;

import java.util.*;

/**
 * �������Ĳ������-LeetCode:102-��������¼
 * 2023.09.07/22.16

 ��Ŀ:����������ĸ��ڵ� root ��������ڵ�ֵ�� ������� �� �������أ������ҷ������нڵ㣩��
*����:
 *
 * tips:����ʵ�ֲ��������BFS�ܺ��ʡ�����һ��DFS��д�����е�ţ������˵.
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
