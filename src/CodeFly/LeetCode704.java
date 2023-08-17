package CodeFly;

/**
 * 二分查找-LeetCode:704-代码随想录
 * 2023.08.17/20:32
 * 问题:
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *样例:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * tips:边界问题,把握不好
 * 根据左闭右闭还是左闭右开，选择循环条件left和right的关系，
 * 再由mid判断left和right的赋值
 * 边界的规则通过区间的定义来
 */
public class LeetCode704 {
    public static void main(String[] args) {

    }

    /**
     * 左闭右开
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int l=0;
        int r=nums.length;//不同点
        int mid=r/2;
        while(l<r){
            if(target<nums[mid]){
                r=mid;
            }else if(target>nums[mid]){
                l=mid+1;
            }else {
                return mid;
            }
            mid=l+(r-l)/2;
        }
        return -1;
    }

    /**
     * 左闭右闭
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while(left<=right){
            if(nums[mid]>target){
                right=mid-1;
                mid=left+(right-left)/2;
            }else if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
