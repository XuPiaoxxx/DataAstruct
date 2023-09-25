package CodeFly;

import java.util.*;

/**
 *  全排列-LeetCode:46-代码随想录
 * 2023.09.25/12.21

 题目:给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 你可以 按任意顺序 返回答案。

 TIPS:
 全排列(和组合的解法用回溯有着千丝万缕的联系)
 方法是用一个used数组标记回溯树形结构上用过的元素，每次都从0开始，递归整个nums，遇到在该路径上用过的数(used【i】=true)表示，就跳过不处理。
 不用为了去重求组合来设置startIndex来传入下层遍历的开始下标(因为每次都全部遍历)

*/

public class L0065LeetCode46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res=new ArrayList();
    LinkedList<Integer> path=new LinkedList();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used=new boolean[nums.length];
        backTrack(nums);
        return res;
    }
    void backTrack(int[] nums){
        if(path.size()==nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            path.add(nums[i]);
            used[i]=true;
            backTrack(nums);
            used[i]=false;
            path.removeLast();
        }
    }

}
