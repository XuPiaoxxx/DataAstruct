package CodeFly;

import java.util.Arrays;

/**
 *  K 次取反后最大化的数组和-LeetCode:1005-代码随想录
 * 2023.09.29/21.27

 题目:给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。

 以这种方式修改数组后，返回数组 可能的最大和 。



 TIPS:
 贪心算法，
 策略比较重要
 1.贪心!
 先把负的转化为正的
 如果全部都不为负数，就只针对最小的元素进行操作，把k次操作
 全都分配给它

 1可以先排序，遍历完负数，再排序，再对最小的操作
 2可以按照绝对值的大小顺序进行排序(Java中的比较器对象，不能比较int基础类型)
 必须转化为Integer数组进行自定义排序，遍历只针对负的数进行反转，如果还有操作数k，就
 只针对最小的值操作，因为绝对值排序，所以只用排序一次。

 注意:最后针对最小值排序，可以对剩余k%2,免除了重复取反的操作。更快



*/

public class L0075LeetCode1005 {
    public static void main(String[] args) {
    }
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-1&&nums[i]<0&&k>0){
            nums[i]=-nums[i];
            k--;
            i++;
        }
        Arrays.sort(nums);
        i=0;
        while(k>0){
            nums[i]=-nums[i];
            k--;
        }
        return Arrays.stream(nums).sum();
    }

}
