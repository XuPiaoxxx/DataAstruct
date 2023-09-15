package CodeFly;

import java.util.HashMap;

/**
 * �����������������й��������-LeetCode:106-��������¼
 * 2023.09.15/19.27

 ��Ŀ:���������������� inorder �� postorder ������ inorder �Ƕ��������������
 �� postorder ��ͬһ�����ĺ�����������㹹�첢������� ������ ��

 TIPS:
 ֱ�ӷָ����飬�������飬�½����飬�漰��̫�����Ĳ�����ÿ�εݹ鶼���½����������
 ͨ��ѧϰ�����˵Ľⷨ��������ȫ�ֵ�HashMap�������ֵ����Ϊ���������и��ڵ���Ϊ�ָ��
 ����������ȫ�ֵ�post�����������顣����ÿ�εݹ鴫�Ķ��������±꣬���漰�½����飬
 ������ٶȾͻ��������ֻ����ȫ�ֵ����顣


*/

public class L0041LeetCode106 {
    public static void main(String[] args) {

    }
    //�Լ����մ�������¼˼·��д���ǳ�����
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        //����Ҷ�ӽڵ�
        if(postorder.length==1) return root;
        //��������index
        int index;
        //�ҵ��ָ�㣬Ϊ�����������һ����
        for(index=0;index<inorder.length;index++){
            if(inorder[index]==postorder[postorder.length-1]){
                break;
            }
        }
        //�и���������
        int[] leftInorder=new int[index];
        for(int i=0;i<index;i++){
            leftInorder[i]=inorder[i];
        }
        int[] rightInorder=new int[inorder.length-leftInorder.length-1];
        for(int i=index+1;i<inorder.length;i++){
            rightInorder[i-(index+1)]=inorder[i];
        }
        //�и��������
        int[] leftPostorder=new int[leftInorder.length];
        for(int i=0;i<leftInorder.length;i++){
            leftPostorder[i]=postorder[i];
        }
        int[] rightPostorder=new int[rightInorder.length];
        for(int i=0;i<rightInorder.length;i++){
            rightPostorder[i]=postorder[leftPostorder.length+i];
        }
        //Ϊ��ǰ���ҽڵ㸳ֵ�����ݹ鴦����һ��ڵ�
        root.left=buildTree(leftInorder,leftPostorder);
        root.right=buildTree(rightInorder,rightPostorder);
        return root;
    }

    //ѧϰ�ˣ����нⷨ
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
