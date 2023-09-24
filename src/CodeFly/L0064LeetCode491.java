package CodeFly;

import java.util.*;

/**
 *  ����������-LeetCode:491-��������¼
 * 2023.09.24/19.14

 ��Ŀ:����һ���������� nums ���ҳ����������и������в�ͬ�ĵ��������У������������� ����������Ԫ�� ������԰� ����˳�� ���ش𰸡�

 �����п��ܺ����ظ�Ԫ�أ����������������ȣ�Ҳ���������������е�һ�����������
 TIPS:
 �Լ����뷨+��������¼ȥ�ط�����+˼��
 ���ݱ����ݹ�ⷨ��ÿ�λ��ݶ�����ǰһ��ֵpre�����ж��Ƿ��ǵ������С�
 ���������������preΪ��ǰֵʱ������ļ��ϻ���Ե�ǰֵ������
 �ж�ȥ�ص��߼�����Set���ϣ�ÿһ�㿪��һ���µ�set���ϣ����Բ��ý��л��ݵ����Ĳ�����
 һ���������ù���Ԫ�أ��Լ���  ��ǰnum��i��<preʱ��ֱ�ӵ�ǰֵ������һ��nums��i+1�������ж�


*/

public class L0064LeetCode491 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0,Integer.MIN_VALUE);
        return res;
    }
    void backTrack(int[] nums,int start,int pre){
        if(path.size()>=2){
            res.add(new ArrayList(path));
        }
        Set<Integer> set=new HashSet();
        for(int i=start;i<nums.length;i++){
            if(nums[i]<pre||set.contains(nums[i])){
                pre=nums[i];
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backTrack(nums,i+1,nums[i]);
            path.removeLast();
        }
    }

}
