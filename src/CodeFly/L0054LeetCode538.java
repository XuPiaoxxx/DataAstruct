package CodeFly;

/**
 * �Ѷ���������ת��Ϊ�ۼ���-LeetCode:538-��������¼
 * 2023.09.20/21.11

 ��Ŀ:�������� ���� ���ĸ��ڵ㣬�����Ľڵ�ֵ������ͬ�����㽫��ת��Ϊ�ۼ�����Greater Sum Tree����
 ʹÿ���ڵ� node ����ֵ����ԭ���д��ڻ���� node.val ��ֵ֮�͡�
 TIPS:
    ���Ƿ�����:
 ������ã��Ӵ�С���𽥼��Ϻ����ֵ����Ϊ��
 ����������  �������Ǵ�С�����˳������������ǴӴ�
 ��С��˳��
 ����ʵ�ֵݹ飬����ȫ�ֱ���(��������һ��pre�ڵ��ǰһ�����ڵ�)
 ÿ�α���������ǰ��ֵ�ĺ�


*/

public class L0054LeetCode538 {
    public static void main(String[] args) {

    }
    int count=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        root.right=convertBST(root.right);
        root.val+=count;
        count=root.val;
        root.left=convertBST(root.left);
        return root;
    }

}
