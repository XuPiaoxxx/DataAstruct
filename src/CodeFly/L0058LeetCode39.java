package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  ����ܺ�-LeetCode:39-��������¼
 * 2023.09.23/20.48

 ��Ŀ:����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ���ҳ� candidates
 �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� �������б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 TIPS:
 ģ������ݱ����ⷨ��С��֦����:
 �Ȱ��������������ǰ���Լ�����target������������Ҳ����Ҫ������
 ֱ�ӷ��ص��ϲ㼴�ɡ�


*/

public class L0058LeetCode39 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> row=new LinkedList();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0);
        return res;
    }
    public void backTrack(int[] candidates,int target,int start){
        if(sum==target&&res.size()<150){
            res.add(new LinkedList(row));
            return;
        }else if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(sum+candidates[i]>target) break;
            row.add(candidates[i]);
            sum+=candidates[i];
            backTrack(candidates,target,i);
            sum-=candidates[i];
            row.removeLast();
        }
    }

}
