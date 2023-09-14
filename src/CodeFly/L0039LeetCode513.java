package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������½ǵ�ֵ-LeetCode:513-��������¼
 * 2023.09.14/20.41

 ��Ŀ:����һ���������� ���ڵ� root�����ҳ��ö������� ��ײ� ����� �ڵ��ֵ��
 �����������������һ���ڵ㡣

*/

public class L0039LeetCode513 {
    public static void main(String[] args) {

    }
    //BFS�������һ�����֮��洢����ֵ(���Һ���)
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
    //BFS�������һ�����֮ǰ�洢����ֵ
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
    //DFS  DFS,ȫ������������¼Ҷ�ӽ�㵱ǰ�����Ⱥͽ����
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
