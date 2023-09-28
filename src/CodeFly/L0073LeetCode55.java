package CodeFly;

/**
 *  ��Ծ��Ϸ-LeetCode:55-��������¼
 * 2023.09.28/18.19

 ��Ŀ:����һ���Ǹ��������� nums �������λ������� ��һ���±� �������е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

 �ж����Ƿ��ܹ��������һ���±꣬������ԣ����� true �����򣬷��� false ��


 TIPS:
 ̰��˼·��
 ��ȡ�����Ƿ�Χ�ĸ��ÿ�α��������е�Ԫ�أ����Ƿ�Χ���ڵ�ǰλ�ö������쵽i+nums[i]
 ������coverӦ�ñ�֤���ֵ����ÿ�θ�ֵǰ���жϣ���������cover���󣬼����Ǹ��ࡣ
 ������Ƿ�Χ���������һ��λ�ã�����true��
 ע��:Ĭ�����±����������ʼΪ0�����һ��λ��Ϊlength-1



*/

public class L0073LeetCode55 {
    public static void main(String[] args) {
    }
    public boolean canJump(int[] nums) {
        int cover=0;
        for(int i=0;i<=cover;i++){
            cover=Math.max(nums[i]+i,cover);
            if(cover>=nums.length-1) return true;
        }
        return false;
    }

}
