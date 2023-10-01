package CodeFly;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  ��������ؽ�����-LeetCode:406-��������¼
 * 2023.10.1/12.25

 ��Ŀ:�����д���˳���һȺ��վ��һ�����У����� people ��ʾ������һЩ�˵����ԣ���һ����˳�򣩡�ÿ�� people[i] = [hi, ki] ��ʾ�� i ���˵����Ϊ hi ��ǰ�� ���� �� ki ����ߴ��ڻ���� hi ���ˡ�

 �������¹��첢������������ people ����ʾ�Ķ��С����صĶ���Ӧ�ø�ʽ��Ϊ���� queue ������ queue[j] = [hj, kj] �Ƕ����е� j ���˵����ԣ�queue[0] �����ڶ���ǰ����ˣ��� TIPS:
 TIPS:
 ̰�ģ�����ά���ȷֱ����������ܲ����������Ļ����Ͻ�
 ������������java������ã���Ҫ����ĥ��
 LinkedList��add����������ָ��λ��
 �Զ��������ϸ��

 */

public class L0079LeetCode406 {
    public static void main(String[] args) {
        int[][] temp=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(temp);
    }
    // TODO
    //
    // Comparator������֧���������ͣ���int�����������͡�����int[][]����������
    // �ѽ��ܹ�����int��������ת����Integer�������飬�Ϳ����Զ���������
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });

        LinkedList<int[]> que=new LinkedList();

        for(int[] i:people){
            que.add(i[1],i);
        }
        return que.toArray(new int[people.length][]);
    }
}
