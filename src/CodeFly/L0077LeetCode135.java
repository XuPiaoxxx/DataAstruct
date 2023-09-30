package CodeFly;

import java.util.Arrays;

/**
 *  分发糖果-LeetCode:135-代码随想录
 * 2023.09.30/17.44

 题目:n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 你需要按照以下要求，给这些孩子分发糖果：
 每个孩子至少分配到 1 个糖果。
 相邻两个孩子评分更高的孩子会获得更多的糖果。
 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 TIPS:
 既要看左边又要看右边
 所以:
 1.只看右边大于左边的情况，此时因为左边的值对于右边的值有影响(所以从左向右遍历)
 2.只看左边大于右边的情况，此时因为右边的值对于左边的值有影响(所以从右向左，倒着遍历)
 (这样才能保证无后效性)
 因为每个孩子至少有一颗糖果，所以最后加上数组的长度和糖果数组总和。
 因为 rating[5]与rating[4]的比较 要利用上 rating[5]与rating[6]的比较结果，所以 要从后向前遍历。
 如果从前向后遍历，rating[5]与rating[4]的比较 就不能用上 rating[5]与rating[6]的比较结果了
 */

public class L0077LeetCode135 {
    public static void main(String[] args) {
    }
    //自己写的代码本质上就是暴力，下面的代码时间复杂度更低。
    //Stream的效率很低，时间对比for循环求和慢很多，代码少
    public int candy(int[] ratings) {
        int[] candys=new int[ratings.length];
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candys[i]=candys[i-1]+1;
        }
        for(int i=ratings.length-1;i>0;i--){
            if(ratings[i-1]>ratings[i]) candys[i-1]=Math.max(candys[i-1],candys[i]+1);
        }
        //return ratings.length+ Arrays.stream(candys).sum();
        int ans=0;
        for(int i:candys){
            ans+=i;
        }
        return ratings.length+ans;
    }
}
