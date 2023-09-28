package CodeFly;

/**
 *  跳跃游戏 II-LeetCode:45-代码随想录
 * 2023.09.28/18.19

 题目:给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

 0 <= j <= nums[i]
 i + j < n
 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



 TIPS:
 贪心算法，
 数组长度为1，不用跳，返回0
 假如数组大于等于2，则至少跳1次，res初始化为1.
 设置一个next保存下次能跳到的最远位置，同时不断在当前能跳到的最远位置间遍历。
 假如到了当前最远位置，还没到终点，则将当前最远位置设置为next，跳跃次数res++。
 如果此时正好到了终点，则直接终止循环，返回计数。
 若是循环完了还没终止，则代表最远位置大于终点，末尾返回res



*/

public class L0074LeetCode45 {
    public static void main(String[] args) {
    }
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int res=1,next=0,cur=nums[0];
        for(int i=1;i<nums.length;i++){
            next=Math.max(next,nums[i]+i);
            if(i==cur){
                if(i==nums.length-1) break;
                cur=next;
                res++;
            }
        }
        return res;
    }

}
