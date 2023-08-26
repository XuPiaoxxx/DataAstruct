package CodeFly;

import java.util.*;

/**
 * 三数之和-LeetCode:454-代码随想录
 * 2023.08.26/15.08

 题目:给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j]
 , nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i]
 + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。

*样例:示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * tips:
 * 以后要注意细节上的问题。比如判空，判断不合法，例如这题，排序后，如果
 * 第一个数<0.那么不可能有和等于0的三个元素，所以直接返回空数组。
 * 去重的逻辑大致清楚，但是还不能说是完全理解，只能算是马马虎虎。
 * 见到类似题考虑排序+双指针，下标不重复体现在遍历过程中，数组中的数不重
 * 复体现在编写的代码逻辑中。
 * 我还是太菜了
 * 不要把剪枝想复杂了，那是追求速度干的事情
*/

public class L0016LeetCode15 {
    public static void main(String[] args) {
    }
    /**
     * 看了思路，大致是自己写出来的的
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
