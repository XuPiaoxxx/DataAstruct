package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  �Ӽ� II-LeetCode:90-��������¼
 * 2023.09.24/17.20

 ��Ŀ:����һ���������� nums �����п��ܰ����ظ�Ԫ�أ����㷵�ظ��������п��ܵ��Ӽ����ݼ�����

 �⼯ ���� �����ظ����Ӽ������صĽ⼯�У��Ӽ����԰� ����˳�� ���С�
 TIPS:used�����Ӧ��
 �ڵ�ǰֵ����ǰһ��ֵ�������:
 ��used��i��==true֤����Ӧiλ�õ����ù������Լ�ͳ�Ƶ�Ҫ�ռ��ļ����У���ǰi+1���µ�һ��Ԫ�أ����Բ���ȥ�ء�
 ��used��i��==false֤����Ӧλ�õ���û��ͳ���ڼ����У��������ظ�ʹ����ͬԪ����һ�������е��������Ҫȥ�ء�



*/

public class L0063LeetCode90 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums,0,used);
        return res;
    }
    void backTrack(int[] nums,int start,boolean[] used){
        res.add(new ArrayList(path));
        for(int i=start;i<nums.length;i++){
            if(i>0&&!used[i-1]&&nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums,i+1,used);
            used[i]=false;
            path.removeLast();
        }
    }

}
