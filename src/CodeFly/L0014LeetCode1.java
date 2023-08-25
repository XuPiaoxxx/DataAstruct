package CodeFly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���˿���������leetcode��һ����������-LeetCode:1-��������¼
 * 2023.08.25/11.41

 ��Ŀ:����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target  ���� ���� ���������������ǵ������±ꡣ
 ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
 ����԰�����˳�򷵻ش𰸡�
*����:
 ʾ�� 1��
 ���룺nums = [2,7,11,15], target = 9
 �����[0,1]
 ���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
 ʾ�� 2��
 ���룺nums = [3,2,4], target = 6
 �����[1,2]
 *
 * tips:
 * ��Ŀ��˵���ܷ��������±���ͬҲ���ǲ���ͬһ��Ԫ�صĺ͵���target��
 * map�ⷨ�Լ��ų������ֿ��ܣ���Ϊһ�α�����
 * ˫forѭ��-ͨ�������ڲ�ѭ���Ŀ�ʼ�±꣬�ų��±��ظ��Ŀ��ܡ�
 */

public class L0014LeetCode1 {
    public static void main(String[] args) {

    }

    /**
     * ����һ����ʷ�ύд�ġ���©������½�����ֱ�ӷ��ء�
     * return new int[]{map.get(target-nums[i]),i};
     * ��ʼ����ʽ:(��̬��ʼ��)
     * int[] ints=new int[]{1��2��3};
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])&&(map.get(target-nums[i]))!=i){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
