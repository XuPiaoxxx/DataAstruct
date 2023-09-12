package CodeFly;

import java.util.List;

/**
 * 二叉树的所用路径-LeetCode:257-代码随想录
 * 2023.09.12/12.24

 题目:给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * tips:
 * 根据题目的意思，需要记录节点遍历的路径，所以使用
 * 先序遍历，收集节点的值
 * 其中分别用两个数组，第一个数组保存遍历路径存的值，第二个数组
 * 保存最终结果。
 *
 *
 *
*/

public class L0037LeetCode257 {
    public static void main(String[] args) {

    }
    //先序遍历
    public void dfs(TreeNode node, List<Integer> list, List<String> string){
        list.add(node.val);
        if(node.left==null&&node.right==null){
            StringBuilder sb=new StringBuilder();
            sb.append(list.get(0));
            for(int i=1;i<list.size();i++){
                sb.append("->"+list.get(i));
            }
            string.add(sb.toString());
        }
        if(node.left!=null){
            dfs(node.left,list,string);
            list.remove(list.size()-1);
        }
        if(node.right!=null){
            dfs(node.right,list,string);
            list.remove(list.size()-1);
        }
    }
}
