package CodeFly;

import java.util.Arrays;

/**
 *  无重叠区间-LeetCode:435-代码随想录
 * 2023.10.1/17.07

 题目:给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。 TIPS:
 TIPS;
 求重叠区间，不同于452，计数的时机不同，脑子僵化了哎，先不写算法了
 假如区间不重叠!一定要更新右边界的值!!!!!
 重叠则策略是删除右边界较大的，即保留较小的右边界。
 */

public class L0081LeetCode435 {
    public static void main(String[] args) {
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int end=intervals[0][1];
        int res=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                res++;
                end=Math.min(intervals[i][1],end);
            }else{
                end=intervals[i][1];
            }
        }
        return res;
    }
}
