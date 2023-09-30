package CodeFly;

/**
 *  ����ˮ����-LeetCode:860-��������¼
 * 2023.09.30/18.51

 ��Ŀ:������ˮ̯�ϣ�ÿһ������ˮ���ۼ�Ϊ 5 ��Ԫ���˿��Ŷӹ�����Ĳ�Ʒ�������˵� bills ֧����˳��һ�ι���һ����
 ÿλ�˿�ֻ��һ������ˮ��Ȼ�����㸶 5 ��Ԫ��10 ��Ԫ�� 20 ��Ԫ��������ÿ���˿���ȷ���㣬Ҳ����˵��������ÿλ�˿�����֧�� 5 ��Ԫ��
 ע�⣬һ��ʼ����ͷû���κ���Ǯ��
 ����һ���������� bills ������ bills[i] �ǵ� i λ�˿͸����ˡ�������ܸ�ÿλ�˿���ȷ���㣬���� true �����򷵻� false ��
 TIPS:
 ̰��,�������������������5,��Ϊ5������.
 5�Ĳ���
 10�Ĳ���
 20�����ֲ���
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
