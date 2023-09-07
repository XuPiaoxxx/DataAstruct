package CodeFly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * ǰ�к������-LeetCode:144,145,94-��������¼
 * 2023.09.07/12.41

 ��Ŀ:������ǰ�к������
 *
 * tips:����Ƶ�˼�룬������������ÿ���ڵ�ʵ���϶����������飬
 * �ڶ�Ӧ�ĵڼ��η��ʲ����ͣ��ֱ��Ӧ��ǰ�к���
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
    //�������
    public void inorder(TreeNode node, List list){
        if(node==null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
    //�������
    public void preorder(TreeNode node,List list){
        if(node==null) return;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
    //�������
    public void postorder(TreeNode node,List list){
        if(node==null) return;
        postorder(node.left,list);
        postorder(node.right,list);
        list.add(node.val);
    }


}
