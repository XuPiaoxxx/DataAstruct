package CodeFly;

/**
 *  打家劫舍 III--LeetCode:337-代码随想录
 * 2023.10.10/17.11

 题目:小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 TIPS:
 开始打家劫舍系列问题!
本题是入门的树状DP问题(也就是状态在树形结构中进行转移，通常伴随着树的遍历)
 本题要转移一个1*2的数组，也就是同时要转移两个数，所以有两个对应的状态转移
 方程
 */

public class L00103LeetCode337 {
    public static void main(String[] args) {

    }
    //树形dp动态规划解法:
    //1.每层的栈帧中都存储了一个dp二维数组，局部变量---dp[0]代表不偷当前节点的最大金额，dp[1]代表偷当前节点的最大金额
    //2.同时进行一个数组的状态转移，对2个值分别设置一个动态转移方程:
    // dp[0]=max(left[0],left[1])+max(right[0],right[1])不偷当前节点，求左右子节点两种选择中的金额更大的方法，相加
    // dp[1]=node.val+left[0]+right[0]----偷当前节点，那么左右子结点一定不能偷，所以加上左右子结点不偷时的最大金额
    // 所以当前节点能偷的最大金额就是dp[0],dp[1]的最大值
    //3.初始化，当遍历到树底，节点为空，这时偷不偷当前节点都是0，所以 dp[0]=0.dp[1]=0.向上返回数组{0,0}
    //4.后序遍历二叉树，目的是要先收集左右节点的值的大小(信息)，当前节点的状态转移需要两个孩子节点的信息

    //5.打印
    public int rob(TreeNode root) {
        int[] dp=new int[2];
        dp=dfs(root);
        return Math.max(dp[0],dp[1]);
    }
    public int[] dfs(TreeNode node){
        if(node==null) return new int[2];
        int[] temp=new int[2];
        int[] left=dfs(node.left);
        int[] right=dfs(node.right);
        temp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        temp[1]=node.val+left[0]+right[0];
        return temp;
    }

}
