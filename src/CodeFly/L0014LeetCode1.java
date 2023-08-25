package CodeFly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 有人看海，有人leetcode第一题做不出来-LeetCode:1-代码随想录
 * 2023.08.25/11.41

 题目:给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 你可以按任意顺序返回答案。
*样例:
 示例 1：
 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 示例 2：
 输入：nums = [3,2,4], target = 6
 输出：[1,2]
 *
 * tips:
 * 题目中说不能返回数组下标相同也就是不能同一个元素的和等于target。
 * map解法以及排除了这种可能，因为一次遍历。
 * 双for循环-通过定义内层循环的开始下标，排除下标重复的可能。
 */

public class L0014LeetCode1 {
    public static void main(String[] args) {

    }

    /**
     * 看了一眼历史提交写的。疏漏了如何新建数组直接返回。
     * return new int[]{map.get(target-nums[i]),i};
     * 初始化方式:(静态初始化)
     * int[] ints=new int[]{1，2，3};
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
