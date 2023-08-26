package CodeFly;

import java.util.HashMap;
import java.util.Map;

/**
 * �������-LeetCode:454-��������¼
 * 2023.08.26/12.41

 ��Ŀ:�����ĸ��������� nums1��nums2��nums3 �� nums4 �����鳤�ȶ��� n ����������ж��ٸ�
 Ԫ�� (i, j, k, l) �����㣺
 0 <= i, j, k, l < n
 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

*����:ʾ�� 2��
 * ���룺nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * �����1

 *
 * tips:
 * �Լ�д��ʱ��̫���ˣ����ÿ���ȥ�أ��ڱ�������������ʱ��һ���������������ϵ�����ǰ����������
 * �����������������ĿҪ�����ظ����ȥmap���valueֵ��ûҪ�����ö�map���в�����
 */

public class L0015LeetCode454 {
    public static void main(String[] args) {


    }

    /**
     *�Լ�д��
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public static int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map1=new HashMap();
        int count=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                map1.put(nums1[i]+nums2[j],map1.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                if(map1.containsKey(-(nums3[i]+nums4[j]))&&map1.get(-(nums3[i]+nums4[j]))!=0){
                    map1.put(-(nums3[i]+nums4[j]),map1.get(-(nums3[i]+nums4[j]))-1);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ���ʽ����Ȼ����һ�������ǿ�����ϸ�ں�getOrDefault�����ã��������±�ĵݹ��������ǿ
     * forʵ�֡�
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int sum = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                sum += map.getOrDefault(-i - j, 0);
            }
        }
        return sum;
    }


}
