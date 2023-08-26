package CodeFly;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加-LeetCode:454-代码随想录
 * 2023.08.26/12.41

 题目:给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个
 元组 (i, j, k, l) 能满足：
 0 <= i, j, k, l < n
 nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

*样例:示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1

 *
 * tips:
 * 自己写的时候太马虎了，不用考虑去重，在遍历后两个数的时候，一旦符合条件，加上的数是前两个数符合
 * 条件的组数，如果题目要求不能重复则减去map里的value值，没要求则不用对map进行操作。
 */

public class L0015LeetCode454 {
    public static void main(String[] args) {


    }

    /**
     *自己写的
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
     * 优质解答，虽然方法一样，但是考虑了细节和getOrDefault的运用，不考虑下标的递归可以用增强
     * for实现。
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
