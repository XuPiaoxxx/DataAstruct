package CodeFly;

/**
 * ��֤����������-LeetCode:98-��������¼
 * 2023.09.17/11.58

 ��Ŀ:����һ�������������ĸ��ڵ� root ������ ������������ͬ�ڵ�ֵ֮�����С��ֵ ��
 ��ֵ��һ������������ֵ������ֵ֮��ľ���ֵ��

 TIPS:
 ���������������ԣ����������ֵ��С�������Ծ���ֵ��С��һ������������ֵ�Ĳ��-ǰ��
*/

public class L0046LeetCode530 {
    public static void main(String[] args) {
    }
    int max=Integer.MAX_VALUE;
    TreeNode pre=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        getMinimumDifference(root.left);
        if(pre!=null&&root.val-pre.val<max){
            max=root.val-pre.val;
            pre=root;
        }else{
            pre=root;
        }
        getMinimumDifference(root.right);
        return max;
    }
}
