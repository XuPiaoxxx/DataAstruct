package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ��ת������-LeetCode:226-��������¼
 * 2023.09.08/20.38

 ��Ŀ:����һ�ö������ĸ��ڵ� root ����ת��ö�����������������ڵ㡣
*����:
 *
 * tips:�ݹ鷭ת������ֵ���ϣ��ڵݹ���ûʲô�ã�,ǰ�к����������
 *
*/

public class L0031LeetCode226 {
    public static void main(String[] args) {
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        TreeNode temp=new TreeNode();
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
