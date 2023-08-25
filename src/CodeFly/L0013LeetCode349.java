package CodeFly;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������Ľ���-LeetCode:349-��������¼
 * 2023.08.25/11.41

 ��Ŀ:������������ nums1 �� nums2 ������ ���ǵĽ��� ���������е�ÿ��Ԫ��
 һ���� Ψһ �ġ����ǿ��� ��������������˳�� ��
*����:
 ʾ�� 1��
 ���룺nums1 = [1,2,2,1], nums2 = [2,2]
 �����[2]
 ʾ�� 2��
 ���룺nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 �����[9,4]
 ���ͣ�[4,9] Ҳ�ǿ�ͨ����
 *
 * tips:
 */

public class L0013LeetCode349 {
    public static void main(String[] args) {

    }

    /**
     * �½��˸������ײ��������洢���ô��ǲ��漰��ת�������⡣
     * ��ν�ArrayListת��Ϊ����:JAVA8����·�ʽ
     * // ��Ҫת����int[]���ͣ��͵���ת��IntStream��
     * // �����ͨ��mapToInt()��Stream<Integer>����Integer::valueOf��ת��IntStream
     * // ��IntStream��Ĭ��toArray()ת��int[]��
     * int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
     * ��ѯ��֪intValue��ʱ1ms��valueOf��ʱ2ms��
     * ��ΪmapToInt��������T����int�ͣ�
     * ǰ���Ǳ�Ϊint�������Ǳ�ΪInteger�����Ż���Ҫ����Integer��int�Ĳ���
     * ���Ժ�����
     *
     * ������һ������һ��set�������СΪ1000����һ����������е���Ϊ1���ڶ����ж϶�Ӧλ��Ϊ1��
     * ��ӵ�set������
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet();
        Set<Integer> set2=new HashSet();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i]))set2.add(nums2[i]);
        }
        int[] arr=new int[set2.size()];
        int i=0;
        for(Integer n : set2){
            arr[i]=n;
            i++;
        }
        return arr;
    }
}
