package CodeFly;

import java.util.*;

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
    //�ǵݹ����
    //����
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList();
        Stack<TreeNode> stack=new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp!=null){
                res.add(temp.val);
            }else{
                continue;
            }
            stack.push(temp.right);
            stack.push(temp.left);
        }
        return res;
    }
    //����
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList();
        Stack<TreeNode> stack=new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp!=null){
                res.add(temp.val);
            }else{
                continue;
            }
            stack.push(temp.left);
            stack.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }
    //����



}
