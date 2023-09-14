package CodeFly;

/**
 * 路径总和-LeetCode:112-代码随想录
 * 2023.09.14/21.48

 题目:给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否
 存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如
 果存在，返回 true ；否则，返回 false 。叶子节点 是指没有子节点的节点。

 TIPS:对于我来说不容易理解的点是不断地向上层返回true或者false，一开始会对
 什么时候返回很迷惑，传递返回只有是true就一直向上，不便利后面，如果遍历完整个树
 还不满足就返回false


*/

public class L0040LeetCode112 {
    public static void main(String[] args) {

    }
    //自己思路写的
    public boolean dfs1(TreeNode node,int targetSum,int sum){
        if(node.left==null&&node.right==null){
            if(sum==targetSum){
                return true;
            }else{
                return false;
            }
        }
        if(node.left!=null){
            sum+=node.left.val;
            if(dfs1(node.left,targetSum,sum))return true;
            sum-=node.left.val;
        }
        if(node.right!=null){
            sum+=node.right.val;
            if(dfs1(node.right,targetSum,sum))return true;
        }
        return false;
    }
    //代码随想录学习-修改代码随想录递归代码，是一种更清晰的切入方式，减法代替从0开始加。
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null&&targetSum==root.val){
            return true;
        }else if(root.left==null&&root.right==null&&targetSum==root.val){
            return false;
        }
        if(root.left!=null){
            if(hasPathSum(root.left,targetSum-root.val)) return true;
        }
        if(root.right!=null){
            if(hasPathSum(root.right,targetSum-root.val)) return true;
        }
        return false;
    }


}
