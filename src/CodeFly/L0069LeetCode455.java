package CodeFly;

import java.util.Arrays;

/**
 *  分发饼干-LeetCode:455-代码随想录
 * 2023.09.26/18.43

 题目:假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最
 小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可
 以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越
 多数量的孩子，并输出这个最大数值。
 TIPS:
 贪心无套路，看运气，看经验，看悟性。
 本题可以排序+双指针
 1.从大的开始，尽量用大饼干满足大胃
 2.从小的开始，用尽量小的饼干满足小胃


*/

public class L0069LeetCode455 {
    public static void main(String[] args) {
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(g[i]<=s[j]){
                res++;
                i++;
                j++;
            }else if(g[i]>s[j]){
                j++;
            }
        }
        return res;
    }

}
