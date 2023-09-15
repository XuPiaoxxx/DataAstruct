package CodeFly;

import java.util.HashMap;

/**
 * 最大二叉树-LeetCode:654-代码随想录
 * 2023.09.15/22.18

 题目:给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 创建一个根节点，其值为 nums 中的最大值。
 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 返回 nums 构建的 最大二叉树 。

 TIPS:
 形如LeetCode106
 逻辑稍有变化，但本质还是对数组左右分治，返回符合要求的节点，套路!

*/

public class L0042LeetCode654 {
    public static void main(String[] args) {
        int[] arr={3,2,1,6,0,5};
        constructMaximumBinaryTree(arr);
    }
    //举一反三自己写出来的，类比LC112
    static int[]  arr;
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        arr=nums;
        TreeNode root = dfs(0,arr.length-1);
        return root;
    }
    public static TreeNode dfs(int start,int end){
        if(start>end) return null;
        int index=0;
        int max=Integer.MIN_VALUE;
        for(int i=start;i<end+1;i++){
            if(arr[i]>max){
                index=i;
                max=arr[i];
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=dfs(start,index-1);
        node.right=dfs(index+1,end);
        return node;
    }
}
