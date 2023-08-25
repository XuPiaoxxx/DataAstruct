package CodeFly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
 *
 * �����д��еĶ��ֽⷨ:�ַ�����Ƚϣ�Map��ϣ��Աȣ���������Ƚϣ�ֱ�ӷ��ط����ıȽ�
 *
 */

public class L0012LeetCode242 {
    public static void main(String[] args) {
    }
    /**
     * ��һ�������ϣ�����Ƿ�26��λ�ö�Ϊ0
     * @param s
     * @param t
     * @return
     */
    public  static boolean isAnagram0(String s, String t) {
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
    public boolean isAnagram1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
    public boolean isAnagram3(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram4(String s, String t) {
        int[] counts = new int[26];
        t.chars().forEach(tc -> counts[tc - 'a']++);
        s.chars().forEach(cs -> counts[cs - 'a']--);
        return Arrays.stream(counts).allMatch(c -> c == 0);
    }
    public boolean isAnagram(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(), t.chars().sorted().toArray());
    }

}
