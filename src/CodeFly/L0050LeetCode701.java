package CodeFly;

/**
 * �����������еĲ������-LeetCode:701-��������¼
 * 2023.09.18/12.50

 ��Ŀ:����������������BST���ĸ��ڵ� root ��Ҫ�������е�ֵ value ����ֵ
 ��������������� ���ز��������������ĸ��ڵ㡣 �������� ��֤ ����ֵ��ԭ
 ʼ�����������е�����ڵ�ֵ����ͬ��
 ע�⣬���ܴ��ڶ�����Ч�Ĳ��뷽ʽ��ֻҪ���ڲ�����Ա���Ϊ�������������ɡ�
 ����Է��� ������Ч�Ľ�� ��
 TIPS:
 ���������ԣ��������ұ���(������ͨ����������������ƽ�������)�����Բ���
*/

public class L0050LeetCode701 {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(val<root.val){
            if(root.left!=null){
                insertIntoBST(root.left,val);
            }else{
                root.left=new TreeNode(val);
            }
        }else{
            if(root.right!=null){
                insertIntoBST(root.right,val);
            }else{
                root.right=new TreeNode(val);
            }
        }
        return root;
    }


}
