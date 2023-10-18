package CodeFly;

import java.util.*;

/**
 *  下一个更大元素 I--LeetCode:496-代码随想录
 * 2023.10.18/17.35

 题目:nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。 */
//1.暴力  2.单调栈+哈希映射


    //单调栈只是利用栈这个数据结构，要做到单调，还需要程序员自己在入栈时候进行判断，
    //总而言之，我们只是利用单调栈来解决相关的问题。
    //从栈顶到栈低，升序，则按从左到右遍历数组，找的是右边出现的第一个大于当前元素的(保存在栈中)值
    //反之降序栈则是找最先出现的小于当前元素的值。
    //升序降序与否要在入栈时程序员自己判断
    //并且在当前遍历元素与栈顶元素进行比较时要根据不同的条件进行不同的数据处理
    //不要忘记入栈操作和栈空的预防
    //单调栈的作用就是存储之前遍历过得元素，在之后条件满足再赋对应的值。

    //本题可以分为两步:1.单数组的单调栈求右边第一个最大元素2.第二个数组遍历并且判断哈希映射来求
    //对应的值
public class L00123LeetCode496 {
    public static void main(String[] args) {

    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack=new LinkedList();
        Map<Integer,Integer> map=new HashMap();
        stack.push(nums2[0]);
        for(int i=1;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                res[i]=map.get(nums1[i]);
            }
        }
        return res;
    }
}
