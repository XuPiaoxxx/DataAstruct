package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  电话号码的字母组合-LeetCode:17-代码随想录
 * 2023.09.22/23.08

 题目:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 TIPS:
 涉及映射的处理，可以采用字符数组的方法实现，
 还涉及到通过ASCII码的差值来转换字符数字和int数字
 回溯算法的思路，为空为0的处理。
 回溯先取对应数字的映射，再进行这些对应字符得到循环遍历，同时递归回溯处理
 下一个数字对应的字符串(通过下标取得映射)
 终止条件为下标的值等于总数字字符串额长度，也就是递归次数到达数字字符次数+1


*/

public class L0057LeetCode17 {
    static int total=0;
    public static void main(String[] args) {


    }
    //代码随想录，回溯算法+小技巧处理，映射，转换很重要，数组集合存储，字符串存储，StringBulider的增删很方便
    List<String> res=new ArrayList();
    StringBuilder sb=new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)return res;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(digits,map,0);
        return res;
    }
    public void backTrack(String digits,String[] map,int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String temp = map[digits.charAt(start) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            backTrack(digits, map, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
