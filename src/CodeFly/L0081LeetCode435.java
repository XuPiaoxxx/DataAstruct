package CodeFly;

import java.util.Arrays;

/**
 *  ���ص�����-LeetCode:435-��������¼
 * 2023.10.1/17.07

 ��Ŀ:����һ������ļ��� intervals ������ intervals[i] = [starti, endi] ������ ��Ҫ�Ƴ��������С������ʹʣ�����以���ص� �� TIPS:
 TIPS;
 ���ص����䣬��ͬ��452��������ʱ����ͬ�����ӽ����˰����Ȳ�д�㷨��
 �������䲻�ص�!һ��Ҫ�����ұ߽��ֵ!!!!!
 �ص��������ɾ���ұ߽�ϴ�ģ���������С���ұ߽硣
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
