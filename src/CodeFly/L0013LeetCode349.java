package CodeFly;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集-LeetCode:349-代码随想录
 * 2023.08.25/11.41

 题目:给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素
 一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
*样例:
 示例 1：
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2]
 示例 2：
 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[9,4]
 解释：[4,9] 也是可通过的
 *
 * tips:
 */

public class L0013LeetCode349 {
    public static void main(String[] args) {

    }

    /**
     * 新建了个基础底层数组来存储，好处是不涉及到转换的问题。
     * 如何将ArrayList转换为数组:JAVA8提出新方式
     * // 想要转换成int[]类型，就得先转成IntStream。
     * // 这里就通过mapToInt()把Stream<Integer>调用Integer::valueOf来转成IntStream
     * // 而IntStream中默认toArray()转成int[]。
     * int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
     * 查询可知intValue用时1ms，valueOf用时2ms，
     * 因为mapToInt是由类型T返回int型，
     * 前者是变为int，后者是变为Integer，后着还需要进行Integer到int的操作
     * 所以后者慢
     *
     * 还可以一个数组一个set，数组大小为1000，第一个数组遍历有的设为1，第二个判断对应位置为1即
     * 添加到set数组中
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet();
        Set<Integer> set2=new HashSet();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i]))set2.add(nums2[i]);
        }
        int[] arr=new int[set2.size()];
        int i=0;
        for(Integer n : set2){
            arr[i]=n;
            i++;
        }
        return arr;
    }
}
