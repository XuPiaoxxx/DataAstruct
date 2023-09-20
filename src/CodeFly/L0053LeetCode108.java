package CodeFly;

/**
 * ����������ת��Ϊ����������-LeetCode:108-��������¼
 * 2023.09.20/19.39

 ��Ŀ:����һ���������� nums ������Ԫ���Ѿ��� ���� ���У����㽫��ת��Ϊһ�� �߶�ƽ�� ������������

 �߶�ƽ�� ��������һ�����㡸ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������ 1 ���Ķ�������
 TIPS:
    ���Ƿ�����:
 1.�ҵ��м�ڵ㣬��Ϊ���ڵ㣬���ݹ���δ��������������ߣ�ע�����
 �ı߽�����������ֵΪTreeNode�����Ϊ���ҽڵ�ֱ�ֵΪ����������
 �����ݹ飬
 ע������ҿ�������ұ�


*/

public class L0053LeetCode108 {
    public static void main(String[] args) {

    }
    //����ұ�
    public TreeNode BST1(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=left+((right-left)>>1);
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=BST1(nums,left,mid-1);
        newNode.right=BST1(nums,mid+1,right);
        return newNode;
    }
    //����ҿ�
    public TreeNode BST2(int[] nums,int left,int right){
        if(left>=right) return null;
        int mid=left+((right-left)>>1);
        TreeNode temp=new TreeNode(nums[mid]);
        temp.left=BST2(nums,left,mid);
        temp.right=BST2(nums,mid+1,right);
        return temp;
    }

}
