package CodeFly;

/**
 * �����������е�����-LeetCode:700-��������¼
 * 2023.09.16/12.46

 ��Ŀ:����������������BST���ĸ��ڵ� root ��һ������ֵ val��
 ����Ҫ�� BST ���ҵ��ڵ�ֵ���� val �Ľڵ㡣 �����Ըýڵ�Ϊ��
 �������� ����ڵ㲻���ڣ��򷵻� null ��

 TIPS:
 ���������������ʡ�
*/

public class L0044LeetCode700 {
    public static void main(String[] args) {
    }
    //�򵥵Ķ���������Ӧ��
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
