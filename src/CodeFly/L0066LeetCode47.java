package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  ȫ���ж�-LeetCode:47-��������¼
 * 2023.09.25/12.29

 ��Ŀ:����һ���ɰ����ظ����ֵ����� nums ��������˳�� �������в��ظ���ȫ���С�

 TIPS:
 ����+��֦ȥ��(Ϊ������)+����ȥ��(Ϊ��ȥ��֮ǰ�ù�����ͬԪ��)
 �������ظ��������+��������
*/

public class L0066LeetCode47 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used=new boolean[nums.length];
        Arrays.sort(nums);
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
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums);
            used[i]=false;
            path.removeLast();
        }
    }

}
