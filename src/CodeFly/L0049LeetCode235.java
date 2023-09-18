package CodeFly;

/**
 * �����������������������-LeetCode:236-��������¼
 * 2023.09.18/12.21

 ��Ŀ:����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 TIPS:
 ���������������ԣ�1������С�ڸ��ڵ㣬�Һ��Ӵ��ڸ��ڵ�
                2.�����������
 ����ȷ���˱������������ڵ��ֵ��p��q֮�伴Ϊ��ʼ�ֲ�������������
*/

public class L0049LeetCode235 {
    public static void main(String[] args) {

    }
    //�����ⷨ
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val&&root.val>q.val) root=root.left;
            else if(root.val<p.val&&root.val<q.val) root=root.right;
            else return root;
        }
        return root;
    }
    //�ݹ�ⷨ
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val>p.val&&root.val>q.val){
            TreeNode left=lowestCommonAncestor1(root.left,p,q);
            if(left!=null) return left;
        }else if(root.val<p.val&&root.val<q.val){
            TreeNode right=lowestCommonAncestor1(root.right,p,q);
            if(right!=null) return right;
        }
        return root;
    }

}
