package CodeFly;

import java.util.HashMap;

/**
 * ��������-LeetCode:654-��������¼
 * 2023.09.15/22.18

 ��Ŀ:����һ�����ظ����������� nums �� �������� ������������㷨�� nums �ݹ�ع���:
 ����һ�����ڵ㣬��ֵΪ nums �е����ֵ��
 �ݹ�������ֵ ��� �� ������ǰ׺�� ������������
 �ݹ�������ֵ �ұ� �� �������׺�� ������������
 ���� nums ������ �������� ��

 TIPS:
 ����LeetCode106
 �߼����б仯�������ʻ��Ƕ��������ҷ��Σ����ط���Ҫ��Ľڵ㣬��·!

*/

public class L0042LeetCode654 {
    public static void main(String[] args) {
        int[] arr={3,2,1,6,0,5};
        constructMaximumBinaryTree(arr);
    }
    //��һ�����Լ�д�����ģ����LC112
    static int[]  arr;
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        arr=nums;
        TreeNode root = dfs(0,arr.length-1);
        return root;
    }
    public static TreeNode dfs(int start,int end){
        if(start>end) return null;
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=start;i<end+1;i++){
            if(arr[i]>max){
                index=i;
                max=arr[i];
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=dfs(start,index-1);
        node.right=dfs(index+1,end);
        return node;
    }
}
