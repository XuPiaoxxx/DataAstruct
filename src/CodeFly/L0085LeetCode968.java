package CodeFly;

/**
 *  监控二叉树-LeetCode:968-代码随想录
 * 2023.10.2/22.18

 题目:给定一个二叉树，我们在树的节点上安装摄像头。

 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

 计算监控树的所有节点所需的最小摄像头数量。
 TIPS:

 学习的代码随想录，要学会自己分析!!!!或者记住方法!!
 贪心思路，从底向上思考，采用后序遍历，根据左右返回的值进行操作。
 0未覆盖
 1有摄像头
 2覆盖
 如果为空节点，为了不影响叶子结点，返回2，反例就是0,1都是错误不符合思考

 如果左右都为2，则此节点一定未被覆盖，返回0
 如果左右节点任一为0，则当前节点一定要设置摄像头才能保证覆盖，返回1
 如果在2不满足的情况下，有任一左右节点为1（剩下的只能是1，或者2，都是被覆盖的），则当前节点被覆盖，返回2

 最后可能会出现根节点左右都为2，根节点被返回为0，不符合全部覆盖，所以在主函数中判断，如果根节点返回0，再给根节点一个监视器，res++;
 */

public class L0085LeetCode968 {
    public static void main(String[] args) {
    }
    int res=0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0) res++;
        return res;
    }

    public int dfs(TreeNode node){
        if(node==null) return 2;
        int l=dfs(node.left);
        int r=dfs(node.right);
        if(l==2&&r==2) return 0;
        if(l==0||r==0){
            res++;
            return 1;
        }
        if(l==1||r==1) return 2;
        return -1;
    }
}
