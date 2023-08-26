package CodeFly;

/**
 * ԭ�ط�ת�ַ���2-LeetCode:541-��������¼
 * 2023.08.26/19.15

 ��Ŀ:����һ���ַ��� s ��һ������ k�����ַ�����ͷ����ÿ������ 2k
 ���ַ����ͷ�ת�� 2k �ַ��е�ǰ k ���ַ������ʣ���ַ����� k ������
 ʣ���ַ�ȫ����ת�����ʣ���ַ�С�� 2k �����ڻ���� k ������תǰ
 k ���ַ��������ַ�����ԭ����

*����:
 * ʾ�� 1��
 *
 * ���룺s = "abcdefg", k = 2
 * �����"bacdfeg"
 * ʾ�� 2��
 * ���룺s = "abcd", k = 2
 * �����"bacd"
 * tips:
 * �����Լ�����������һ��һ�������ܻ���֣�������4��
 * ����ͳ����һ���󣬻�ʣ3��ûͳ�ƣ��жϵô����ĩβ
 * ����2k�����ղ���2k��if�ߣ����´���
 * count++��������ʣ�µ�Ԫ����������ͻ
*/

public class L0019LeetCode541 {
    public static void main(String[] args) {
        reverseStr1(new String("abcd"),2);
    }

    /**
     * �뷨����һ��һ���������������ĳ�ͻ��Ҫһ��һ�δ���������ǰ����м���
     * ѭ��������Ҳ����ֱ�Ӽ���һ�εĸ�����
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr1(String s, int k) {
        char[] cs = s.toCharArray();
        int count=0;
        for(int i=0;i<s.length();i++){
            count++;
            if(count==2*k){
                int l=i+1-2*k;
                int r=l+count/2-1;
                while(l<r){
                    cs[l]^=cs[r];
                    cs[r]^=cs[l];
                    cs[l]^=cs[r];
                    l++;
                    r--;
                }
                count=0;
                continue;
            }
            if(s.length()-1-i<k){
                int l=i+1;
                int r=s.length()-1;
                while(l<r){
                    cs[l]^=cs[r];
                    cs[r]^=cs[l];
                    cs[l]^=cs[r];
                    l++;
                    r--;
                }
                return String.valueOf(cs);
            }else if(s.length()-i<2*k&&s.length()-i-1>=k){
                int l=i;
                int r=i+k-1;
                while(l<r){
                    cs[l]^=cs[r];
                    cs[r]^=cs[l];
                    cs[l]^=cs[r];
                    l++;
                    r--;
                }
                return String.valueOf(cs);
            }
        }
        return String.valueOf(cs);
    }

    /**
     * ���˽�����Լ�д�ģ�����һ�δ���һ������������ֱ��������������ֵ����
     * ��㡣
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] cs=s.toCharArray();
        for(int i=0;i<cs.length;i+=2*k){
            if(i+k<=cs.length){
                reverse(cs,i,i+k);
                continue;
            }
            reverse(cs,i,cs.length);
        }
        return String.valueOf(cs);
    }
    public void reverse(char[] cs,int left, int right){
        while(left<right-1){
            cs[left]^=cs[right-1];
            cs[right-1]^=cs[left];
            cs[left]^=cs[right-1];
            left++;
            right--;
        }
    }
}
