package CodeFly;

/**
 * 有序数组的平方-LeetCode:27-代码随想录
 * 2023.08.18/22:06
 * 问题:
 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，
 要求也按 非递减顺序 排序。
 *
 示例 1：
 输入：nums = [-4,-1,0,3,10]
 输出：[0,1,9,16,100]
 解释：平方后，数组变为 [16,1,0,9,100]
 排序后，数组变为 [0,1,9,16,100]
 * tips:
 *    1.变成平方后暴力循环排序
 *    2.双指针，类似一次归并
 *
\
 */
public class L003LeetCode977 {
    public static void main(String[] args) {
        int[] test={-4,-1,0,3,10};
        sortedSquares1(test);
    }

    /**
     *自己写的,疯狂调用Math方法，突出一个懒(双指针)
     * @param nums
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int flag=nums.length-1;
        int[] res=new int[nums.length];
        while(left<=right){
            int l=(int)Math.pow(Math.abs(nums[left]),2);
            int r=(int)Math.pow(Math.abs(nums[right]),2);
            if(l>r){
                res[flag--]=l;
                left++;
            }else if(l<r){
                res[flag--]=r;
                right--;
            }else{
                res[flag--]=l;
                left++;
            }
        }
        return res;
    }

    /**
     * 优化后的双指针
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int flag=nums.length-1;
        int[] res=new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                res[flag--]=nums[left]*nums[left];
                left++;
            }else{
                res[flag--]=nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
