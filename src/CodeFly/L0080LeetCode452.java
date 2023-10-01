package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  �����������ļ���������-LeetCode:452-��������¼
 * 2023.10.1/14.08

 ��Ŀ:��һЩ������������һ���� XY ƽ���ʾ��ǽ���ϡ�ǽ���ϵ������¼���������� points ������points[i] = [xstart, xend] ��ʾˮƽֱ���� xstart �� xend֮��������㲻֪�������ȷ�� y ���ꡣ

 һ֧������������ x ��Ӳ�ͬ�� ��ȫ��ֱ ������������� x �����һ֧��������һ�������ֱ���Ŀ�ʼ�ͽ�������Ϊ xstart��xend�� ������  xstart �� x �� xend���������ᱻ ���� ����������Ĺ��������� û������ �� ����һ�������֮�󣬿������޵�ǰ����

 ����һ������ points ����������������������������� ��С ������ ��
 TIPS:
 �����˼·�뷨��û��ģ�С�ط��д���
 1.Compare�Ƚ�������Ķ�������漰��2��31�η����(����-31�η�-31�η�)���϶��������ʱ����Integer���õ�compare�����Ƚϲ��������ԭ���Ժ󿴡�
 2.�����������ص�Ҳ���ǣ���ǰ��߽磬С�ڵ�����һ��������ұ߽磬��ô��ʱ��end����Ϊ��ǰ�ұ߽����һ��������ұ߽����Сֵ����������Ϊ�¸������ж��Ƿ��ܹ���һ�����������ṩ������

 */

public class L0080LeetCode452 {
    public static void main(String[] args) {
        int[][] temp=new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        findMinArrowShots(temp);
    }
    // TODO
    //
    // ����Ƚ��������ڲ��Ƚϣ����м���ʱ�򣬸���-�����漰�������������Integer���õ�compare�������������
    //ԭ��:    public static int compare(int x, int y) {
    //        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    //    }
    //�������ж����Ƚϣ��������ü������Ƚ�
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
