package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  �Ӽ�-LeetCode:78-��������¼
 * 2023.09.24/13.28

 ��Ŀ:����һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 TIPS:
    ����һ�㱩�����ݽ���������ÿ�ζ���������ӵ�������С�


*/

public class L0062LeetCode78 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums,0);
        return res;
    }
    public void backTrack(int[] nums,int start){
        res.add(new ArrayList(path));
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }
}
