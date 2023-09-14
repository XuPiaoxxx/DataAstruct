package CodeFly;

/**
 * ·���ܺ�-LeetCode:112-��������¼
 * 2023.09.14/21.48

 ��Ŀ:����������ĸ��ڵ� root ��һ����ʾĿ��͵����� targetSum ���жϸ������Ƿ�
 ���� ���ڵ㵽Ҷ�ӽڵ� ��·��������·�������нڵ�ֵ��ӵ���Ŀ��� targetSum ����
 �����ڣ����� true �����򣬷��� false ��Ҷ�ӽڵ� ��ָû���ӽڵ�Ľڵ㡣

 TIPS:��������˵���������ĵ��ǲ��ϵ����ϲ㷵��true����false��һ��ʼ���
 ʲôʱ�򷵻غ��Ի󣬴��ݷ���ֻ����true��һֱ���ϣ����������棬���������������
 ��������ͷ���false


*/

public class L0040LeetCode112 {
    public static void main(String[] args) {

    }
    //�Լ�˼·д��
    public boolean dfs1(TreeNode node,int targetSum,int sum){
        if(node.left==null&&node.right==null){
            if(sum==targetSum){
                return true;
            }else{
                return false;
            }
        }
        if(node.left!=null){
            sum+=node.left.val;
            if(dfs1(node.left,targetSum,sum))return true;
            sum-=node.left.val;
        }
        if(node.right!=null){
            sum+=node.right.val;
            if(dfs1(node.right,targetSum,sum))return true;
        }
        return false;
    }
    //��������¼ѧϰ-�޸Ĵ�������¼�ݹ���룬��һ�ָ����������뷽ʽ�����������0��ʼ�ӡ�
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&targetSum==root.val){
            return true;
        }else if(root.left==null&&root.right==null&&targetSum==root.val){
            return false;
        }
        if(root.left!=null){
            if(hasPathSum(root.left,targetSum-root.val)) return true;
        }
        if(root.right!=null){
            if(hasPathSum(root.right,targetSum-root.val)) return true;
        }
        return false;
    }


}
