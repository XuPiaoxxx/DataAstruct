package CodeFly;

/**
 * ɾ�������������еĽڵ�-LeetCode:450-��������¼
 * 2023.09.18/17.54

 ��Ŀ:����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е�
 key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ�����
 ���ĸ��ڵ�����á�
 һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 �����ҵ���Ҫɾ���Ľڵ㣻
 ����ҵ��ˣ�ɾ������
 TIPS:
 ���Ƚ��з�����
 ����˳������ν����ֹ�����������档
 �������¹������������ҽڵ�ָ��Ĳ��ԡ�
 ÿ�ζ���������node.left��node.right
 ���ڵ�Ϊ�գ���Ȼ���ؿա�
 ���ڵ��ֵ����key������ɾ������:
 1.һ��ڵ�Ϊ�գ��򷵻ز�Ϊ�յ��Ǹ��ڵ㣬�൱���Թ��˵�ǰnode
 2.���඼Ϊ�գ�ֱ��return root��ɾ����ǰ�ڵ�
 3.���඼��Ϊ�գ�����ѡ��:
    (1)��ڵ�ȡ����ǰ�ڵ㣬�ҽڵ�ŵ���ڵ�����Ҳ���ұߡ���ͨ��һ��cur����ѭ���ҵ����Ҳ�Ϊ�յĽڵ㣩
    (2)�ҽڵ�ȡ����ǰ�ڵ�...ͬ��
 �����ݹ��߼���
 ��key<��ǰ�ڵ��ֵ��֤��Ŀ��ֵ���������ұߣ�ֻ�ݹ���߲���leftָ�븳ֵ����key���ڵ�ǰ�ڵ��ֵ��ͬ��
 ��󷵻�node��֤���糣���ص�ǰ�ڵ㣬��ǰ�ڵ㲻������������������

*/

public class L0051LeetCode450 {
    public static void main(String[] args) {

    }
    //��������¼���ݹ鷽����ÿ�����Ϸ��ؽڵ㣬���½�������ָ��ĸ�ֵ
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null&&root.right==null){
                return null;
            }else if(root.left!=null&&root.right==null){
                return root.left;
            }else if(root.left==null&&root.right!=null){
                return root.right;
            }else{
                TreeNode cur=root.right;
                while(cur.left!=null){
                    cur=cur.left;
                }
                cur.left=root.left;
                return root.right;
            }
        }//��֦���������Խڵ㶼Ҫ����������һ��ڵ㲻��Ҫ�����Ƕ���������������
//        root.left=deleteNode(root.left,key);
//        root.right=deleteNode(root.right,key);
        if(key<root.val) root.left=deleteNode(root.left,key);
        if(key>root.val) root.right=deleteNode(root.right,key);
        return root;
    }
}
