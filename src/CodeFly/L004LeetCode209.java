package CodeFly;

/**
 * ���ֲ���-LeetCode:209-��������¼
 * 2023.08.19/18:36
 * ����:����һ������ n ���������������һ�������� target ��
 * �ҳ���������������� �� target �ĳ�����С�� ����������
 * [numsl, numsl+1, ..., numsr-1, numsr] ���������䳤�ȡ�
 * ��������ڷ��������������飬���� 0 ��
 *����:
 ���룺target = 7, nums = [2,3,1,2,4,3]
 �����2
 ���ͣ������� [4,3] �Ǹ������µĳ�����С�������顣
 *
 * tips:
 * ����ֱ�ӱ���ѭ����O(n��ƽ��)
    �������ڵľ�������ʼλ������ƶ�
 */
public class L004LeetCode209 {
    public static void main(String[] args) {

    }

    /**
     * �Լ�д��,�������ڣ�Ҳ����˫ָ��
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int i=0;
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            i+=nums[fast];
            while(i>=target){
                res=Math.min(res,fast-slow+1);
                i-=nums[slow++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
