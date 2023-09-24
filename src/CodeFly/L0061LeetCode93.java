package CodeFly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  复原 IP 地址-LeetCode:93-代码随想录
 * 2023.09.24/13.00

 题目:有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 TIPS:
 本题本质还是分割问题，但是对每一次分出来的数组有规则限制。
 代码随想录是用pointNum来控制条件终止
 这里我用更容易懂操作，符合JAVA的数组拼接来实现。

 判断是否合法需要单独编写，多动脑转变思路
 写之前规划好。
    认真读题
 注意分割出去的部分，用于接收的问题，可以开辟数组进行接受。
 也可以直接进行处理加入到最终的返回结果中。
 Integer.ValueOf返回Integer包装类
 Integer.parseInt返回int

*/

public class L0061LeetCode93 {
    public static void main(String[] args) {

    }
    List<String> res=new ArrayList();
    LinkedList<String> path=new LinkedList();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0);
        return res;
    }
    public void backTrack(String s,int start){
        if(path.size()==4){
            String sb=String.join(".",path);
            if(sb.length()==s.length()+3){
                res.add(sb);
            }
            return;
        }
        for(int i=start;i<s.length();i++){
            if(!isValid(s,start,i+1)) break;
            path.add(s.substring(start,i+1));
            backTrack(s,i+1);
            path.removeLast();
        }
    }
    public boolean isValid(String s,int start,int end){
        int temp=Integer.parseInt(s.substring(start,end));
        if(end>start+1&&s.charAt(start)=='0') return false;
        if(temp<0||temp>255) return false;
        return true;
    }
}
