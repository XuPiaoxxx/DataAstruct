package CodeFly;

/**
 * �ж��Ƿ���ƽ�������-LeetCode:110-��������¼
 * 2023.09.09/22.05

 ��Ŀ:����һ�����������ж����Ƿ��Ǹ߶�ƽ��Ķ�������
 *
 * tips:
 * ��ͨ������:���ֱ���O(n)
 * ��ȫ������:
 *
 *
*/

public class L0036LeetCode110 {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)==-1?false:true;
    }
    public int getHeight(TreeNode node){
        if(node==null) return 0;
        int leftCount=getHeight(node.left);
        if(leftCount==-1) return -1;
        int rightCount=getHeight(node.right);
        if(rightCount==-1) return -1;
        if(Math.abs(leftCount-rightCount)>1){
            return -1;
        }else{
            return 1+Math.max(leftCount,rightCount);
        }
    }
}
