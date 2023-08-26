package CodeFly;

/**
 * 原地反转字符串2-LeetCode:541-代码随想录
 * 2023.08.26/19.15

 题目:给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k
 个字符，就反转这 2k 字符中的前 k 个字符。如果剩余字符少于 k 个，则将
 剩余字符全部反转。如果剩余字符小于 2k 但大于或等于 k 个，则反转前
 k 个字符，其余字符保持原样。

*样例:
 * 示例 1：
 *
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * tips:
 * 按照自己的做法可能一个一个来可能会出现，明明有4个
 * 但是统计了一个后，还剩3个没统计，判断得错距离末尾
 * 不足2k，按照不足2k的if走，导致错误。
 * count++过程中与剩下的元素数产生冲突
*/

public class L0019LeetCode541 {
    public static void main(String[] args) {
        reverseStr1(new String("abcd"),2);
    }

    /**
     * 想法错误，一个一个处理，会产生区间的冲突，要一段一段处理，可以提前算出有几段
     * 循环段数，也可以直接加上一段的个数。
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
     * 看了解题后自己写的，这种一次处理一个区间的题可以直接跳过这个区间的值，更
     * 简便。
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
