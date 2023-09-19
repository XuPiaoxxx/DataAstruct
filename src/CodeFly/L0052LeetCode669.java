package CodeFly;

/**
 * �޽�����������-LeetCode:669-��������¼
 * 2023.09.19/22.29

 ��Ŀ:��������������ĸ��ڵ� root ��ͬʱ������С�߽�low �����߽�
 high��ͨ���޼�������������ʹ�����нڵ��ֵ��[low, high]�С��޼�
 �� ��Ӧ�� �ı䱣�������е�Ԫ�ص���Խṹ (�������û�б��Ƴ���ԭ��
 �ĸ����Ӵ���ϵ��Ӧ������)�� ����֤�������� Ψһ�Ĵ� ��
 TIPS:
 ���Ƚ��з�����
 ����˳������ν����ֹ�����������档
 �������¹������������ҽڵ�ָ��Ĳ��ԡ�
 ÿ�ζ���������node.left��node.right
 ���ڵ�Ϊ�գ���Ȼ���ؿա�
 ������root.valС��low�������֤��root.left����������ֵ�������ϣ�
 ����ֱ�Ӳ����ǣ��������������д���low����������Է��صݹ������Ľ��
 ͬ��root.val����high��
 �����ǰ�ڵ���ϣ��������ڣ���������ָ�����ָ�룬���Ϸ��ص�ǰ�ڵ㡣

*/

public class L0052LeetCode669 {
    public static void main(String[] args) {

    }
    //��������¼���ݹ鷽����ÿ�����Ϸ��ؽڵ㣬���½�������ָ��ĸ�ֵ
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val<low) return trimBST(root.right,low,high);
        if(root.val>high) return trimBST(root.left,low,high);

        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}
