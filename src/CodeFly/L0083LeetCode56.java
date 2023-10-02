package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  合并区间-LeetCode:56-代码随想录
 * 2023.10.2/10.49

 题目:以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 TIPS;
 Lambda表达式自定义排序，贪心算法（局部-》全局）临时存储。
 */

public class L0083LeetCode56 {
    public static void main(String[] args) {
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> res =new ArrayList();
        Arrays.sort(intervals,(x, y)->Integer.compare(x[0],y[0]));
        int start=intervals[0][0];
        int right=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=right){
                right=Math.max(right,intervals[i][1]);
            }else{
                res.add(new int[]{start,right});
                start=intervals[i][0];
                right=intervals[i][1];
            }
        }
        res.add(new int[]{start,right});
        return res.toArray(new int[res.size()][]);
    }
}
