package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  用最少数量的箭引爆气球-LeetCode:452-代码随想录
 * 2023.10.1/14.08

 题目:有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。

 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。

 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 TIPS:
 具体的思路想法是没错的，小地方有错误
 1.Compare比较器传入的对象，如果涉及到2的31次方溢出(比如-31次方-31次方)，肯定溢出，这时候用Integer内置的compare函数比较不会溢出，原理稍后看。
 2.当两个区间重叠也就是，当前左边界，小于等于上一个区间的右边界，那么这时候end更新为当前右边界和上一个数组的右边界的最小值，这样才能为下个数组判断是否能够在一箭的区间内提供条件。

 */

public class L0080LeetCode452 {
    public static void main(String[] args) {
        int[][] temp=new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(temp);
    }
    // TODO
    //
    // 假如比较器对象内部比较，进行减法时候，负数-正数涉及到溢出，可以用Integer内置的compare方法，不会溢出
    //原理:    public static int compare(int x, int y) {
    //        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    //    }
    //用条件判断来比较，而不是用减法来比较
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int end = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                end = points[i][1];
                res++;
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return res;
    }
}
