package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��-LeetCode:18-��������¼
 * 2023.08.26/17.54

 ��Ŀ:����һ���� n ��������ɵ����� nums ����һ��Ŀ��ֵ target �������ҳ�����������
 ����ȫ�������Ҳ��ظ�����Ԫ�� [nums[a], nums[b], nums[c], nums[d]] ����������
 Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����0 <= a, b, c, d < na��b��c �� d ������
 ͬnums[a] + nums[b] + nums[c] + nums[d] == target
 ����԰� ����˳�� ���ش� ��

*����:ʾ�� 1��
 * ���룺nums = [1,0,-1,0,-2,2], target = 0
 * �����[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * ʾ�� 2��
 * ���룺nums = [2,2,2,2,2], target = 8
 * �����[[2,2,2,2]
 * tips:
 * �㷨����һ��һ�ε��Ż����Ƚϣ��Ż���
 * ����:�������ǵö�������Ϥ��
 * debug���������ˣ������ô�����
 * С�ļ������ݣ���ǰ��֦(��֦Ҫ�������ؿ������)
*/

public class L0017LeetCode18 {
    public static void main(String[] args) {
        fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int k=0;k<nums.length;k++){
            if(nums[k]>target&&nums[k]>0) break;
            if(k>0&&nums[k-1]==nums[k]) continue;
            for(int i=k+1;i<nums.length;i++){
                if(nums[k]+nums[i]>target&&nums[k]+nums[i]>0) break;
                if(i>k+1&&nums[i-1]==nums[i]) continue;
                int L=i+1;
                int R=nums.length-1;
                while(L<R){
                    int sum=nums[k]+nums[i]+nums[L]+nums[R];
                    if(sum>target){
                        R--;
                    }else if(sum<target){
                        L++;
                    }else{
                        res.add(Arrays.asList(nums[k],nums[i],nums[L],nums[R]));
                        R--;
                        L++;
                        while(L<R&&nums[R]==nums[R-1]) R--;
                        while(L<R&&nums[L]==nums[L+1]) L++;
                    }
                }
            }
        }
        return res;
    }
}
