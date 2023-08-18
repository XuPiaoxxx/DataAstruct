package CodeFly;

/**
 * 移除元素-LeetCode:27-代码随想录
 * 2023.08.17/20:58
 * 问题:
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
 * 并返回移除后数组的新长度。不要使用额外的数组空间，你必须仅使用O(1) 额外空间
 * 并 原地 修改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的
 * 元素。
 *
 *样例:
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑
 * 数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而
 * nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * tips:
 * 自己的想法是前后双指针交换，维护两个指针，尤其是循环的第一个指针，当交换后，
 * i不变，再判断i位是否符合条件。
 * earse()函数是length-1，数组整体前移，O(n).
 */
public class L002LeetCode27 {
    public static void main(String[] args) {

    }
    /**
     * 移除元素--自己写的首位双指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int tail=nums.length-1;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==val){
                nums[i]=nums[tail];
                tail--;
                i--;
                length--;
            }
        }
        return length;
    }
    /**
     * 移除元素--同向快慢指针
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
