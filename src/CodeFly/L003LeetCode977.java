package CodeFly;

/**
 * ���������ƽ��-LeetCode:27-��������¼
 * 2023.08.18/22:06
 * ����:
 ����һ���� �ǵݼ�˳�� ������������� nums������ ÿ�����ֵ�ƽ�� ��ɵ������飬
 Ҫ��Ҳ�� �ǵݼ�˳�� ����
 *
 ʾ�� 1��
 ���룺nums = [-4,-1,0,3,10]
 �����[0,1,9,16,100]
 ���ͣ�ƽ���������Ϊ [16,1,0,9,100]
 ����������Ϊ [0,1,9,16,100]
 * tips:
 *    1.���ƽ������ѭ������
 *    2.˫ָ�룬����һ�ι鲢
 *
\
 */
public class L003LeetCode977 {
    public static void main(String[] args) {
        int[] test={-4,-1,0,3,10};
        sortedSquares1(test);
    }

    /**
     *�Լ�д��,������Math������ͻ��һ����(˫ָ��)
     * @param nums
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int flag=nums.length-1;
        int[] res=new int[nums.length];
        while(left<=right){
            int l=(int)Math.pow(Math.abs(nums[left]),2);
            int r=(int)Math.pow(Math.abs(nums[right]),2);
            if(l>r){
                res[flag--]=l;
                left++;
            }else if(l<r){
                res[flag--]=r;
                right--;
            }else{
                res[flag--]=l;
                left++;
            }
        }
        return res;
    }

    /**
     * �Ż����˫ָ��
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int flag=nums.length-1;
        int[] res=new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                res[flag--]=nums[left]*nums[left];
                left++;
            }else{
                res[flag--]=nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
