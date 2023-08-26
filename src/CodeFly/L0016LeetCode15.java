package CodeFly;

import java.util.*;

/**
 * ����֮��-LeetCode:454-��������¼
 * 2023.08.26/15.08

 ��Ŀ:����һ���������� nums ���ж��Ƿ������Ԫ�� [nums[i], nums[j]
 , nums[k]] ���� i != j��i != k �� j != k ��ͬʱ������ nums[i]
 + nums[j] + nums[k] == 0 �����㷵�����к�Ϊ 0 �Ҳ��ظ�����Ԫ�顣
 ע�⣺���в����԰����ظ�����Ԫ�顣

*����:ʾ�� 1��
 * ���룺nums = [-1,0,1,2,-1,-4]
 * �����[[-1,-1,2],[-1,0,1]]
 * ���ͣ�
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 ��
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 ��
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 ��
 * ��ͬ����Ԫ���� [-1,0,1] �� [-1,-1,2] ��
 * ע�⣬�����˳�����Ԫ���˳�򲢲���Ҫ��
 * ʾ�� 2��
 * ���룺nums = [0,1,1]
 * �����[]
 * ���ͣ�Ψһ���ܵ���Ԫ��Ͳ�Ϊ 0 ��
 * ʾ�� 3��
 * ���룺nums = [0,0,0]
 * �����[[0,0,0]]
 * ���ͣ�Ψһ���ܵ���Ԫ���Ϊ 0 ��
 *
 * tips:
 * �Ժ�Ҫע��ϸ���ϵ����⡣�����пգ��жϲ��Ϸ����������⣬��������
 * ��һ����<0.��ô�������к͵���0������Ԫ�أ�����ֱ�ӷ��ؿ����顣
 * ȥ�ص��߼�������������ǻ�����˵����ȫ��⣬ֻ��������������
 * ���������⿼������+˫ָ�룬�±겻�ظ������ڱ��������У������е�������
 * �������ڱ�д�Ĵ����߼��С�
 * �һ���̫����
 * ��Ҫ�Ѽ�֦�븴���ˣ�����׷���ٶȸɵ�����
*/

public class L0016LeetCode15 {
    public static void main(String[] args) {
    }
    /**
     * ����˼·���������Լ�д�����ĵ�
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[right-1]==nums[right]) right--;
                    while(left<right&&nums[left+1]==nums[left]) left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
