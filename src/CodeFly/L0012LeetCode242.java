package CodeFly;

/**
 * ��Ч��ĸ��λ-LeetCode:242-��������¼
 * 2023.08.25/11.21

 ��Ŀ:���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 ע�⣺�� s �� t ��ÿ���ַ����ֵĴ�������ͬ����� s �� t ��Ϊ��ĸ��λ�ʡ�
*����:
 ʾ�� 1:
 ����: s = "anagram", t = "nagaram"
 ���: true
 ʾ�� 2:
 ����: s = "rat", t = "car"
 ���: false
 *
 * tips:��Ŀ���ݷ�ΧС�Ĺ�ϣ��������������������±�䵱key����ӦֵΪvalue��
 * �����뷨����������Ӧλ��ͳ�����ַ����и���ĸ�ĳ��ִ����Ƿ����.
 */

public class L0012LeetCode242 {
    public static void main(String[] args) {

    }
    public  static boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
