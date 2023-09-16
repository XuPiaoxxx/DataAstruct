package CodeFly;

/**
 * ��֤����������-LeetCode:98-��������¼
 * 2023.09.16/14.00

 ��Ŀ:����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
 ��Ч �����������������£�
 �ڵ��������ֻ���� С�� ��ǰ�ڵ������
 �ڵ��������ֻ���� ���� ��ǰ�ڵ������
 �������������������������Ҳ�Ƕ�����������

 TIPS:
 �漰������������BST,һ��Ҫ��ס���������˳��һ���ǽڵ��ֵ��С�������еģ�
 ������Ϊ������������
 ���ڴ洢�����д�е�ǰ�ڵ�ǰһ������ֵ������������(��ֵ֮�󵥶��ж��Ƿ񵥵�)
 ,һ��int���͵�ֵ��long long ��Сֵ��һ�����(pre����ڿ�ʼʱΪ�գ�������һ�θ�ֵ��
 ��󱻸�ֵΪ��ǰ�ڵ�ǰһ�����)��
 �����������Ҫ��
*/

public class L0045LeetCode98 {
    public static void main(String[] args) {
    }
    TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left=isValidBST(root.left);
        if(pre!=null&&root.val<=pre.val){
            return false;
        }else{
            pre=root;
        }
        boolean right=isValidBST(root.right);
        return left&&right;
    }
}
