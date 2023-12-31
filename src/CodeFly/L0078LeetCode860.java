package CodeFly;

/**
 *  柠檬水找零-LeetCode:860-代码随想录
 * 2023.09.30/18.51

 题目:在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 注意，一开始你手头没有任何零钱。
 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 TIPS:
 贪心,尽可能在手里留更多的5,因为5更万能.
 5的策略
 10的策略
 20的两种策略
 */

public class L0078LeetCode860 {
    public static void main(String[] args) {
    }
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i:bills){
            if(i==5)five++;
            else if(i==10){
                if(five==0) return false;
                five--;
                ten++;
            }else if(i==20){
                if(ten>0&&five>0){
                    ten--;
                    five--;
                }
                else if(five>=3) five-=3;
                else return false;
            }
        }
        return true;
    }
}
