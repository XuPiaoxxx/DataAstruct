package CodeFly;

/**
 * �ϲ�������-LeetCode:617-��������¼
 * 2023.09.16/12.36

 ��Ŀ:�������ö������� root1 �� root2 ��
 ����һ�£����㽫����һ�ø��ǵ���һ��֮��ʱ���������ϵ�һЩ�ڵ㽫���ص�������һЩ���ᣩ��
 ����Ҫ�����������ϲ���һ���¶��������ϲ��Ĺ����ǣ���������ڵ��ص�����ô���������ڵ��ֵ
 �����Ϊ�ϲ���ڵ����ֵ�����򣬲�Ϊ null �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 ���غϲ���Ķ�������
 ע��: �ϲ����̱�����������ĸ��ڵ㿪ʼ��

 TIPS:
 ͬʱ����������������˼·���ѣ������ҵ��Ƕ���һ��һ���յĽڵ㴦����
*/

public class L0043LeetCode617 {
    public static void main(String[] args) {
    }
    //ֱ�Ӹ���root1��
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        root1.val+=root2.val;
        root1.left = mergeTrees1(root1.left,root2.left);
        root1.right = mergeTrees1(root1.right,root2.right);
        return root1;
    }
    //�½�һ����������Ϊres����
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2==null?null:new TreeNode(root2.val,root2.left,root2.right);
        if(root2==null) return new TreeNode(root1.val,root1.left,root1.right);
        TreeNode node=new TreeNode(root1.val+root2.val);
        node.left=mergeTrees2(root1.left,root2.left);
        node.right=mergeTrees2(root1.right,root2.right);
        return node;
    }
}
