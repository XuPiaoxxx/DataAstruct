package CodeFly;

/**
 * 删除二叉搜索树中的节点-LeetCode:450-代码随想录
 * 2023.09.18/17.54

 题目:给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的
 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新
 ）的根节点的引用。
 一般来说，删除节点可分为两个步骤：
 首先找到需要删除的节点；
 如果找到了，删除它。
 TIPS:
 首先进行分析。
 遍历顺序无所谓，终止条件在最上面。
 采用重新构建二叉树左右节点指向的策略。
 每次都重新设置node.left和node.right
 当节点为空，依然返回空。
 当节点的值等于key，进行删除操作:
 1.一侧节点为空，则返回不为空的那个节点，相当于略过了当前node
 2.两侧都为空，直接return root，删除当前节点
 3.两侧都不为空，两种选择:
    (1)左节点取代当前节点，右节点放到左节点的最右侧的右边。（通过一个cur变量循环找到最右侧为空的节点）
    (2)右节点取代当前节点...同理
 正常递归逻辑：
 当key<当前节点的值，证明目标值不可能在右边，只递归左边并给left指针赋值，当key大于当前节点的值，同理。
 最后返回node，证明如常返回当前节点，当前节点不符合条件。不做更改

*/

public class L0051LeetCode450 {
    public static void main(String[] args) {

    }
    //代码随想录，递归方法，每次向上返回节点，重新进行左右指针的赋值
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            if(root.left==null&&root.right==null){
                return null;
            }else if(root.left!=null&&root.right==null){
                return root.left;
            }else if(root.left==null&&root.right!=null){
                return root.right;
            }else{
                TreeNode cur=root.right;
                while(cur.left!=null){
                    cur=cur.left;
                }
                cur.left=root.left;
                return root.right;
            }
        }//剪枝，不是所以节点都要遍历，至少一半节点不需要，这是二叉搜索树的特性
//        root.left=deleteNode(root.left,key);
//        root.right=deleteNode(root.right,key);
        if(key<root.val) root.left=deleteNode(root.left,key);
        if(key>root.val) root.right=deleteNode(root.right,key);
        return root;
    }
}
