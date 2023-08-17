package CodeFly;

/**
 * ���ֲ���-LeetCode:704-��������¼
 * 2023.08.17/20:32
 * ����:
 * ����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target��
 * дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
 *����:
 * ����: nums = [-1,0,3,5,9,12], target = 9
 * ���: 4
 * ����: 9 ������ nums �в����±�Ϊ 4
 *
 * tips:�߽�����,���ղ���
 * ��������ұջ�������ҿ���ѡ��ѭ������left��right�Ĺ�ϵ��
 * ����mid�ж�left��right�ĸ�ֵ
 * �߽�Ĺ���ͨ������Ķ�����
 */
public class LeetCode704 {
    public static void main(String[] args) {

    }

    /**
     * ����ҿ�
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int l=0;
        int r=nums.length;//��ͬ��
        int mid=r/2;
        while(l<r){
            if(target<nums[mid]){
                r=mid;
            }else if(target>nums[mid]){
                l=mid+1;
            }else {
                return mid;
            }
            mid=l+(r-l)/2;
        }
        return -1;
    }

    /**
     * ����ұ�
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while(left<=right){
            if(nums[mid]>target){
                right=mid-1;
                mid=left+(right-left)/2;
            }else if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }else{
                return mid;
            }
        }
        return -1;
    }

}
