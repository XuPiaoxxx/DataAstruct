package CodeFly;

/**
 * ������������е�����-LeetCode:501-��������¼
 * 2023.09.17/14.32

 ��Ŀ:����һ�����ظ�ֵ�Ķ�����������BST���ĸ��ڵ� root ���ҳ������� BST �е����� ��������������Ƶ����ߵ�Ԫ�أ���
 ��������в�ֹһ�����������԰� ����˳�� ���ء�
 �ٶ� BST �������¶��壺
 ����������������ڵ��ֵ С�ڵ��� ��ǰ�ڵ��ֵ
 ����������������ڵ��ֵ ���ڵ��� ��ǰ�ڵ��ֵ
 �����������������Ƕ���������
 TIPS:
 �������������������ͨ��ȫ�ֱ���maxCount��¼���������г��ֵ���������ÿ�ε��ֲ����ֵ�����Ĵ���count>maxCount��ʱ�򣬸���maxCount��ֵ�����֮ǰ��maxCount��Ϊ��׼�������ļ��ϣ����ټ��뵱ǰ����Ϊ��һ���Ե�ǰmaxCountΪ���ִ�����������
 ȫ�ֱ���max��¼�ֲ���Χ�������ֵ���ֵͬ(��Ϊ�������˳���С������ֵͬһ������)
 ��������������������Ӵ�С�����У�ǰ����ֹ���--�����֣�
*/

public class L0047LeetCode501 {
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
