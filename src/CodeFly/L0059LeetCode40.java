package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  ����ܺ� II-LeetCode:40-��������¼
 * 2023.09.23/21.18

 ��Ŀ:����һ����ѡ�˱�ŵļ��� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�

 candidates �е�ÿ��������ÿ�������ֻ��ʹ�� һ�� ��

 ע�⣺�⼯���ܰ����ظ�����ϡ�
 TIPS:
 �������漰�ظ�����������ĿҪ����������ظ�����֦�ظ��ĸ��
 �������ظ�����ȥ�أ�����used���飬
 ��Ҳ���԰����Լ���ķ���������ڵ�ǰ���������ڣ�ͬһ�㣩
 �ظ���continue��


*/

public class L0059LeetCode40 {
    public static void main(String[] args) {

    }
    //�Լ����ȥ�ط���(��Ļ��ʾ)
//    List<List<Integer>> res=new ArrayList();
//    LinkedList<Integer> row=new LinkedList();
//    int sum=0;
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        backTrack(candidates,target,0);
//        return res;
//    }
//    public void backTrack(int[] candidates,int target,int start){
//        if(sum==target){
//            res.add(new ArrayList(row));
//            return;
//        }
//        for(int i=start;i<candidates.length;i++){
//            if(sum+candidates[i]>target) return;
    //ȥ���߼��ؼ�
//            if(i>start&&candidates[i]==candidates[i-1]) continue;
//            sum+=candidates[i];
//            row.add(candidates[i]);
//            backTrack(candidates,target,i+1);
//            row.removeLast();
//            sum-=candidates[i];
//        }
//    }
    //����used����,�´����������Ⳣ���Լ�д����!
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // �ӱ�־���飬���������ж�ͬ��ڵ��Ƿ��Ѿ�����
        Arrays.fill(used, false);
        // Ϊ�˽��ظ������ֶ��ŵ�һ�������Ƚ�������
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // �����ظ��ڵ㣬ͬ��ĵ�һ���ڵ��Ѿ������ʹ�������ֱ������
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // ÿ���ڵ����ѡ��һ�Σ����Դ���һλ��ʼ
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
