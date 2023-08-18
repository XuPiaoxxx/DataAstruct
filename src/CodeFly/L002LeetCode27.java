package CodeFly;

/**
 * �Ƴ�Ԫ��-LeetCode:27-��������¼
 * 2023.08.17/20:58
 * ����:
 * ����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ�
 * �������Ƴ���������³��ȡ���Ҫʹ�ö��������ռ䣬������ʹ��O(1) ����ռ�
 * �� ԭ�� �޸��������顣Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����
 * Ԫ�ء�
 *
 *����:
 * ���룺nums = [3,2,2,3], val = 3
 * �����2, nums = [2,2]
 * ���ͣ�����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2���㲻��Ҫ����
 * �����г����³��Ⱥ����Ԫ�ء����磬�������ص��³���Ϊ 2 ����
 * nums = [2,2,3,3] �� nums = [2,2,0,0]��Ҳ�ᱻ������ȷ�𰸡�
 *
 * tips:
 * �Լ����뷨��ǰ��˫ָ�뽻����ά������ָ�룬������ѭ���ĵ�һ��ָ�룬��������
 * i���䣬���ж�iλ�Ƿ����������
 * earse()������length-1����������ǰ�ƣ�O(n).
 */
public class L002LeetCode27 {
    public static void main(String[] args) {

    }
    /**
     * �Ƴ�Ԫ��--�Լ�д����λ˫ָ��
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int tail=nums.length-1;
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==val){
                nums[i]=nums[tail];
                tail--;
                i--;
                length--;
            }
        }
        return length;
    }
    /**
     * �Ƴ�Ԫ��--ͬ�����ָ��
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
