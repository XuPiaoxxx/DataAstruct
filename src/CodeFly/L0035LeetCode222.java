package CodeFly;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ȫ�������ڵ������-LeetCode:222-��������¼
 * 2023.09.11/10.47

 ��Ŀ:����һ�� ��ȫ������ �ĸ��ڵ� root ����������Ľڵ������
 *
 * tips:
 * ��ͨ������:���ֱ���O(n)
 * ��ȫ������:
 *
 *
*/

public class L0035LeetCode222 {
    public static void main(String[] args) {
    }
    //��ͨ������(����-�ռ���Ϣ)
    public int countNodes1(TreeNode root) {
        if(root==null) return 0;
        int left=countNodes1(root.left);
        int right=countNodes1(root.right);
        return left+right+1;
    }
    //������ȫ�����������ԣ���ȫ�������Ľڵ���=2�Ĳ����η�-1
    public int countNodes2(TreeNode root) {
        if(root==null) return 0;
        TreeNode left=root.left;
        TreeNode right=root.right;
        int leftCount=0,rightCount=0;
        while(left!=null){
            leftCount++;
            left=left.left;
        }
        while(right!=null){
            rightCount++;
            right=right.right;
        }
        if(leftCount==rightCount) return (2<<leftCount)-1;
        int l=countNodes2(root.left);
        int r=countNodes2(root.right);
        return l+r+1;
    }
}
