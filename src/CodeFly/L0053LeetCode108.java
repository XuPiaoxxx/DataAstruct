package CodeFly;

/**
 * 将有序数组转换为二叉搜索树-LeetCode:108-代码随想录
 * 2023.09.20/19.39

 题目:给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 TIPS:
    考虑方法是:
 1.找到中间节点，即为根节点，随后递归分治处理数组左右两边，注意二分
 的边界条件，返回值为TreeNode，随后为左右节点分别赋值为左子树和右
 子树递归，
 注意左闭右开，左闭右闭


*/

public class L0053LeetCode108 {
    public static void main(String[] args) {

    }
    //左闭右闭
    public TreeNode BST1(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=left+((right-left)>>1);
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left=BST1(nums,left,mid-1);
        newNode.right=BST1(nums,mid+1,right);
        return newNode;
    }
    //左闭右开
    public TreeNode BST2(int[] nums,int left,int right){
        if(left>=right) return null;
        int mid=left+((right-left)>>1);
        TreeNode temp=new TreeNode(nums[mid]);
        temp.left=BST2(nums,left,mid);
        temp.right=BST2(nums,mid+1,right);
        return temp;
    }

}
