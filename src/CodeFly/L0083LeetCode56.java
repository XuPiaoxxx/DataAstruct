package CodeFly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  �ϲ�����-LeetCode:56-��������¼
 * 2023.10.2/10.49

 ��Ŀ:������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ��
 ����ϲ������ص������䣬������ һ�����ص����������飬��������ǡ�ø��������е��������� ��

 TIPS;
 Lambda���ʽ�Զ�������̰���㷨���ֲ�-��ȫ�֣���ʱ�洢��
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
