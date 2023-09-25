package CodeFly;

import java.util.*;

/**
 *  ȫ����-LeetCode:46-��������¼
 * 2023.09.25/12.21

 ��Ŀ:����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ��
 ����� ������˳�� ���ش𰸡�

 TIPS:
 ȫ����(����ϵĽⷨ�û�������ǧ˿���Ƶ���ϵ)
 ��������һ��used�����ǻ������νṹ���ù���Ԫ�أ�ÿ�ζ���0��ʼ���ݹ�����nums�������ڸ�·�����ù�����(used��i��=true)��ʾ��������������
 ����Ϊ��ȥ�������������startIndex�������²�����Ŀ�ʼ�±�(��Ϊÿ�ζ�ȫ������)

*/

public class L0065LeetCode46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        backTrack(nums);
        return res;
    }
    void backTrack(int[] nums){
        if(path.size()==nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums);
            used[i]=false;
            path.removeLast();
        }
    }

}
